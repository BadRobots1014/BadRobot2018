/*package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveUltra extends Command{

	double power, distance;
	Drivetrain drive;
	int count;
	
	public AutoDriveUltra(double power, double distance, Drivetrain drive) {
		this.power = power;
		this.distance = distance;
		this.drive = drive;
	}
	
	protected void initialize() {
		count = 0;
	}
	
	protected void execute() {
		drive.directDrive(power, power);
		/*if(drive.getUltraDistance() < distance) {
			count++;
		}*/
	/*}
	
	protected void end() {
		drive.directDrive(0, 0);
	}
	@Override
	protected boolean isFinished() {
		if(drive.getUltraDistance() < distance) {
			return true;
		}
		return false;
	}

}*/
