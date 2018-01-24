package org.usfirst.frc.team1014.robot;

import java.util.Optional;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;

public class OI {
	public XboxController controller0;
	public Optional<XboxController> controller1;

	public OI() {
		controller0 = new XboxController(0);

		// TODO: Use DriverStation to auto detect
		//if(DriverStation.getInstance().getStickButtonCount(1) != 0) {
			
	//	}
		controller1 = Optional.of(new XboxController(1));
	}
}
