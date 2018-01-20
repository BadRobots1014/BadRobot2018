package org.usfirst.frc.team1014.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCommandGroup extends CommandGroup
{
	public AutoCommandGroup()
	{
		this.addSequential(new AutoDrive(0.5, 0.3));
		
		
		
		
		
	}
	
	
	
	
	
	
	
}