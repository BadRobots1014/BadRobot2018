package org.usfirst.frc.team1014.robot.subsystems;

import org.usfirst.frc.team1014.robot.RobotMap;
import org.usfirst.frc.team1014.robot.util.MiniPID;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	TalonSRX rightFront, rightBack, leftFront, leftBack;

	AnalogInput ultra;
	AHRS ahrs;

	private double targetAngle;
	MiniPID miniPID;

	public Drivetrain() {
		rightFront = new TalonSRX(RobotMap.DRIVE_RIGHT_1_ID);
		rightBack = new TalonSRX(RobotMap.DRIVE_RIGHT_2_ID);
		leftFront = new TalonSRX(RobotMap.DRIVE_LEFT_1_ID);
		leftBack = new TalonSRX(RobotMap.DRIVE_LEFT_2_ID);

		rightBack.follow(rightFront);
		leftBack.follow(leftFront);

		ahrs = new AHRS(Port.kMXP);
		ahrs.zeroYaw();
		
		ultra = new AnalogInput(1);

		targetAngle = 0;
		miniPID = new MiniPID(.05, .001, .20);
		miniPID.setOutputLimits(.5);
	}
	
	public double getUltraDistance() {
		return ultra.getValue();
	}

	public void directDrive(double left, double right) {
		rightFront.set(ControlMode.PercentOutput, -right);
		leftFront.set(ControlMode.PercentOutput, left);
	}

	public void autoTurn() {
		double output = miniPID.getOutput(ahrs.getAngle(), targetAngle);
		directDrive(output, -output);
	}
	
	public void driveStraight(double speed) {
		double turnComp = miniPID.getOutput(ahrs.getAngle(), targetAngle);
		directDrive(speed + turnComp, speed - turnComp);
		System.out.println(ahrs.getDisplacementX() + ", " + ahrs.getDisplacementY() + ", " + ahrs.getDisplacementZ());
	}

	public void initDefaultCommand() {
	}

	public double getTargetAngle() {
		return targetAngle;
	}

	public void setTargetAngle(double targetAngle) {
		this.targetAngle = targetAngle;
	}
}
