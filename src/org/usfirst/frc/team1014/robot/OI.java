package org.usfirst.frc.team1014.robot;

import edu.wpi.first.wpilibj.XboxController;


public class OI {
	public XboxController controller0;
	public XboxController controller1;

	public OI() {
		controller0 = new XboxController(0);

		// TODO: Use DriverStation to auto detect
		controller1 = new XboxController(1);			
	
	}
}
