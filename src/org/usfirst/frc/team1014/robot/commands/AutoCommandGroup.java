package org.usfirst.frc.team1014.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCommandGroup extends CommandGroup
{
	public AutoCommandGroup()
	{
		//this.addSequential(new AutoDrive(10, .3));
		this.addSequential(new AutoTurn(.4, 45));
		
		
		
	}
	
	
	
	
	
	
	
}