package com.spikes2212.robot.commands;


import com.spikes2212.genericsubsystems.commands.MoveBasicSubsystem;
import com.spikes2212.robot.subsystems.GearLift;
import com.spikes2212.robot.subsystems.GearLift;

import java.util.function.Supplier;

public class MoveGearLift extends MoveBasicSubsystem {

    private GearLift.LiftPosition targetPosition;

    public MoveGearLift(GearLift gearLift, Supplier<Double> absoluteSpeedSupplier,
                        GearLift.LiftPosition targetPosition) {
        super(gearLift, absoluteSpeedSupplier);
        this.targetPosition = targetPosition;
    }
}
