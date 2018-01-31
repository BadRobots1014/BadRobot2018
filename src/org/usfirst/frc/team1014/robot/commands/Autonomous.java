package org.usfirst.frc.team1014.robot.commands;

import java.util.stream.IntStream;

import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Autonomous extends CommandGroup {
	public Autonomous(Drivetrain driveTrain) {
		IntStream.range(0, 4).forEach((x) -> this.addSequential(new Spin(driveTrain, 90)));
		this.addSequential(new WaitCommand(3));
		this.addSequential(new DriveStraight(driveTrain, .5, 2));
	}
}
