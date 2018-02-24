package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

/**
 * An example command. You can replace me with your own command.
 */
public class TeleDrive extends Command {
	private static final double DRIVE_STRAIGHT_TRIGGER_DEADZONE = .05;
	private XboxController controller;
	private Drivetrain driveTrain;
	double targetAngle;
	private XboxController controller1;

	double slowedSpeedLeft, slowedSpeedRight;
	private static final double SLOWED_SPEED_RATIO = 1d / 3d;
	private final double SLOWED_SPEED_RAMP_RATE = .5;

	private boolean driveStraightOn;

	public TeleDrive(Drivetrain driveTrain, XboxController controller0, XboxController controller1) {
		this.driveTrain = driveTrain;
		this.controller = controller0;
		this.controller1 = controller1;
		requires(driveTrain);

		slowedSpeedLeft = slowedSpeedRight = 0;
		driveStraightOn = false;
	}

	@Override
	protected void initialize() {
		targetAngle = 0;

	}

	@Override
	protected void execute() {
		double left = -controller.getY(Hand.kLeft);
		double right = -controller.getY(Hand.kRight);

		double drive_straight_force = controller.getTriggerAxis(Hand.kRight);

		if (Math.abs(drive_straight_force) > DRIVE_STRAIGHT_TRIGGER_DEADZONE) {
			if (!driveStraightOn) {
				driveStraightOn = true;
				driveTrain.resetPID();
				driveTrain.setTargetAngle(driveTrain.getAngleCCW());
			}
			driveTrain.driveStraight(drive_straight_force);
		} else {
			driveStraightOn = false;

			if (controller1.getBButton()) {
				left *= SLOWED_SPEED_RATIO;
				right *= SLOWED_SPEED_RATIO;

				double left_delta = left - slowedSpeedLeft;
				if (Math.abs(left_delta) > SLOWED_SPEED_RAMP_RATE / 50d) {
					left_delta *= (SLOWED_SPEED_RAMP_RATE / 50d) / Math.abs(left_delta);
				}
				slowedSpeedLeft += left_delta;

				double right_delta = right - slowedSpeedRight;
				if (Math.abs(right_delta) > SLOWED_SPEED_RAMP_RATE / 50d) {
					right_delta *= (SLOWED_SPEED_RAMP_RATE / 50d) / Math.abs(right_delta);
				}
				slowedSpeedRight += right_delta;

				left = slowedSpeedLeft;
				right = slowedSpeedRight;

				controller.setRumble(RumbleType.kLeftRumble, .5);
				controller.setRumble(RumbleType.kRightRumble, .5);
			} else {
				slowedSpeedLeft = left;
				slowedSpeedRight = right;

				controller.setRumble(RumbleType.kLeftRumble, 0);
				controller.setRumble(RumbleType.kRightRumble, 0);
			}

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
