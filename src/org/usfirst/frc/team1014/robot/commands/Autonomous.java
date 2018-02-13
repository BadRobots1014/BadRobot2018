package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {
	public Autonomous(Drivetrain driveTrain) {
		this.addSequential(new DriveStraightDistance(driveTrain, 12));
		this.addSequential(new Spin(driveTrain, -50));
		this.addSequential(new DriveStraightDistance(driveTrain, 117));
		this.addSequential(new Spin(driveTrain, 50));
		this.addSequential(new DriveStraightDistance(driveTrain, 97));
		this.addSequential(new Spin(driveTrain, 90));
	}
}
