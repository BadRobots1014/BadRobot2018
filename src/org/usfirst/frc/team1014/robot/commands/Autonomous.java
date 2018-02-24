package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.commands.auto.AutoRLScale;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1014.robot.subsystems.Grabber;
import org.usfirst.frc.team1014.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {	// NEED TO DETERMINE LEFT AND RIGHT -1 or 1
	public Autonomous(Drivetrain driveTrain, Lifter lifter, Grabber grabber) {
		this.addSequential(new AutoRLScale(driveTrain, lifter, grabber, 1));
	}
}
