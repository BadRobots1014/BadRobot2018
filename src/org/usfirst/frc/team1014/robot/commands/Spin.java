package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

public class Spin extends Command {
	private Drivetrain driveTrain;
	private double angle;
	
	long startTime;

	/**
	 * 
	 * @param driveTrain
	 * @param angle - negative angles turn CW   positive angles turn CCW
	 */
	public Spin(Drivetrain driveTrain, double angle) {
		this.angle = angle;
		requires(driveTrain);
		this.driveTrain = driveTrain;
	}

	@Override
	protected void initialize() {
		driveTrain.setTargetAngle(driveTrain.getTargetAngle() + angle);
		startTime = System.currentTimeMillis();
	}

	@Override
	protected void execute() {
		driveTrain.autoTurn();
	}

	@Override
	protected boolean isFinished() {
		return (System.currentTimeMillis() - startTime) > 2000;  //run pid loop for 1.2 seconds 
	}

}
