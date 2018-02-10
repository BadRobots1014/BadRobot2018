package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.commands.Spin;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoSwitchCShort extends CommandGroup{
	
	/**
	 * 
	 * @param driveTrain
	 * @param direction - -1 for right, 1 for left
	 */
	public AutoSwitchCShort(Drivetrain driveTrain, int direction) {
		this.addSequential(new AutoCtoWaypoint(driveTrain, direction));
		this.addSequential(new Spin(driveTrain, 90 * direction));
	}
}
