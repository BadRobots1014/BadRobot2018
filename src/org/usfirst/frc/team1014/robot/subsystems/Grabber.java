package org.usfirst.frc.team1014.robot.subsystems;

import org.usfirst.frc.team1014.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import badlog.lib.BadLog;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Grabber extends Subsystem {

	TalonSRX rightWheel, leftWheel;

	public Grabber() {
		rightWheel = new TalonSRX(RobotMap.GRABBER_RIGHT_1_ID);
		leftWheel = new TalonSRX(RobotMap.GRABBER_LEFT_1_ID);

		BadLog.createTopic("Lift/Right Output Percent", BadLog.UNITLESS, () -> rightWheel.getMotorOutputPercent(),
				"hide", "join:Lift/Output Percents");
		BadLog.createTopic("Lift/Left Output Percent", BadLog.UNITLESS, () -> leftWheel.getMotorOutputPercent(), "hide",
				"join:Lift/Output Percents");

		BadLog.createTopic("Lift/Right Current", "A", () -> rightWheel.getOutputCurrent(), "hide",
				"join:Lift/Output Currents");
		BadLog.createTopic("Lift/Left Current", "A", () -> leftWheel.getOutputCurrent(), "hide",
				"join:Lift/Output Currents");

		BadLog.createTopic("Lift/Right Voltage", "V", () -> rightWheel.getMotorOutputVoltage(), "hide",
				"join:Lift/Output Voltages");
		BadLog.createTopic("Lift/Left Voltage", "V", () -> leftWheel.getMotorOutputVoltage(), "hide",
				"join:Lift/Output Voltages");

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
