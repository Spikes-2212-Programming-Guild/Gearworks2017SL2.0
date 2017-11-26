package com.spikes2212.robot;

import com.ctre.CANTalon;
import com.spikes2212.utils.DoubleSpeedcontroller;
import edu.wpi.first.wpilibj.SpeedController;

public class Subsystems {
    public static class Drivetrain {
        public static SpeedController leftSP = new DoubleSpeedcontroller(
            new CANTalon(RobotMap.CAN.DRIVETRAIN_LEFT_1), new CANTalon(RobotMap.CAN.DRIVETRAIN_LEFT_2)
        );

        public static SpeedController rightSP = new DoubleSpeedcontroller(
                new CANTalon(RobotMap.CAN.DRIVETRAIN_RIGHT_1), new CANTalon(RobotMap.CAN.DRIVETRAIN_RIGHT_2)
        );
    }

    public static class Shooter {

    }

    public static class GearSystems {

    }
}
