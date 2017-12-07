package com.spikes2212.robot;


import com.spikes2212.utils.XboXUID;
import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI /*GEVALD*/ {

    private Joystick driverLeft = new Joystick(0);
    private Joystick driverRight = new Joystick(1);

    private XboXUID navigatorXboxUID = new XboXUID(2);

    public OI() {
        initButtons();
        initDriver();
    }

    private void initDriver() {

    }

    private void initButtons() {

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
