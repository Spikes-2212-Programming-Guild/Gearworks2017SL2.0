package com.spikes2212.robot;


import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.commands.MoveBasicSubsystem;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveArcade;
import com.spikes2212.robot.commands.MoveElevator;
import com.spikes2212.robot.subsystems.Elevator;
import com.spikes2212.utils.XboXUID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import java.util.function.Supplier;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI /*GEVALD*/ {

    public static final Supplier<Double> ROLLER_GRIPPER_SPEED = ConstantHandler.addConstantDouble(
            "Roller-Gripper-Speed", 0.2);

    private Joystick driverLeft = new Joystick(0);
    private Joystick driverRight = new Joystick(1);

    private XboXUID navigatorXboxUID = new XboXUID(2);

    public OI() {
        initButtons();
        initDriver();
    }

    private void initDriver() {
        Robot.drivetrain.setDefaultCommand(new DriveArcade(Robot.drivetrain, this::getLeftX, this::getRightY));
    }

    private void initButtons() {
        Button elevatorUpButton = navigatorXboxUID.getRedButton();
        Button elevatorDownButton = navigatorXboxUID.getGreenButton();
        Button elevatorMiddleButton = navigatorXboxUID.getBlueButton();

        Button collectGearButton = navigatorXboxUID.getLbButton();

        elevatorUpButton.whileHeld(new MoveElevator(Robot.elevator, Elevator.ElevatorState.UP));
        elevatorDownButton.whileHeld(new MoveElevator(Robot.elevator, Elevator.ElevatorState.DOWN));
        elevatorMiddleButton.whileHeld(new MoveElevator(Robot.elevator, Elevator.ElevatorState.MIDDLE));

        collectGearButton.whileHeld(new MoveBasicSubsystem(Robot.rollerGripper, ROLLER_GRIPPER_SPEED));
    }

    private double adjustInput(double input) {
        return input * Math.abs(input);
    }

    public double getLeftX() {
        return adjustInput(driverLeft.getX());
    }

    public double getRightY() {
        return adjustInput(driverRight.getY());
    }
}
