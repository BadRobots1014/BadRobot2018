package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.OI;
import org.usfirst.frc.team1014.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class TeleDrive extends Command 
{

	public void execute() 
	{
		double left, right;
		left = OI.xboxController0.getRawAxis(1);
		right = OI.xboxController0.getRawAxis(5);
		DriveTrain.getInstance().drive(right, -left);

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}