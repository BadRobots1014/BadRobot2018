package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.commands.AutoRaiseSwitch;
import org.usfirst.frc.team1014.robot.commands.AutoRelease;
import org.usfirst.frc.team1014.robot.commands.DriveStraightDistance;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1014.robot.subsystems.Grabber;
import org.usfirst.frc.team1014.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoMoveCloseSwitch extends CommandGroup{

	public AutoMoveCloseSwitch(Drivetrain driveTrain, Lifter lifter, Grabber grabber) {
		this.addSequential(new AutoRaiseSwitch(lifter, 1));
		this.addSequential(new DriveStraightDistance(driveTrain, 10));
		this.addSequential(new AutoRelease(grabber));
	}
}
