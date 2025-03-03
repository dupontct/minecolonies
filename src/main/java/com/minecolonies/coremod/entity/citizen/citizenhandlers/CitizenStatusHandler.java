package com.minecolonies.coremod.entity.citizen.citizenhandlers;

import com.minecolonies.api.entity.ai.Status;
import com.minecolonies.api.entity.citizen.AbstractEntityCitizen;
import com.minecolonies.api.entity.citizen.citizenhandlers.ICitizenStatusHandler;
import com.minecolonies.coremod.MineColonies;
import net.minecraft.network.chat.Component;

import java.util.Objects;

import static com.minecolonies.api.util.constant.CitizenConstants.MAX_LINES_OF_LATEST_LOG;

/**
 * Handles the status updates of the citizen.
 */
public class CitizenStatusHandler implements ICitizenStatusHandler
{
    /**
     * The citizen assigned to this manager.
     */
    private final AbstractEntityCitizen citizen;

    /**
     * The Current Status.
     */
    protected Status status = Status.IDLE;

    /**
     * Whether the status display is enabled
     */
    private boolean enabled = MineColonies.getConfig().getServer().enableInDevelopmentFeatures.get();

    /**
     * The 4 lines of the latest status.
     */
    private final Component[] latestStatus = new Component[MAX_LINES_OF_LATEST_LOG];

    /**
     * Constructor for the experience handler.
     *
     * @param citizen the citizen owning the handler.
     */
    public CitizenStatusHandler(final AbstractEntityCitizen citizen)
    {
        this.citizen = citizen;
    }

    /**
     * Get the latest status of the citizen.
     *
     * @return a Component with the length 4 describing it.
     */
    @Override
    public Component[] getLatestStatus()
    {
        return latestStatus.clone();
    }

    /**
     * Set the latest status of the citizen and clear the existing status
     *
     * @param status the new status to set.
     */
    @Override
    public void setLatestStatus(final Component... status)
    {
        if (!enabled)
        {
            return;
        }

        boolean hasChanged = false;
        for (int i = 0; i < latestStatus.length; i++)
        {
            final Component newStatus;
            if (i >= status.length)
            {
                newStatus = null;
            }
            else
            {
                newStatus = status[i];
            }

            if (!Objects.equals(latestStatus[i], newStatus))
            {
                latestStatus[i] = newStatus;
                hasChanged = true;
            }
        }

        if (hasChanged)
        {
            citizen.markDirty();
        }
    }

    /**
     * Append to the existing latestStatus list. This will override the oldest one if full and move the others one down in the array.
     *
     * @param status the latest status to append
     */
    @Override
    public void addLatestStatus(final Component status)
    {
        System.arraycopy(latestStatus, 0, latestStatus, 1, latestStatus.length - 1);
        latestStatus[0] = status;
        citizen.markDirty();
    }

    /**
     * Getter for the current status.
     *
     * @return the status.
     */
    @Override
    public Status getStatus()
    {
        return status;
    }

    /**
     * Setter for the current status.
     *
     * @param status the status to set.
     */
    @Override
    public void setStatus(final Status status)
    {
        this.status = status;
    }
}
