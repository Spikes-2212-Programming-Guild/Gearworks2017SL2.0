package com.spikes2212.robot.commands;


import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.commands.MoveBasicSubsystem;
import com.spikes2212.robot.subsystems.Elevator;

import java.util.function.Supplier;

public class MoveGearElevator extends MoveBasicSubsystem {

    private Elevator.ElevatorState targetPosition;

    public static final Supplier<Double> SPEED = ConstantHandler.addConstantDouble("Elevator-Speed", 0.2);

    public MoveGearElevator(Elevator elevator, Elevator.ElevatorState targetPosition) {
        super(elevator, SPEED);
        this.targetPosition = targetPosition;

        this.speedSupplier = () -> (elevator.getPosition().getIndex() > targetPosition.getIndex())
                ? SPEED.get() : -SPEED.get();
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
