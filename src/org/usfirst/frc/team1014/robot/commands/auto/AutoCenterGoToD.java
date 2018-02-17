package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.commands.DriveStraightDistance;
import org.usfirst.frc.team1014.robot.commands.Spin;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCenterGoToD extends CommandGroup {
	
	Drivetrain drivetrain;
	
	public AutoCenterGoToD() {
		this.addSequential(new DriveStraightDistance(drivetrain, 25));
		this.addSequential(new Spin(drivetrain, 49));
		this.addSequential(new DriveStraightDistance(drivetrain, 75.22));
		this.addSequential(new Spin(drivetrain, -49));
		this.addSequential(new DriveStraightDistance(drivetrain, 25));
	}
	
}
