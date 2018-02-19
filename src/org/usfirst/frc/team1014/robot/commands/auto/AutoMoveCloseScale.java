package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.commands.AutoRaiseScale;
import org.usfirst.frc.team1014.robot.commands.AutoRelease;
import org.usfirst.frc.team1014.robot.commands.DriveStraightDistance;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1014.robot.subsystems.Grabber;
import org.usfirst.frc.team1014.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoMoveCloseScale extends CommandGroup{

	public AutoMoveCloseScale(Drivetrain driveTrain, Lifter lifter, Grabber grabber) {
		this.addSequential(new AutoRaiseScale(lifter));
		this.addSequential(new DriveStraightDistance(driveTrain, 15)); //Value was not measured
		this.addSequential(new AutoRelease(grabber));
	}
}
