package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.commands.DriveStraightDistance;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1014.robot.subsystems.Grabber;
import org.usfirst.frc.team1014.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartRight extends CommandGroup{
	/**
	 * 
	 * @param driveTrain
	 * @param lifter
	 * @param grabber
	 * @param prohibit - object to not do, 0 for none, 1 for switch, 2 for scale
	 * @param scaleSide -    1 for right, -1 for left
	 * @param switchSide -     1 for right, -1 for left
	 */
	public StartRight(Drivetrain driveTrain, Lifter lifter, Grabber grabber, int prohibit, int scaleSide, int switchSide) {
		
		if(scaleSide == 1 && prohibit != 2) {
			this.addSequential(new AutoRLScale(driveTrain, lifter, grabber, 1));
		} 
		else if(switchSide == 1 && prohibit != 1) {
			this.addSequential(new AutoRLSwitch(driveTrain, lifter, grabber, 1));
		}
		else {
			this.addSequential(new DriveStraightDistance(driveTrain, 100));
		}
				
	}

}
