package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.commands.DriveStraightDistance;
import org.usfirst.frc.team1014.robot.commands.Spin;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoScaleC extends CommandGroup{
	/**
	 * 
	 * @param driveTrain
	 * @param direction - -1 for right, 1 for left
	 */
	public AutoScaleC(Drivetrain driveTrain, int direction) {
		this.addSequential(new AutoCtoWaypoint(driveTrain, direction));
		this.addSequential(new DriveStraightDistance(driveTrain, 25));
		this.addSequential(new Spin(driveTrain, 40));
		this.addSequential(new DriveStraightDistance(driveTrain, 187.5));
		this.addSequential(new Spin(driveTrain, 40));
	}
	
}
