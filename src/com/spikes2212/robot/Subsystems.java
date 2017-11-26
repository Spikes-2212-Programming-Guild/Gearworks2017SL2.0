package com.spikes2212.robot;

import com.ctre.CANTalon;
import com.spikes2212.utils.DoubleSpeedcontroller;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;

public class Subsystems {
    public static class Drivetrain {
        public static SpeedController leftSP = new DoubleSpeedcontroller(
            new CANTalon(RobotMap.CAN.LEFT_ONE), new CANTalon(RobotMap.CAN.LEFT_TWO)
        );

        public static SpeedController rightSP = new DoubleSpeedcontroller(
                new CANTalon(RobotMap.CAN.RIGHT_ONE), new CANTalon(RobotMap.CAN.RIGHT_TWO)
        );
    }

    public static class Shooter {

    }

    public static class GearElevator {
        public static SpeedController gearElevatorSP = new CANTalon(RobotMap.CAN.LIFT);
        public static DigitalInput maxLimit = new DigitalInput(RobotMap.DIO.LIFT_LIMIT_MAX);
        public static DigitalInput minLimit = new DigitalInput(RobotMap.DIO.LIFT_LIMIT_MIN);
        public static Encoder liftEncoder = new Encoder(RobotMap.DIO.LIFT_ENCODER_ONE,
                RobotMap.DIO.LIFT_ENCODER_TWO);
    }
}
