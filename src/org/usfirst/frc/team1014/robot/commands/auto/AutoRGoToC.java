package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.commands.DriveStraightDistance;
import org.usfirst.frc.team1014.robot.commands.Spin;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRGoToC extends CommandGroup {

	Drivetrain drivetrain;

	public AutoRGoToC() {
		this.addSequential(new DriveStraightDistance(drivetrain, 25));
		this.addSequential(new Spin(drivetrain, -79.69));
		this.addSequential(new DriveStraightDistance(drivetrain, 279.51));
		this.addSequential(new Spin(drivetrain, 79.69));
		this.addSequential(new DriveStraightDistance(drivetrain, 25));
	}
}