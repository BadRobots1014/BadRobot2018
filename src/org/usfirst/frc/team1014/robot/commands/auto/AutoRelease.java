package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.subsystems.Grabber;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.command.Command;

public class AutoRelease extends Command{
	private static final double TIME_US = 1000000; 
	
	private Grabber grabber;
	private double startTime_us, currentTime_us;
	
	public AutoRelease(Grabber grabber) {
		this.grabber = grabber;
	}
	
	protected void initialize() {
		startTime_us = RobotController.getFPGATime();
	}
	
	protected void execute() {
		grabber.turnRelease(.6);
		currentTime_us = RobotController.getFPGATime();
	}
	
	protected void end() {
		grabber.turnRelease(0);
	}
	
	@Override
	protected boolean isFinished() {
		return (currentTime_us - startTime_us) > TIME_US;
	}
}
