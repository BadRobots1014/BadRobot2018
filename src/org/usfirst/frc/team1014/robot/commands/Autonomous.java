package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.commands.auto.AutoSwitchShortFromCenter;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1014.robot.subsystems.Grabber;
import org.usfirst.frc.team1014.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {	// NEED TO DETERMINE LEFT AND RIGHT -1 or 1
	public Autonomous(Drivetrain driveTrain, Lifter lifter, Grabber grabber) {
		//this.addSequential(new DriveStraightDistance(driveTrain, 40));
		//this.addSequential(new Spin(driveTrain, 190));
		//this.addSequential(new AutoSwitchShortFromCenter(driveTrain, lifter, grabber, -1));
		
		this.addSequential(new Spin(driveTrain, 90)); //CCW
		this.addSequential(new Spin(driveTrain, -90));	//CW
	}
}
