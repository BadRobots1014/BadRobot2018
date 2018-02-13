package org.usfirst.frc.team1014.robot.subsystems;

import org.usfirst.frc.team1014.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem{

	TalonSRX climber;
	public Climber() {
		
		climber = new TalonSRX(RobotMap.CLIMBER_1_ID);
		
	}
	public void lift(double power) {
		climber.set(ControlMode.PercentOutput, power);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	
}
