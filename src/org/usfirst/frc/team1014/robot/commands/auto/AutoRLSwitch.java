package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.commands.AutoRaiseSwitch;
import org.usfirst.frc.team1014.robot.commands.AutoRelease;
import org.usfirst.frc.team1014.robot.commands.Spin;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1014.robot.subsystems.Grabber;
import org.usfirst.frc.team1014.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRLSwitch extends CommandGroup{
	
	/**
	 * 
	 * @param driveTrain
	 * @param direction - -1 for right, 1 for left
	 */
	public AutoRLSwitch(Drivetrain driveTrain, Lifter lifter, Grabber grabber, int direction) {
		this.addSequential(new AutoRLtoAB(driveTrain));
		this.addSequential(new Spin(driveTrain, direction * 90));
		this.addSequential(new AutoMoveCloseSwitch(driveTrain, lifter, grabber));


	}
}
