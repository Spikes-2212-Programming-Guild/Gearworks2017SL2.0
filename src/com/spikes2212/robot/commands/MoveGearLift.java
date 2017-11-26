package com.spikes2212.robot.commands;


import com.spikes2212.genericsubsystems.commands.MoveBasicSubsystem;
import com.spikes2212.robot.subsystems.GearElevator;

import java.util.function.Supplier;

public class MoveGearLift extends MoveBasicSubsystem {

    private GearElevator.ElevatorState targetPosition;

    public MoveGearLift(GearElevator gearElevator, Supplier<Double> absoluteSpeedSupplier,
                        GearElevator.ElevatorState targetPosition) {
        super(gearElevator, absoluteSpeedSupplier);
        this.targetPosition = targetPosition;

        int speedMul = targetPosition.getIndex() - ((GearElevator) basicSubsystem).getPosition().getIndex();
        final int speedSign = speedMul / Math.abs(speedMul);

        speedSupplier = () -> speedSupplier.get() * (double) speedSign;
    }

    @Override
    protected void initialize() {
        super.initialize();
    }

    @Override
    protected boolean isFinished() {
        return ((GearElevator) basicSubsystem).getPosition() == targetPosition || isTimedOut();

    }
}
