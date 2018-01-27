
package org.usfirst.frc.team1014.robot.subsystems;

import org.usfirst.frc.team1014.robot.RobotMap;
import edu.wpi.first.wpilibj.Ultrasonic;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem 
{

	TalonSRX rightFront, rightBack, leftFront, leftBack;
	Ultrasonic ultra = new Ultrasonic(0,1);
	

	public Drivetrain() 
	{
		rightFront = new TalonSRX(RobotMap.DRIVE_RIGHT_1_ID);
		rightBack = new TalonSRX(RobotMap.DRIVE_RIGHT_2_ID);
		leftFront = new TalonSRX(RobotMap.DRIVE_LEFT_1_ID);
		leftBack = new TalonSRX(RobotMap.DRIVE_LEFT_2_ID);

		rightBack.follow(rightFront);
		leftBack.follow(leftFront);
		
		ultra.setAutomaticMode(true);
	}

	public void directDrive(double left, double right) 
	{
		System.out.println(ultra.getRangeInches());
		//rightFront.set(ControlMode.PercentOutput, -right);
		//leftFront.set(ControlMode.PercentOutput, left);
	}

	public void initDefaultCommand() 
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}