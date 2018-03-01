package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1014.robot.subsystems.Grabber;
import org.usfirst.frc.team1014.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartCenterSwitch extends CommandGroup{
	public StartCenterSwitch(Drivetrain driveTrain, Lifter lifter, Grabber grabber) {
		this.addSequential(new AutoSwitchLongFromCenter(driveTrain, lifter, grabber, driveTrain.getSwitchSide()));
	}
}
