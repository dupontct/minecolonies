package com.minecolonies.coremod.colony.buildings.modules;

import com.minecolonies.api.colony.ICitizenData;
import com.minecolonies.api.colony.buildings.IBuilding;
import com.minecolonies.api.colony.buildings.IBuildingWorkerModule;
import com.minecolonies.api.colony.buildings.modules.*;
import com.minecolonies.api.colony.jobs.registry.JobEntry;
import com.minecolonies.api.entity.citizen.AbstractEntityCitizen;
import com.minecolonies.api.entity.citizen.Skill;
import com.minecolonies.coremod.util.AttributeModifierUtils;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.util.Optional;
import java.util.function.Function;

import static com.minecolonies.api.util.constant.CitizenConstants.SKILL_BONUS_ADD;

/**
 * Assignment module for couriers
 */
public class DeliverymanAssignmentModule extends WorkerBuildingModule implements IBuildingEventsModule, ITickingModule, IPersistentModule, IBuildingWorkerModule, ICreatesResolversModule
{
    public DeliverymanAssignmentModule(final JobEntry entry,
      final Skill primary,
      final Skill secondary,
      final boolean canWorkingDuringRain,
      final Function<IBuilding, Integer> sizeLimit)
    {
        super(entry, primary, secondary, canWorkingDuringRain, sizeLimit);
    }

    @Override
    void onRemoval(final ICitizenData citizen)
    {
        super.onRemoval(citizen);
        final Optional<AbstractEntityCitizen> optCitizen = citizen.getEntity();
        optCitizen.ifPresent(entityCitizen -> AttributeModifierUtils.removeModifier(entityCitizen, SKILL_BONUS_ADD, Attributes.MOVEMENT_SPEED));
    }
}
