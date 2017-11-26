package com.spikes2212.robot;

import com.ctre.CANTalon;
import com.spikes2212.utils.DoubleSpeedcontroller;
import edu.wpi.first.wpilibj.SpeedController;

public class Subsystems {
    public static class Drivetrain {
        public static SpeedController leftSP = new DoubleSpeedcontroller(
            new CANTalon(RobotMap.CAN.DRIVE_LEFT_1), new CANTalon(RobotMap.CAN.DRIVE_LEFT_2)
        );

        public static SpeedController rightSP = new DoubleSpeedcontroller(
                new CANTalon(RobotMap.CAN.DRIVE_RIGHT_1), new CANTalon(RobotMap.CAN.DRIVE_RIGHT_2)
        );
    }

    public static class Shooter {

    }
}
