package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.commands.AutoRaiseSwitch;
import org.usfirst.frc.team1014.robot.commands.DriveStraightDistance;
import org.usfirst.frc.team1014.robot.commands.Spin;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1014.robot.subsystems.Grabber;
import org.usfirst.frc.team1014.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRLScale extends CommandGroup{
	
	/**
	 * 
	 * @param driveTrain
	 * @param direction - 1 for right, -1 for left
	 */
	public AutoRLScale(Drivetrain driveTrain, Lifter lifter, Grabber grabber, int direction) {	//tested
		this.addSequential(new DriveStraightDistance(driveTrain, 230));
		this.addSequential(new Spin(driveTrain, direction * 45));
		this.addSequential(new AutoMoveCloseScale(driveTrain, lifter, grabber));
	}
}
