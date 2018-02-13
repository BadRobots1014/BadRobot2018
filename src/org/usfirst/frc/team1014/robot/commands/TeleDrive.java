package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

/**
 * An example command. You can replace me with your own command.
 */
public class TeleDrive extends Command {

	private XboxController controller;
	private Drivetrain driveTrain;	
	boolean AButton;
	double targetAngle;

	public TeleDrive(Drivetrain driveTrain, XboxController controller) {
		this.driveTrain = driveTrain;
		this.controller = controller;
		requires(driveTrain);
	}

	@Override
	protected void initialize() {
		AButton = false;
		targetAngle = 0;

	}

	@Override
	protected void execute() {
		// Negative because top left is (-1,-1)
		/*if (controller.getAButton()) {
			AButton = !AButton;
			System.out.println(AButton);
		}*/
		if (controller.getAButton()) {
			targetAngle = Math.atan2(controller.getY(Hand.kLeft), controller.getX(Hand.kLeft)) * 57.2957795131;
			System.out.println(targetAngle);
			driveTrain.setTargetAngle(targetAngle);
			driveTrain.autoTurn();
		}


		else {

			System.out.println(driveTrain.getUltraDistance());

			double left = -controller.getY(Hand.kLeft);
			double right = -controller.getY(Hand.kRight);

			driveTrain.directDrive(left, right);

		}
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
