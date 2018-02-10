package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCtoWaypointShort extends CommandGroup{
	public AutoCtoWaypointShort(Drivetrain driveTrain) {
		this.addSequential(new AutoCtoWaypointShort(driveTrain));
	}
}
