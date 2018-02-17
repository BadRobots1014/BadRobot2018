package org.usfirst.frc.team1014.robot.subsystems;

import org.usfirst.frc.team1014.robot.RobotMap;
import org.usfirst.frc.team1014.robot.util.MiniPID;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Ultrasonic;

import badlog.lib.BadLog;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	TalonSRX rightFront, rightBack, leftFront, leftBack;

	AHRS ahrs;

	private double targetAngle;
	MiniPID miniPID;
	Ultrasonic ultra = new Ultrasonic(0,1);
	double currentAngle;
	AHRS navx;

	public Drivetrain() {
		rightFront = new TalonSRX(RobotMap.DRIVE_RIGHT_1_ID);
		rightBack = new TalonSRX(RobotMap.DRIVE_RIGHT_2_ID);
		leftFront = new TalonSRX(RobotMap.DRIVE_LEFT_1_ID);
		leftBack = new TalonSRX(RobotMap.DRIVE_LEFT_2_ID);

		rightBack.follow(rightFront);
		leftBack.follow(leftFront);

		// Only need to log master controllers for this
		BadLog.createTopic("Drivetrain/Right Output Percent", BadLog.UNITLESS, () -> rightFront.getMotorOutputPercent(),
				"hide", "join:Drivetrain/Output Percents");
		BadLog.createTopic("Drivetrain/Left Output Percent", BadLog.UNITLESS, () -> leftFront.getMotorOutputPercent(),
				"hide", "join:Drivetrain/Output Percents");

		BadLog.createTopic("Drivetrain/Right Front Current", "A", () -> rightFront.getOutputCurrent(), "hide",
				"join:Drivetrain/Output Currents");
		BadLog.createTopic("Drivetrain/Right Back Current", "A", () -> rightBack.getOutputCurrent(), "hide",
				"join:Drivetrain/Output Currents");
		BadLog.createTopic("Drivetrain/Left Front Current", "A", () -> leftFront.getOutputCurrent(), "hide",
				"join:Drivetrain/Output Currents");
		BadLog.createTopic("Drivetrain/Left Back Current", "A", () -> leftBack.getOutputCurrent(), "hide",
				"join:Drivetrain/Output Currents");

		BadLog.createTopic("Drivetrain/Right Front Voltage", "V", () -> rightFront.getMotorOutputVoltage(), "hide",
				"join:Drivetrain/Output Voltages");
		BadLog.createTopic("Drivetrain/Right Back Voltage", "V", () -> rightBack.getMotorOutputVoltage(), "hide",
				"join:Drivetrain/Output Voltages");
		BadLog.createTopic("Drivetrain/Left Front Voltage", "V", () -> leftFront.getMotorOutputVoltage(), "hide",
				"join:Drivetrain/Output Voltages");
		BadLog.createTopic("Drivetrain/Left Back Voltage", "V", () -> leftBack.getMotorOutputVoltage(), "hide",
				"join:Drivetrain/Output Voltages");

		ahrs = new AHRS(Port.kMXP);
		ahrs.zeroYaw();
		
		BadLog.createTopic("Drivetrain/Angle", "deg", () -> getAngleCCW());

		targetAngle = 0;
		miniPID = new MiniPID(.05, .001, .20);
		miniPID.setOutputLimits(.5);
		navx = new AHRS(SPI.Port.kMXP);
		navx.zeroYaw();
		
		ultra.setAutomaticMode(true);
	}
	
	public void zeroYaw() {
		ahrs.zeroYaw();
	}

	public void directDrive(double left, double right) 
	{
		System.out.println(ultra.getRangeInches());
		//rightFront.set(ControlMode.PercentOutput, -right);
		//leftFront.set(ControlMode.PercentOutput, left);
	}
	
	public double getYaw() {
		return ahrs.getYaw();
	}
	
	public void rotate(double targetAngle, double power) {
		if(targetAngle < 0)
			directDrive(-power, power);
		else
			directDrive(power, -power);
	}
	
	public void autoTurn() {
		double output = miniPID.getOutput(getAngleCCW(), targetAngle);
		directDrive(-output, output);
	}
	
	public void driveStraight(double speed) {
		double turnComp = miniPID.getOutput(getAngleCCW(), targetAngle);
		directDrive(speed - turnComp, speed + turnComp);
		System.out.println(ahrs.getDisplacementX() + ", " + ahrs.getDisplacementY() + ", " + ahrs.getDisplacementZ());
	}

	public void initDefaultCommand() {
	}

	public double getTargetAngle() {
		return targetAngle;
	}
	
	public int switchSide()
	{
		if(DriverStation.getInstance().getGameSpecificMessage().charAt(0) == 'R')
			return 1;
		return -1;
	}
	
	public int scaleSide()
	{
		if(DriverStation.getInstance().getGameSpecificMessage().charAt(1) == 'R')
			return 1;
		return -1;
	}

	public void setTargetAngle(double targetAngle) {
		this.targetAngle = targetAngle;
	}
	
	private double getAngleCCW() {
		return -ahrs.getAngle();
	}
}