package org.usfirst.frc.team1014.robot.subsystems;

import org.usfirst.frc.team1014.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import badlog.lib.BadLog;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem {

	TalonSRX liftMotor;
	DigitalInput topLimit, bottomLimit;

	public Lifter() {
		topLimit = new DigitalInput(0);
		bottomLimit = new DigitalInput(1);
		liftMotor = new TalonSRX(RobotMap.LIFT_1_ID);

		BadLog.createTopic("Lift/Lifter Output Percent", BadLog.UNITLESS, () -> liftMotor.getMotorOutputPercent(),
				"hide", "join:Lift/Output Percents");

		BadLog.createTopic("Lift/Lifter Current", "A", () -> liftMotor.getOutputCurrent(), "hide",
				"join:Lift/Output Currents");

		BadLog.createTopic("Lift/Lifter Voltage", "V", () -> liftMotor.getMotorOutputVoltage(), "hide",
				"join:Lift/Output Voltages");

		/*
		 * liftMotor.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector,
		 * LimitSwitchNormal.NormallyClosed, 0);
		 * liftMotor.configReverseSoftLimitEnable(true, 0);
		 */ // Needs to be tested

	}

	public void move(double speed) {
		liftMotor.set(ControlMode.PercentOutput, speed);

	}

	public void safeMove(double speed) {
		if (speed > 0) {
			if (isAtTop())
				speed = 0;
		} else {
			if (isAtBottom())
				speed = 0;
		}
		liftMotor.set(ControlMode.PercentOutput, speed);

	}

	public boolean isAtBottom() {
		return bottomLimit.get();
	}

	public boolean isAtTop() {
		return topLimit.get();
	}

	@Override
	protected void initDefaultCommand() {
	}

}