package org.usfirst.frc.team1014.robot;

import org.usfirst.frc.team1014.robot.commands.AutoCommandGroup;
import org.usfirst.frc.team1014.robot.commands.TeleDrive;
import org.usfirst.frc.team1014.robot.commands.Teleop;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
	public static OI oi;

	Drivetrain driveTrain;
	//public static Command fowards = new AutoDrive(50, 0.3); // the autonomous command the robot should run
	//public static Command turnClock = new AutoTurn(.5, 0.3, 1); // the autonomous command the robot should run
	//public static Command turnCount = new AutoTurn(.5, 0.3, -1); // the autonomous command the robot should run
	AutoCommandGroup autoGroup;
	public static Command tele;  // the autonomous command the robot should run
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	Teleop teleopCG;

	@Override

	public void robotInit() {
		oi = new OI();
		driveTrain = new Drivetrain();
		teleopCG = new Teleop(driveTrain);
	}
	
	@Override
	public void autonomousInit() 
	{

		// System.out.println(AutonomousManager.pollSwitches());
		Scheduler.getInstance().add(autoGroup);
		//Scheduler.getInstance().add(turnClock);
		//Scheduler.getInstance().add(turnCount);

	}
	
	@Override
	public void autonomousPeriodic() 
	{
		Scheduler.getInstance().run();
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
