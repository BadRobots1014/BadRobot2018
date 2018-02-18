package org.usfirst.frc.team1014.robot.subsystems;

import org.usfirst.frc.team1014.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import badlog.lib.BadLog;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem {

	TalonSRX liftMotor;

	public Lifter() {
		liftMotor = new TalonSRX(RobotMap.LIFT_1_ID);

		BadLog.createTopic("Lift/Lifter Output Percent", BadLog.UNITLESS, () -> liftMotor.getMotorOutputPercent(),
				"hide", "join:Lift/Output Percents");

		BadLog.createTopic("Lift/Lifter Current", "A", () -> liftMotor.getOutputCurrent(), "hide",
				"join:Lift/Output Currents");

		BadLog.createTopic("Lift/Lifter Voltage", "V", () -> liftMotor.getMotorOutputVoltage(), "hide",
				"join:Lift/Output Voltages");
	}

	public void move(double speed) {
		liftMotor.set(ControlMode.PercentOutput, speed);

	}

	public void safeMove(double speed) {
		liftMotor.set(ControlMode.PercentOutput, speed);

	}

	@Override
	protected void initDefaultCommand() {
	}

}