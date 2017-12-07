package com.spikes2212.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static final class CAN {
        public static final int DRIVE_LEFT_1 = 1;
        public static final int DRIVE_LEFT_2 = 2;
        public static final int DRIVE_RIGHT_1 = 3;
        public static final int DRIVE_RIGHT_2 = 4;

        public static final int FOLDER = 0;

        private CAN(){}
    }

    public static final class PWM {
        public static final int ELEVATOR = 0;
        public static final int ROLLER = 1;
    }

    public static final class DIO {
        public static final int ELEVATOR_LIMIT_MAX = 8;
        public static final int ELEVATOR_LIMIT_MIN = 9;

        public static final int ELEVATOR_ENCODER_A = 3;
        public static final int ELEVATOR_ENCODER_B = 4;

        public static final int ROLLER_SENSOR = 6;

        public static final int FOLDER_LIMIT_MAX = 5;
        public static final int FOLDER_LIMIT_MIN = 7;
        private DIO() {}
    }

    public static final class AnalogInput {
        public static final int FOLDER_POTENTIOMETER = 0;
        private AnalogInput(){}
    }
    public static final class JOYSTICK {

        public static final int JOYSTICK_1 = 0;
        public static final int JOYSTICK_2 = 1;

        public static final int XBOXUID = 3;

        private JOYSTICK() {}
    }
}
