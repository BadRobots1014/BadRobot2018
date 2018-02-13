package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.commands.DriveStraightDistance;
import org.usfirst.frc.team1014.robot.commands.Spin;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLeftGoToC extends CommandGroup {

	Drivetrain drivetrain;

	public AutoLeftGoToC() {
		this.addSequential(new DriveStraightDistance(drivetrain, 25));
		this.addSequential(new Spin(drivetrain, 47.5));
		this.addSequential(new DriveStraightDistance(drivetrain, 72.95));
		this.addSequential(new Spin(drivetrain, -47.5));
		this.addSequential(new DriveStraightDistance(drivetrain, 25));
	}
}