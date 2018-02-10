package org.usfirst.frc.team1014.robot.subsystems;

import org.usfirst.frc.team1014.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem {

	TalonSRX liftMotor; //heightSensor
	// test comment
	public Lifter() {
		liftMotor = new TalonSRX(RobotMap.LIFT_1_ID);
	}

	public void move(double speed) {
		liftMotor.set(ControlMode.PercentOutput, speed);

	}
	
	//public void liftHeight ();
		
	@Override
	protected void initDefaultCommand() {
	}

}