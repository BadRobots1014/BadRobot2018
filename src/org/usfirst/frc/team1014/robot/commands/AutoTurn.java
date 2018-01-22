package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.OI;
import org.usfirst.frc.team1014.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.command.Command;

public class AutoTurn extends Command 
{
	
	double time = 0.5, startTime, passedTime, power;
	int direction;

	/**
	 * 
	 * @param time
	 *            - time in seconds the robot should drive
	 */
	public AutoTurn(double time, double power, int direction) 
	{
		//this.time = time * 1000000;
		this.power = power;
		this.direction = direction;
	}
	
	protected void initialize() {
		startTime = RobotController.getFPGATime();
		
	}

	protected void execute() 
	{
		if(direction < 0)
			DriveTrain.getInstance().drive(-power, power);
		else
			DriveTrain.getInstance().drive(power, -power);
		passedTime = RobotController.getFPGATime() - startTime;
	}

	protected void end() 
	{
		DriveTrain.getInstance().drive(0, 0);
	}

	@Override
	protected boolean isFinished() 
	{
		if (passedTime > time)
			return true;
		return false;
	}

}