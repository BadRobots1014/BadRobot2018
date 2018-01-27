package org.usfirst.frc.team1014.robot.subsystems;

import org.usfirst.frc.team1014.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	TalonSRX rightFront, rightBack, leftFront, leftBack;
	double currentAngle;
	AHRS navx;

	public Drivetrain() {
		rightFront = new TalonSRX(RobotMap.DRIVE_RIGHT_1_ID);
		rightBack = new TalonSRX(RobotMap.DRIVE_RIGHT_2_ID);
		leftFront = new TalonSRX(RobotMap.DRIVE_LEFT_1_ID);
		leftBack = new TalonSRX(RobotMap.DRIVE_LEFT_2_ID);

		rightBack.follow(rightFront);
		leftBack.follow(leftFront);

		navx = new AHRS(SPI.Port.kMXP);
		navx.zeroYaw();
	}
	
	public void zeroYaw() {
		navx.zeroYaw();
	}
	
	public double getYaw() {
		return navx.getYaw();
	}

	public void directDrive(double left, double right) {
		rightFront.set(ControlMode.PercentOutput, -right);
		leftFront.set(ControlMode.PercentOutput, left);
	}

	public void driveStraight(double speed, double targetAngle) 
	{
		System.out.println(getYaw() + "       " + targetAngle);
		double error = getYaw() - targetAngle;
		if(error != 5)
		{
			int direction = -1;
			int sum = (int) (getYaw() + 180);
			
			if(sum >= 360)
			{
				sum -= 360;
			}
			if(getYaw() <= targetAngle && targetAngle <= sum)
			{
				direction *= -1;
			}
			
			if(direction > 0)
			{
				rightFront.set(ControlMode.PercentOutput, .2);
				leftFront.set(ControlMode.PercentOutput, -.2);
			}
			else
			{
				rightFront.set(ControlMode.PercentOutput, -.2);
				leftFront.set(ControlMode.PercentOutput, .2);
			}
		}
		else
		{
			rightFront.set(ControlMode.PercentOutput, speed);
			leftFront.set(ControlMode.PercentOutput, speed);
		}
		
	}
	
	public void rotate(double targetAngle, double power) {
		if(targetAngle < 0)
			directDrive(-power, power);
		else
			directDrive(power, -power);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
