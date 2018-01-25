package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

public class Spin extends Command {
	private Drivetrain driveTrain;
	private double angle;

	public Spin(Drivetrain driveTrain, double angle) {
		this.angle = angle;
		requires(driveTrain);
		this.driveTrain = driveTrain;
	}

	@Override
	protected void initialize() {
		driveTrain.setTargetAngle(driveTrain.getTargetAngle() + angle);
	}

	@Override
	protected void execute() {
		driveTrain.autoTurn();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
