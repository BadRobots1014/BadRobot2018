package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.commands.Spin;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRLScale extends CommandGroup{
	
	/**
	 * 
	 * @param driveTrain
	 * @param direction - -1 for right, 1 for left
	 */
	public AutoRLScale(Drivetrain driveTrain, int direction) {
		this.addSequential(new DriveStraightDistance(driveTrain, 425));
		this.addSequential(new Spin(driveTrain, direction * 90));
		
	}
}