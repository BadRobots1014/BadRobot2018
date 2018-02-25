package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

public class UseLifter extends Command {

	private XboxController controller;
	private Lifter lifter;

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void execute() {
		double speed = (controller.getBumper(Hand.kLeft) ? 1 : 0)
				- (controller.getTriggerAxis(Hand.kLeft) > .5 ? 1 : 0);
		lifter.move(speed);
	}

	public UseLifter(XboxController controller, Lifter lifter) {
		requires(lifter);
		this.controller = controller;
		this.lifter = lifter;
	}

}
