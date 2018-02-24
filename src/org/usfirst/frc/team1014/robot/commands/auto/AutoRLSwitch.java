package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.commands.DriveStraightDistance;
import org.usfirst.frc.team1014.robot.commands.Spin;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1014.robot.subsystems.Grabber;
import org.usfirst.frc.team1014.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRLSwitch extends CommandGroup{
	
	/**
	 * 
	 * @param driveTrain
	 * @param direction - 1 for right, -1 for left
	 */
	public AutoRLSwitch(Drivetrain driveTrain, Lifter lifter, Grabber grabber, int direction) {		//untested
		this.addSequential(new DriveStraightDistance(driveTrain, 268.75));		//value is definitely not right
		this.addSequential(new Spin(driveTrain, direction * 90));
		this.addSequential(new AutoMoveCloseSwitch(driveTrain, lifter, grabber));


	}
}
