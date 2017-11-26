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


        int speedMul = (elevator.getPosition().getIndex() > targetPosition.getIndex()) ? -1 : 1;

        this.speedSupplier = () -> speedMul * speedSupplier.get();
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
