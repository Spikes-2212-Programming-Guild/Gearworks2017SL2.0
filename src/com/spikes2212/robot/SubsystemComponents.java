package com.spikes2212.robot;

import com.ctre.CANTalon;
import com.spikes2212.utils.DoubleSpeedcontroller;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;

public class SubsystemComponents {
    public static class DrivetrainComponents {
        public static SpeedController leftSP = new DoubleSpeedcontroller(
            new CANTalon(RobotMap.CAN.DRIVE_LEFT_1), new CANTalon(RobotMap.CAN.DRIVE_LEFT_2)
        );

        public static SpeedController rightSP = new DoubleSpeedcontroller(
                new CANTalon(RobotMap.CAN.DRIVE_RIGHT_1), new CANTalon(RobotMap.CAN.DRIVE_RIGHT_2)
        );
    }

    public static class ElevatorComponents {
        public static SpeedController elevatorSP = new CANTalon(RobotMap.CAN.ELEVATOR);
        public static DigitalInput maxLimit = new DigitalInput(RobotMap.DIO.ELEVATOR_LIMIT_MAX);
        public static DigitalInput minLimit = new DigitalInput(RobotMap.DIO.ELEVATOR_LIMIT_MIN);
        public static Encoder encoder = new Encoder(RobotMap.DIO.ELEVATOR_ENCODER_A,
                RobotMap.DIO.ELEVATOR_ENCODER_B);
    }

    public static class RollerGripperComponents {
        public static SpeedController rollerGripperSP = new CANTalon(RobotMap.CAN.ROLLER_GRIPPER);
        public static DigitalInput colorSensor =
                new DigitalInput(RobotMap.DIO.ROLLER_GRIPPER_COLOR_SENSOR);
    }

    public static class GearPickerComponents {
        public static SpeedController gearPickerSP = new CANTalon(RobotMap.CAN.GEAR_PICKER);
        public static DigitalInput maxLimit = new DigitalInput(RobotMap.DIO.GEAR_PICKER_LIMIT_MAX);
        public static DigitalInput minLimit = new DigitalInput(RobotMap.DIO.GEAR_PICKER_LIMIT_MIN);
        public static AnalogPotentiometer potentiometer =
                new AnalogPotentiometer(RobotMap.AnalogInput.GEAR_PICKER_PATENTIOMENTER);
    }
}
