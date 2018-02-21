package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.commands.DriveStraightDistance;
import org.usfirst.frc.team1014.robot.commands.Spin;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1014.robot.subsystems.Grabber;
import org.usfirst.frc.team1014.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoExtremesScale extends CommandGroup{
	
	/**
	 * 
	 * @param driveTrain
	 * @param lifter
	 * @param grabber
	 * @param direction - 1 for R to A, -1 for L to B
	 */
	public AutoExtremesScale(Drivetrain driveTrain, Lifter lifter, Grabber grabber, int direction) {
		this.addSequential(new AutoExtremes(driveTrain, direction));
		this.addSequential(new DriveStraightDistance(driveTrain, 200));
		this.addSequential(new Spin(driveTrain, direction * -90));
		this.addSequential(new AutoMoveCloseScale(driveTrain, lifter, grabber));
	}
	
}
