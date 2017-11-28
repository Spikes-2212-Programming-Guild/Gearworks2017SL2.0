package com.spikes2212.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static final class CAN {
        public static final int DRIVE_LEFT_1 = 0;
        public static final int DRIVE_LEFT_2 = 1;
        public static final int DRIVE_RIGHT_1 = 2;
        public static final int DRIVE_RIGHT_2 = 3;
        public static final int ELEVATOR = 4;
        public static final int ROLLER_GRIPPER = 5;

        public static final int GEAR_FOLDER = 6;

        private CAN(){}
    }

    public static final class DIO {
        public static final int ELEVATOR_LIMIT_MAX = 0;
        public static final int ELEVATOR_LIMIT_MIN = 1;

        public static final int ELEVATOR_ENCODER_A = 2;
        public static final int ELEVATOR_ENCODER_B = 3;

        public static final int ROLLER_GRIPPER_COLOR_SENSOR = 4;

        public static final int GEAR_FOLDER_LIMIT_MAX = 5;
        public static final int GEAR_FOLDER_LIMIT_MIN = 6;
        private DIO() {}
    }

    public static final class AnalogInput {
        public static final int GEAR_FOLDER_POTENTIOMETER = 1;
        private AnalogInput(){}
    }
}
