package org.usfirst.frc.team1014.robot;

import java.util.Optional;

import org.usfirst.frc.team1014.robot.commands.AutoDelay;
import org.usfirst.frc.team1014.robot.commands.Autonomous;
import org.usfirst.frc.team1014.robot.commands.Teleop;
import org.usfirst.frc.team1014.robot.commands.auto.AutoMode;
import org.usfirst.frc.team1014.robot.commands.auto.StartCenterScale;
import org.usfirst.frc.team1014.robot.commands.auto.StartCenterSwitch;
import org.usfirst.frc.team1014.robot.commands.auto.StartLeft;
import org.usfirst.frc.team1014.robot.commands.auto.StartRight;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1014.robot.subsystems.Grabber;
import org.usfirst.frc.team1014.robot.subsystems.Lifter;
import org.usfirst.frc.team1014.robot.util.LogUtil;

import badlog.lib.BadLog;
import badlog.lib.DataInferMode;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
	public static OI oi;

	Drivetrain driveTrain;

	Lifter lifter;
	Grabber grabber;

	Teleop teleopCG;
	Autonomous autoCG;

	private BadLog logger;
	private long startTimeNS;
	private long lastLog;
	SendableChooser autoChooser;

	@Override
	public void robotInit() {
				
		startTimeNS = System.nanoTime();
		lastLog = System.currentTimeMillis();
		String session = LogUtil.genSessionName();
		System.out.println("Info: Starting session " + session);
		logger = BadLog.init("/home/lvuser/log/" + session + ".bag");
		{
			BadLog.createValue("Start Time", LogUtil.getTimestamp());
			BadLog.createValue("Event Name",
					Optional.ofNullable(DriverStation.getInstance().getEventName()).orElse(""));
			BadLog.createValue("Match Type", DriverStation.getInstance().getMatchType().toString());
			BadLog.createValue("Match Number", "" + DriverStation.getInstance().getMatchNumber());
			BadLog.createValue("Alliance", DriverStation.getInstance().getAlliance().toString());
			BadLog.createValue("Location", "" + DriverStation.getInstance().getLocation());

			BadLog.createTopicSubscriber("Time", "s", DataInferMode.DEFAULT, "hide", "delta", "xaxis");

			BadLog.createTopicStr("System/Browned Out", "bool", () -> LogUtil.fromBool(RobotController.isBrownedOut()));
			BadLog.createTopic("System/Battery Voltage", "V", () -> RobotController.getBatteryVoltage());
			BadLog.createTopicStr("System/FPGA Active", "bool", () -> LogUtil.fromBool(RobotController.isSysActive()));
			BadLog.createTopic("Match Time", "s", () -> DriverStation.getInstance().getMatchTime());

			oi = new OI();
			driveTrain = new Drivetrain();
			grabber = new Grabber();
			lifter = new Lifter();

			teleopCG = new Teleop(driveTrain, grabber, lifter);
			autoCG = new Autonomous(driveTrain, lifter, grabber);


			autoChooser = new SendableChooser();

			autoChooser.addDefault("Center Switch", AutoMode.CENTER_SWITCH);
			autoChooser.addObject("Right Side", AutoMode.RIGHT);
			autoChooser.addObject("Left Side", AutoMode.LEFT);
			autoChooser.addObject("Right Side No Switch", AutoMode.RIGHT_NO_SWITCH);
			autoChooser.addObject("Left Side No Switch", AutoMode.LEFT_NO_SWITCH);
			autoChooser.addObject("Right Side No Scale", AutoMode.RIGHT_NO_SCALE);
			autoChooser.addObject("Left Side No Scale", AutoMode.LEFT_NO_SCALE);
			autoChooser.addObject("Center Scale", AutoMode.CENTER_SCALE);
			
			SmartDashboard.putNumber("Delay", 0);
			SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
			CameraServer.getInstance().startAutomaticCapture();

		}
		logger.finishInitialization();
	}

	@Override
	public void autonomousInit() {
		Scheduler.getInstance().removeAll();
				
		driveTrain.resetAHRS();
		
		autoCG.addSequential(new AutoDelay((int) SmartDashboard.getNumber("Delay", 0)));
		
		switch((AutoMode)autoChooser.getSelected()) {
			
			case CENTER_SCALE:
				autoCG.addSequential(new StartCenterScale(driveTrain, lifter, grabber));
				break;
			case RIGHT:
				autoCG.addSequential(new StartRight(driveTrain, lifter, grabber, 0, driveTrain.getScaleSide(), driveTrain.getSwitchSide()));
				break;
			case LEFT:
				autoCG.addSequential(new StartLeft(driveTrain, lifter, grabber, 0, driveTrain.getScaleSide(), driveTrain.getSwitchSide()));
				break;
			case RIGHT_NO_SCALE:
				autoCG.addSequential(new StartRight(driveTrain, lifter, grabber, 2, driveTrain.getScaleSide(), driveTrain.getSwitchSide()));
				break;
			case RIGHT_NO_SWITCH:
				autoCG.addSequential(new StartRight(driveTrain, lifter, grabber, 1, driveTrain.getScaleSide(), driveTrain.getSwitchSide()));
				break;
			case LEFT_NO_SCALE:
				autoCG.addSequential(new StartLeft(driveTrain, lifter, grabber, 2, driveTrain.getScaleSide(), driveTrain.getSwitchSide()));
				break;
			case LEFT_NO_SWITCH:
				autoCG.addSequential(new StartLeft(driveTrain, lifter, grabber, 1, driveTrain.getScaleSide(), driveTrain.getSwitchSide()));
				break;
			default:		//Center Switch
				autoCG.addSequential(new StartCenterSwitch(driveTrain, lifter, grabber));
				
								
		}
		
		autoCG.start();
	}

	@Override
	public void teleopInit() {
		Scheduler.getInstance().removeAll();

		teleopCG.start();
	}

	@Override
	public void testInit() {
		Scheduler.getInstance().removeAll();
	}

	@Override
	public void disabledInit() {
		Scheduler.getInstance().removeAll();
	}

	@Override
	public void autonomousPeriodic() {
		periodic();
	}

	@Override
	public void teleopPeriodic() {

		periodic();
	}

	@Override
	public void testPeriodic() {
		periodic();
	}

	@Override
	public void disabledPeriodic() {
		periodic();
	}

	private void periodic() {
		double currentTime = ((double) (System.nanoTime() - startTimeNS)) / 1_000_000_000d;
		BadLog.publish("Time", currentTime);

		Scheduler.getInstance().run();

		logger.updateTopics();
		// Only log once every 250ms in disabled, to save disk space
		long currentMS = System.currentTimeMillis();
		if (!DriverStation.getInstance().isDisabled() || (currentMS - lastLog) >= 250) {
			lastLog = currentMS;
			logger.log();
		}
	}
}