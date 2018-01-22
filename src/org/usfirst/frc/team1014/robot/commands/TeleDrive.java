/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1014.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

/**
 * An example command. You can replace me with your own command.
 */
public class TeleDrive extends Command {

	private XboxController controller;
	private Drivetrain driveTrain;

	public TeleDrive(Drivetrain driveTrain, XboxController controller) {
		this.driveTrain = driveTrain;
		this.controller = controller;
		requires(driveTrain);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		// Negative because top left is (-1,-1)
		double left = -controller.getY(Hand.kLeft);
		double right = -controller.getY(Hand.kRight);

		driveTrain.directDrive(left, right);
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
