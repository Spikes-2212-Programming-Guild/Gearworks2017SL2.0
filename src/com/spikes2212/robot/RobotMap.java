package com.spikes2212.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static class CAN {
        public static final int DRIVE_LEFT_1 = 0;
        public static final int DRIVE_LEFT_2 = 1;
        public static final int DRIVE_RIGHT_1 = 2;
        public static final int DRIVE_RIGHT_2 = 3;
        public static final int ELEVATOR = 4;
        public static final int ROLLER_GRIPPER = 5;

        private CAN(){}
    }

    public static class DIO {
        public static final int LIFT_LIMIT_MAX = 0;
        public static final int LIFT_LIMIT_MIN = 1;

        public static final int LIFT_ENCODER_ONE = 2;
        public static final int LIFT_ENCODER_TWO = 3;
        public static final int ROLLER_GRIPPER_COLOR_SENSOR = 4;

        private DIO() {}
    }
}
