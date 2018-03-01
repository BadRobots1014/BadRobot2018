package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1014.robot.subsystems.Grabber;
import org.usfirst.frc.team1014.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartCenterScale extends CommandGroup{
	public StartCenterScale(Drivetrain driveTrain, Lifter lifter, Grabber grabber) {
		this.addSequential(new AutoScaleFromCenter(driveTrain, lifter, grabber, driveTrain.getScaleSide()));
	}
}
