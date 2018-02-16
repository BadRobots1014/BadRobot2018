package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.Robot;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1014.robot.subsystems.Grabber;
import org.usfirst.frc.team1014.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Teleop extends CommandGroup {
	public Teleop(Drivetrain driveTrain, Grabber grabber, Lifter lifter) {
		super.addParallel(new TeleDrive(driveTrain, Robot.oi.controller0));
		super.addParallel(new UseGrabber(Robot.oi.controller0, grabber));
		super.addParallel(new UseLifter(Robot.oi.controller0, lifter));
	}
}
