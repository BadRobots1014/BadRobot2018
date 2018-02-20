package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.command.Command;

public class AutoRaiseScale extends Command{

	private static final double TIME_US = 6000000;
	
	private Lifter lifter;
	private double startTime_us, currentTime_us;
	
	public AutoRaiseScale(Lifter lifter) {
		this.lifter = lifter;
	}
	
	protected void initialize() {
		startTime_us = RobotController.getFPGATime();
	}
	
	protected void execute() {
		lifter.safeMove(1);
		currentTime_us = RobotController.getFPGATime();
	}
	
	protected void end() {
		lifter.move(0);
	}
	
	@Override
	protected boolean isFinished() {
		return (currentTime_us - startTime_us) > TIME_US;
	}

}
