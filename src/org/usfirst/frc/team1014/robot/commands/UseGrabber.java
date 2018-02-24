package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.subsystems.Grabber;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

public class UseGrabber extends Command {
	private XboxController controller;
	private Grabber grabber;

	boolean grabState = false, grabDown = false;
	long startLastGrab = 0;

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		if (controller.getBumper(Hand.kLeft)) {
			// Collect cubes
			grabber.turnCollect(1);
			grabState = false;
		} else if (controller.getBumper(Hand.kRight)) {
			// release
			grabber.turnRelease(.6);
			grabState = false;
		} else {
			if (grabState) {
				grabber.turnCollect(isGrabbing() ? .2 : 0);
				controller.setRumble(RumbleType.kLeftRumble, isGrabbing() ? 1 : 0);
				controller.setRumble(RumbleType.kRightRumble, isGrabbing() ? 1 : 0);

			} else {
				grabber.turnCollect(0);
				controller.setRumble(RumbleType.kLeftRumble, 0);
				controller.setRumble(RumbleType.kRightRumble, 0);
			}
		}

		if (controller.getAButton()) {
			if (!grabDown) {
				grabDown = true;
				grabState = !grabState;
				startLastGrab = System.currentTimeMillis();
			}
		} else {
			grabDown = false;
		}
	}

	private boolean isGrabbing() {
		return (System.currentTimeMillis() - startLastGrab) % 1000 < 250;
	}

	public UseGrabber(XboxController controller, Grabber grabber) {
		requires(grabber);
		this.controller = controller;
		this.grabber = grabber;
	}

}
