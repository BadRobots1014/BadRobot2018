package org.usfirst.frc.team1014.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1014.robot.subsystems.Lifter;

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
		// TODO Auto-generated method stub
		if(controller.getTriggerAxis(Hand.kLeft)>0.1) {
			// lift the thingy
			double lifterSpeed = controller.getTriggerAxis(Hand.kLeft);
			lifter.move(lifterSpeed);
			
			}
		else if(controller.getTriggerAxis(Hand.kRight)>0.1) {
			// drop the thingy
			double lifterSpeed = controller.getTriggerAxis(Hand.kLeft);
			lifter.move(-lifterSpeed);
		}

	}
	public UseLifter(XboxController controller, Lifter lifter) {
		requires(lifter);
		this.controller = controller;
		this.lifter = lifter;
	}
	

}
