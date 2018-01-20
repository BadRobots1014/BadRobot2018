package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command 
{
	
	double time_us, targetTime_us, passedTime_us, power;

	/**
	 * 
	 * @param time
	 *            - time in seconds the robot should drive
	 */
	public AutoDrive(double time_s, double power) 
	{
		this.time_us = time_s * 1000000;
		targetTime_us = RobotController.getFPGATime();
		this.power = power;
	}
	
	protected void init()
	{
		targetTime_us = RobotController.getFPGATime() + time_us;
		DriveTrain.getInstance().drive(power, power);
		System.out.println("init");
	}

	protected void execute() 
	{
		
		//passedTime_us = RobotController.getFPGATime() - targetTime_us;
		System.out.println(RobotController.getFPGATime() + "    " + targetTime_us);
		//System.out.println(passedTime_us);
	}

	protected void end() 
	{
		DriveTrain.getInstance().drive(0, 0);
	}

	@Override
	protected boolean isFinished() 
	{
		if (RobotController.getFPGATime() > targetTime_us)
			return true;
		return false;
	}

}