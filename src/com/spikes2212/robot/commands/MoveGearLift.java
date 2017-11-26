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

        int speedMul = targetPosition.getIndex() - ((GearLift) basicSubsystem).getPosition().getIndex();
        final int speedSign = speedMul / Math.abs(speedMul);

        speedSupplier = () -> speedSupplier.get() * (double) speedSign;
    }

    @Override
    protected void initialize() {
        super.initialize();
    }

    @Override
    protected boolean isFinished() {
        return ((GearLift) basicSubsystem).getPosition() == targetPosition || isTimedOut();

    }
}
