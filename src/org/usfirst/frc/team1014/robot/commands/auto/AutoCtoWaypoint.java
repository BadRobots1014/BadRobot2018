package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.commands.Spin;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCtoWaypoint extends CommandGroup
{
	
	double power, half;
	/**
	 * 
	 * 
	 * @param drivetrain Drivetrain object
	 * @param direction indicates direction(1 for B, -1 for A)
	 * 
	 * 
	 */
	public AutoCtoWaypoint(Drivetrain drivetrain, int direction)
	{
		this.addSequential(new DriveStraightDistance(drivetrain, 25)); 
		this.addSequential(new Spin(drivetrain, 40 * direction));
		this.addSequential(new DriveStraightDistance(drivetrain, 187.5)); 
		this.addSequential(new Spin(drivetrain, -40 * direction));
				
	}
	
	
	
	
	
}