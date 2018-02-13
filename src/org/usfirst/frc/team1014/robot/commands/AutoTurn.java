package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

public class AutoTurn extends Command 
{
	
	double power;
	int targetAngle;
	Drivetrain drive;
	
	
	public AutoTurn(double power, int targetAngle, Drivetrain drive) 
	{
		//this.time = time * 1000000;
		this.power = power;
		this.targetAngle = targetAngle;
		this.drive = drive;
	}
	
	protected void initialize() {
		drive.zeroYaw();
	}

	protected void execute() 
	{
		drive.rotate(targetAngle, power);
		System.out.println(drive.getYaw());
	}

	protected void end() 
	{
		drive.directDrive(0, 0);
	}

	@Override
	protected boolean isFinished() 
	{
		if (Math.abs(drive.getYaw()) > Math.abs(targetAngle))
			return true;
		return false;
	}

}