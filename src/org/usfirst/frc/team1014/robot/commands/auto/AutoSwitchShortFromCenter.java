package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.commands.Spin;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1014.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoSwitchShortFromCenter extends CommandGroup{
	
	/**
	 * 
	 * @param driveTrain
	 * @param direction - -1 for right, 1 for left
	 */
	public AutoSwitchShortFromCenter(Drivetrain driveTrain, Lifter lifter,int direction) {
		this.addSequential(new AutoCentertoAB(driveTrain, direction));
		this.addSequential(new Spin(driveTrain, 90 * direction));
		this.addSequential(new AutoRaiseSwitch(lifter));
	}
}
