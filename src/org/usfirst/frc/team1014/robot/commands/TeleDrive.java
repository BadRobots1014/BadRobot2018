package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.Robot;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

/**
 * An example command. You can replace me with your own command.
 */
public class TeleDrive extends Command {

	private XboxController controller;
	private Drivetrain driveTrain;
	double targetAngle;
	private XboxController controller1;

	public TeleDrive(Drivetrain driveTrain, XboxController controller0, XboxController controller1) {
		this.driveTrain = driveTrain;
		this.controller = controller0;
		this.controller1 = controller1;
		requires(driveTrain);
	}

	@Override
	protected void initialize() {
		targetAngle = 0;

	}

	@Override
	protected void execute() {
		// Negative because top left is (-1,-1)

		double left = -controller.getY(Hand.kLeft);
		double right = -controller.getY(Hand.kRight);

		double scalar = controller1.getBButton() ? (1d / 3d) : 1;

		left *= scalar;
		right *= scalar;

		driveTrain.directDrive(left, right);
		
		/*targetAngle = Math.atan2(-controller.getY(Hand.kRight), -controller.getX(Hand.kRight));
		driveTrain.driveStraight(-controller.getY(Hand.kLeft));*/	//untested

	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
