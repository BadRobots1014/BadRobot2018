package org.usfirst.frc.team1014.robot.subsystems;

import org.usfirst.frc.team1014.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem{
	
	TalonSRX climberMotor;
	
	public Climber() {
		climberMotor = new TalonSRX(RobotMap.CLIMBER_1_ID);
	}
	
	public void climb(double speed) {
		climberMotor.set(ControlMode.PercentOutput, speed);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
