package com.minecolonies.coremod.client.gui.townhall;

import com.ldtteam.blockui.controls.Button;
import com.ldtteam.blockui.controls.ButtonHandler;
import com.ldtteam.blockui.controls.Image;
import com.ldtteam.blockui.views.BOWindow;
import com.minecolonies.api.colony.IColonyView;
import com.minecolonies.api.util.constant.Constants;
import com.minecolonies.coremod.Network;
import com.minecolonies.coremod.colony.ColonyView;
import com.minecolonies.coremod.network.messages.server.colony.HireMercenaryMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import org.jetbrains.annotations.NotNull;

import static com.minecolonies.api.util.constant.WindowConstants.BUTTON_DONE;

/**
 * Gui for hiring mercenaries
 */
public class WindowTownHallMercenary extends BOWindow implements ButtonHandler
{
    /**
     * The xml file for this gui
     */
    private static final String TOWNHALL_NAME_RESOURCE_SUFFIX = ":gui/townhall/windowtownhallmercenary.xml";

    /**
     * The client side colony data
     */
    private final IColonyView colony;

    /**
     * Constructor for a town hall rename entry window.
     *
     * @param c {@link ColonyView}
     */
    public WindowTownHallMercenary(final IColonyView c)
    {
        super(new ResourceLocation(Constants.MOD_ID + TOWNHALL_NAME_RESOURCE_SUFFIX));
        this.colony = c;

        int amountOfMercenaries = colony.getCitizenCount();
        amountOfMercenaries = amountOfMercenaries / 10;
        amountOfMercenaries += 3;

        int startX = 160;
        final int startY = 40;

        for (int i = 0; i < amountOfMercenaries; i++)
        {
            final Image newImage = new Image();
            newImage.setImage(new ResourceLocation("minecolonies:textures/entity_icon/citizenmale3.png"), false);
            newImage.setSize(10, 10);
            newImage.setPosition(startX, startY);
            this.addChild(newImage);

            startX += 15;
        }
    }

    @Override
    public void onButtonClicked(@NotNull final Button button)
    {
        if (button.getID().equals(BUTTON_DONE))
        {
            colony.usedMercenaries();
            Network.getNetwork().sendToServer(new HireMercenaryMessage(colony));
            Minecraft.getInstance().player.playSound(SoundEvents.LIGHTNING_BOLT_THUNDER, 1.0f, 1.0f);
        }

        this.close();
    }
}
