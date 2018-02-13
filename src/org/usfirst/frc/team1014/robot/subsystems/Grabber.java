package org.usfirst.frc.team1014.robot.subsystems;

import org.usfirst.frc.team1014.robot.RobotMap;

import org.usfirst.frc.team1014.robot.util.MiniPID;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Grabber extends Subsystem {

	TalonSRX rightArm,rightWheel,leftArm,leftWheel;
	

	private double targetAngle;
	MiniPID miniPID;
	
	public Grabber() {
		rightWheel = new TalonSRX(RobotMap.GRABBER_RIGHT_1_ID);
		leftWheel = new TalonSRX(RobotMap.GRABBER_LEFT_1_ID); 
	}
	

	public void turnRelease(double wheelSpeed) {
		leftWheel.set(ControlMode.PercentOutput, wheelSpeed);
		rightWheel.set(ControlMode.PercentOutput, -wheelSpeed);
	}
	public void turnCollect(double wheelSpeed) {
		leftWheel.set(ControlMode.PercentOutput, -wheelSpeed);
		rightWheel.set(ControlMode.PercentOutput, wheelSpeed);
	}
	
	

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
