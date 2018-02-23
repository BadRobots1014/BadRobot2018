package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.commands.DriveStraightDistance;
import org.usfirst.frc.team1014.robot.commands.Spin;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCenterGoToSwitchLong extends CommandGroup {
	
	Drivetrain drivetrain;
	
	/**
	 * 
	 * @param drivetrain
	 * @param direction - -1 for left, 1 for right
	 */
	public AutoCenterGoToSwitchLong(Drivetrain drivetrain, int direction) {
		this.addSequential(new DriveStraightDistance(drivetrain, 25));
		this.addSequential(new Spin(drivetrain, direction * -49.5));
		this.addSequential(new DriveStraightDistance(drivetrain, 75)); 
		this.addSequential(new Spin(drivetrain, direction * 49.5));
		this.addSequential(new DriveStraightDistance(drivetrain, 25));
	}
	
}
