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
		lifter.safeMove(controller.getTriggerAxis(Hand.kRight) - controller.getTriggerAxis(Hand.kLeft));
	}

	public UseLifter(XboxController controller, Lifter lifter) {
		requires(lifter);
		this.controller = controller;
		this.lifter = lifter;
	}

}
