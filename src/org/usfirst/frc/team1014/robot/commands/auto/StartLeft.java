package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.commands.DriveStraightDistance;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1014.robot.subsystems.Grabber;
import org.usfirst.frc.team1014.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartLeft extends CommandGroup{
	/**
	 * 
	 * @param driveTrain
	 * @param lifter
	 * @param grabber
	 * @param prohibit - side to not do, 0 for none, 1 for switch, 2 for scale
	 */
	public StartLeft(Drivetrain driveTrain, Lifter lifter, Grabber grabber, int prohibit) {
		int switchSide = driveTrain.getSwitchSide();
		int scaleSide = driveTrain.getScaleSide();
		
		if(scaleSide == -1 && prohibit != 0) {
			this.addSequential(new AutoRLScale(driveTrain, lifter, grabber, -1));
		} 
		else if(switchSide == -1 && prohibit != 1) {
			this.addSequential(new AutoRLSwitch(driveTrain, lifter, grabber, -1));
		}
		else {
			this.addSequential(new DriveStraightDistance(driveTrain, 100));
		}
	}
}
