package com.spikes2212.robot;

import com.ctre.CANTalon;
import com.spikes2212.utils.DoubleSpeedcontroller;
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

    public static class GearSystems {

    }
}
