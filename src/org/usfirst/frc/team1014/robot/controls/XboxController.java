package org.usfirst.frc.team1014.robot.controls;

import edu.wpi.first.wpilibj.Joystick;

/**
This is a class that adds methods to the Joystick class specific to Xbox
controllers. This ensures that you are not using magic numbers for axis or
button ids in the project.
*/
public class XboxController extends Joystick {

	/*
	 * These values are from the Driver Station controller tabs.
	 */
	private static int LEFT_STICK_X = 0, LEFT_STICK_Y = 1, RIGHT_STICK_X = 4, RIGHT_STICK_Y = 5, A_BUTTON = 1,
			B_BUTTON = 2, X_BUTTON = 3, Y_BUTTON = 4, LB = 5, RB = 6, SELECT = 7, START = 8, LEFT_JOY_CLICK = 9,
			RIGHT_JOY_CLICK = 10, LEFT_TRIGGER = 2, RIGHT_TRIGGER = 3;

	public XboxController(int port)
	{
		super(port);
	}

	private double deadzone(double input)
	{
		return 0;
	}

	public double getLeftStickX()
	{
		return deadzone(this.getRawAxis(LEFT_STICK_X));
	}

	public double getLeftStickY()
	{
		return deadzone(this.getRawAxis(LEFT_STICK_Y));
	}

	public double getRightStickX()
	{
		return deadzone(this.getRawAxis(RIGHT_STICK_X));
	}

	public double getRightStickY()
	{
		return deadzone(this.getRawAxis(RIGHT_STICK_Y));
	}

	public double getRightTrigger()
	{
		return deadzone(this.getRawAxis(RIGHT_TRIGGER));
	}

	public double getLeftTrigger()
	{
		return deadzone(this.getRawAxis(LEFT_TRIGGER));
	}

	public boolean isXButtonPressed()
	{
		return this.getRawButton(X_BUTTON);
	}

	public boolean isYButtonPressed()
	{
		return this.getRawButton(Y_BUTTON);
	}

	public boolean isAButtonPressed()
	{
		return this.getRawButton(A_BUTTON);
	}

	public boolean isBButtonPressed()
	{
		return this.getRawButton(B_BUTTON);
	}

	public boolean isRBButtonPressed()
	{
		return this.getRawButton(RB);
	}

	public boolean isLBButtonPressed()
	{
		return this.getRawButton(LB);
	}

	public boolean isLeftJoyClick()
	{
		return this.getRawButton(RIGHT_JOY_CLICK);
	}

	public boolean isRightJoyClick()
	{
		return this.getRawButton(LEFT_JOY_CLICK);
	}

	public boolean isSelectButtonPressed()
	{
		return this.getRawButton(SELECT);
	}

	public boolean isStartButtonPressed()
	{
		return this.getRawButton(START);
	}

}
