package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.command.Command;

public class AutoRaiseScale extends Command{

	//private static final double TIME_US = 2000000; //Time value is currently incorrect. Needs to move 7 feet
	
	private Lifter lifter;
	private double startTime_us, currentTime_us;
	
	public AutoRaiseScale(Lifter lifter) {
		this.lifter = lifter;
	}
	
	protected void initialize() {
		//startTime_us = RobotController.getFPGATime();
	}
	
	protected void execute() {
		lifter.move(1);
		//currentTime_us = RobotController.getFPGATime();
	}
	
	protected void end() {
		lifter.move(0);
	}
	
	@Override
	protected boolean isFinished() {
		return true;  //This is untested
	}

}
