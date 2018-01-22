package org.usfirst.frc.team1014.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc.team1014.robot.commands.Teleop;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

public class Robot extends TimedRobot {
	public static OI oi;

	Drivetrain driveTrain;

	Teleop teleopCG;

	@Override
	public void robotInit() {
		oi = new OI();
		driveTrain = new Drivetrain();

		teleopCG = new Teleop(driveTrain);
	}

	@Override
	public void teleopInit() {
		Scheduler.getInstance().removeAll();

		teleopCG.start();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
}
