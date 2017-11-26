package com.spikes2212.robot.commands;


import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.commands.MoveBasicSubsystem;
import com.spikes2212.robot.subsystems.Elevator;
import com.sun.xml.internal.xsom.impl.Ref;

import java.util.function.Supplier;

public class MoveElevator extends MoveBasicSubsystem {

    private Elevator.ElevatorState targetPosition;



    public MoveElevator(Elevator elevator, Elevator.ElevatorState targetPosition) {
        super(elevator, () -> (elevator.getPosition().getIndex() > targetPosition.getIndex())
                ? Elevator.SPEED.get() : -Elevator.SPEED.get());
        this.targetPosition = targetPosition;
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
