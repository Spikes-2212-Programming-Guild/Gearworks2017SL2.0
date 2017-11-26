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
    }
}
