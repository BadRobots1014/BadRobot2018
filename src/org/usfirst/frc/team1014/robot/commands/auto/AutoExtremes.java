package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.commands.DriveStraightDistance;
import org.usfirst.frc.team1014.robot.commands.Spin;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoExtremes extends CommandGroup{
	
	/**
	 * 
	 * @param driveTrain
	 * @param side - 1 for R to A, -1 for L to B
	 */
	public AutoExtremes(Drivetrain driveTrain, int side) {
		this.addSequential(new DriveStraightDistance(driveTrain, 25));
		this.addSequential(new Spin(driveTrain, side * 70));
		this.addSequential(new DriveStraightDistance(driveTrain, 262.5));
		this.addSequential(new Spin(driveTrain, side * -70));
	}
}
