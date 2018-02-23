package org.usfirst.frc.team1014.robot.subsystems;

import org.usfirst.frc.team1014.robot.RobotMap;
import org.usfirst.frc.team1014.robot.util.LogUtil;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import badlog.lib.BadLog;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem {

	TalonSRX liftMotor;

	DigitalInput bottomLimitSwitch, topLimitSwitch;

	public Lifter() {
	
		liftMotor = new TalonSRX(RobotMap.LIFT_1_ID);
		bottomLimitSwitch = new DigitalInput(0);
		topLimitSwitch = new DigitalInput(1);

		BadLog.createTopic("Lift/Lifter Output Percent", BadLog.UNITLESS, () -> liftMotor.getMotorOutputPercent(),
				"hide", "join:Lift/Output Percents");

		BadLog.createTopic("Lift/Lifter Current", "A", () -> liftMotor.getOutputCurrent(), "hide",
				"join:Lift/Output Currents");

		BadLog.createTopic("Lift/Lifter Voltage", "V", () -> liftMotor.getMotorOutputVoltage(), "hide",
				"join:Lift/Output Voltages");

		BadLog.createTopicStr("Lift/Bottom Limit Switch", "bool", () -> LogUtil.fromBool(isAtBottom()));
		BadLog.createTopicStr("Lift/Top Limit Switch", "bool", () -> LogUtil.fromBool(isAtTop()));
	}

	private boolean isAtTop() {
		return topLimitSwitch.get();
	}

	private boolean isAtBottom() {
		return !bottomLimitSwitch.get();
	}

	public void move(double speed) {
		liftMotor.set(ControlMode.PercentOutput, speed);

	}

	public void safeMove(double speed) {

		/*if(speed < 0) {
			if(isAtBottom())
				speed = 0;
		} else {
			if(isAtTop())
				speed = 0;
		}*/
		liftMotor.set(ControlMode.PercentOutput, speed);
	}


	@Override
	protected void initDefaultCommand() {
	}

}