package com.spikes2212.robot.commands;


import com.spikes2212.genericsubsystems.commands.MoveBasicSubsystem;
import com.spikes2212.robot.subsystems.Elevator;

public class MoveElevator extends MoveBasicSubsystem {

    private Elevator.ElevatorState targetPosition;



    public MoveElevator(Elevator elevator, Elevator.ElevatorState targetPosition) {
        super(elevator, () -> (elevator.getState().getIndex() < targetPosition.getIndex())
                ? Elevator.SPEED.get() : -Elevator.SPEED.get());
        this.targetPosition = targetPosition;
    }

    @Override
    protected void initialize() {
        super.initialize();
    }

    @Override
    protected boolean isFinished() {
        return ((Elevator) basicSubsystem).getState() == targetPosition || isTimedOut();

    }
}
