
package com.spikes2212.robot;

import com.spikes2212.genericsubsystems.drivetrains.TankDrivetrain;
import com.spikes2212.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


public class Robot extends IterativeRobot {
	public static TankDrivetrain drivetrain;
	public static Elevator elevator;
	public static OI oi;


	@Override
	public void robotInit() {
		drivetrain = new TankDrivetrain(
				SubsystemComponents.DrivetrainComponents.leftSP::set,
				SubsystemComponents.DrivetrainComponents.rightSP::set
				);
		elevator = new Elevator(
		        SubsystemComponents.ElevatorComponents.elevatorSP::set,
                SubsystemComponents.ElevatorComponents.maxLimit::get,
                SubsystemComponents.ElevatorComponents.minLimit::get,
                SubsystemComponents.ElevatorComponents.encoder
        );

		oi = new OI();
	}


	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
	}


	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
	}


	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
