package org.usfirst.frc.team1014.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc.team1014.robot.commands.Teleop;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import badlog.lib.BadLog;

public class Robot extends TimedRobot {
	public static OI oi;

	Drivetrain driveTrain;

	Teleop teleopCG;

	@Override
	public void robotInit() {
		BadLog logger = BadLog.init("test");
		{
			oi = new OI();
			driveTrain = new Drivetrain();

			teleopCG = new Teleop(driveTrain);
		}
		logger.finishInitialization();
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
