package org.usfirst.frc.team1014.robot;

import java.util.Optional;

import badlog.lib.BadLog;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;

public class OI {
	public XboxController controller0;
	public XboxController controller1;

	public OI() {
		controller0 = new XboxController(0);

		controller1 = new XboxController(1);

		for (int i = 0; i < DriverStation.kJoystickPorts; i++) {
			BadLog.createValue("Input/Controller " + i + " Type",
					Optional.ofNullable(DriverStation.getInstance().getJoystickName(i)).orElse("Unknown"));
		}
	}
}
