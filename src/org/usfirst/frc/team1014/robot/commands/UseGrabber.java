package org.usfirst.frc.team1014.robot.commands;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1014.robot.subsystems.Grabber;

public class UseGrabber extends Command {
	private XboxController controller;
	private Grabber grabber;
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		if (controller.getBumper(Hand.kLeft)) {
			//Collect cubes
			grabber.turnCollect(1);
		}
		else if (controller.getBumper(Hand.kRight)) {
			// release
			grabber.turnRelease(1);
		}
	}
	
	public UseGrabber(XboxController controller, Grabber grabber)
	{
		requires(grabber);
		this.controller = controller;
		this.grabber = grabber;
	}

}
