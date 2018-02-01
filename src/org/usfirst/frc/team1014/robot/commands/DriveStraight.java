package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command {
	private Drivetrain driveTrain;
	private double seconds;
	private double speed;

	long startTime;

	public DriveStraight(Drivetrain driveTrain, double speed, double seconds) {
		this.speed = speed;
		this.seconds = seconds;
		requires(driveTrain);
		this.driveTrain = driveTrain;
	}

	@Override
	protected void initialize() {
		startTime = System.currentTimeMillis();
	}

	@Override
	protected void execute() {
		driveTrain.driveStraight(speed);
	}

	@Override
	protected boolean isFinished() {
		return (System.currentTimeMillis() - startTime) > (int) (1000d * seconds);
	}

	@Override
	protected void end() {
		driveTrain.directDrive(0, 0);
	}

}
