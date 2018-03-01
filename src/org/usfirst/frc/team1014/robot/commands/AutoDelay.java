package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.command.Command;

public class AutoDelay extends Command{
	
	private double time_us, startTime_us, currentTime_us;
	
	/**
	 * 
	 * @param time - in seconds
	 */
	public AutoDelay(int time) {
		this.time_us = time * 1000000;
	}

	protected void initialize() {
		startTime_us = RobotController.getFPGATime();
	}

	protected void execute() {
		currentTime_us = RobotController.getFPGATime();
	}

	protected void end() {
		
	}

	@Override
	protected boolean isFinished() {
		return (currentTime_us - startTime_us) > time_us;
	}


}
