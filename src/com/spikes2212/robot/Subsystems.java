package com.spikes2212.robot;

import java.util.function.Consumer;

import com.ctre.CANTalon;
import com.spikes2212.genericsubsystems.commands.MoveBasicSubsystem;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;

public class Subsystems {
	public static class Shooter {
		public static Consumer<Double> move = new Consumer<Double>() {

			SpeedController motor = new CANTalon(RobotMap.CAN.SHOOTER);

			@Override
			public void accept(Double speed) {
				motor.set(speed);
			}

		};

		public static Command defaultCommand = new MoveBasicSubsystem(Robot.shooter, 0.3);
	}
}