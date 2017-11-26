package com.spikes2212.robot.commands;


import com.spikes2212.genericsubsystems.commands.MoveBasicSubsystem;
import com.spikes2212.robot.subsystems.Elevator;

import java.util.function.Supplier;

public class MoveGearLift extends MoveBasicSubsystem {

    private Elevator.ElevatorState targetPosition;

    public MoveGearLift(Elevator elevator, Supplier<Double> absoluteSpeedSupplier,
                        Elevator.ElevatorState targetPosition) {
        super(elevator, absoluteSpeedSupplier);
        this.targetPosition = targetPosition;

        int speedMul = targetPosition.getIndex() - ((Elevator) basicSubsystem).getPosition().getIndex();
        final int speedSign = speedMul / Math.abs(speedMul);

        speedSupplier = () -> speedSupplier.get() * (double) speedSign;
    }

    @Override
    protected void initialize() {
        super.initialize();
    }

    @Override
    protected boolean isFinished() {
        return ((Elevator) basicSubsystem).getPosition() == targetPosition || isTimedOut();

    }
}
