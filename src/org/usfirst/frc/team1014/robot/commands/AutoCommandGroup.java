package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCommandGroup extends CommandGroup
{
	public AutoCommandGroup(Drivetrain drive)
	{
		super.addSequential(new AutoDrive(1, .7));
		super.addSequential(new AutoTurn(.5, 45, drive));
		//this.addSequential(new AutoDriveUltra(-.4, 12, drive));
		
		
	}
	
	
	
	
	
	
	
}