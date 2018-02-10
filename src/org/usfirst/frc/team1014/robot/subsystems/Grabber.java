package org.usfirst.frc.team1014.robot.subsystems;

import org.usfirst.frc.team1014.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Grabber extends Subsystem{

	TalonSRX grabLeft, grabRight;
	public Lifter() {
		
		grabLeft = new TalonSRX(RobotMap.GRABBER_LEFT_1_ID);
		grabRight = new TalonSRX(RobotMap.GRABBER_RIGHT_1_ID)
	}
	public void move(double power) {
		grabLeft.set(ControlMode.PercentOutput, power);
		grabRight.set(ControlMode.PercentOutput, power);

	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	
}
