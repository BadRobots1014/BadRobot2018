package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

//Not in use
public class AutoRLWaypoint extends CommandGroup{
	
	public AutoRLWaypoint(Drivetrain driveTrain) {
		this.addSequential(new DriveStraightDistance(driveTrain, 268.75));
	}
}
