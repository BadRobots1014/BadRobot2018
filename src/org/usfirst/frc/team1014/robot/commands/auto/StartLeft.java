package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.commands.DriveStraightDistance;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1014.robot.subsystems.Grabber;
import org.usfirst.frc.team1014.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartLeft extends CommandGroup{

	public StartLeft(Drivetrain driveTrain, Lifter lifter, Grabber grabber) {
		int switchSide = driveTrain.getSwitchSide();
		int scaleSide = driveTrain.getScaleSide();
		
		if(scaleSide == -1) {
			this.addSequential(new AutoRLScale(driveTrain, lifter, grabber, -1));
		} 
		else if(switchSide == -1) {
			this.addSequential(new AutoRLSwitch(driveTrain, lifter, grabber, -1));
		}
		else {
			this.addSequential(new DriveStraightDistance(driveTrain, 100));
		}
	}
}
