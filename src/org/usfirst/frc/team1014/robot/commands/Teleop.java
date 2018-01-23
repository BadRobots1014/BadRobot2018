package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.Robot;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Teleop extends CommandGroup {
	public Teleop(Drivetrain driveTrain) {
		super.addParallel(new TeleDrive(driveTrain, Robot.oi.controller0));
	}
}
