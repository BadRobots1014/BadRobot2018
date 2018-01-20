package org.usfirst.frc.team1014.robot.subsystems;

import org.usfirst.frc.team1014.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem
{
	
	private static DriveTrain instance;
	private TalonSRX leftBack, rightBack, leftFront, rightFront;
	
	public static DriveTrain getInstance() 
	{
		if (instance == null)
			instance = new DriveTrain();
		return instance;
	}
	
	public DriveTrain()
	{
		leftBack = new TalonSRX(RobotMap.BACK_LEFT_SPEED_CONTROLLER);
		leftFront = new TalonSRX(RobotMap.FRONT_LEFT_SPEED_CONTROLLER);
		rightFront = new TalonSRX(RobotMap.FRONT_RIGHT_SPEED_CONTROLLER);		
		rightBack = new TalonSRX(RobotMap.BACK_RIGHT_SPEED_CONTROLLER);
	}
	
	
	public void drive(double left, double right)
	{
		leftBack.set(ControlMode.PercentOutput, left);
		leftFront.set(ControlMode.PercentOutput, left);
		rightBack.set(ControlMode.PercentOutput, right);
		rightFront.set(ControlMode.PercentOutput, right);

		
	}


	@Override
	protected void initDefaultCommand() 
	{
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}














