package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.subsystems.Climber;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

public class UseClimber extends Command{

	Climber climber;
	XboxController controller;
	
	public UseClimber(Climber climber, XboxController controller) {
		this.climber = climber;
		this.controller = controller;
	}
	
	protected void execute() {
		if(controller.getYButtonPressed()) {
			climber.climb(.5);
		}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
