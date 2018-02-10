package org.usfirst.frc.team1014.robot.subsystems;

import org.usfirst.frc.team1014.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem{

	TalonSRX climber;
	public Lifter() {
		
		climber = new TalonSRX(RobotMap.);
		
	}
	public void lift(double power) {
		lifter.set(ControlMode.PercentOutput, power);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	
}