package com.team5854.robot;

import com.ctre.CANTalon.FeedbackDevice;
import static com.team5854.robot.GlobalVariables.*;

import edu.wpi.first.wpilibj.CANSpeedController.ControlMode;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

@SuppressWarnings("unused")
public class Autonomous {
	static final String moveForward = "moveForward";
	static final String customAuto = "My Auto";
	static String autoSelected;
	static SendableChooser<String> chooser = new SendableChooser<>();

	public static void init() {
		chooser.addObject("Move Forward", moveForward);
		SmartDashboard.putData("Auto choices", chooser);
		
		drive.setToAuto();
	}

	public static void periodic() {
		autoSelected = chooser.getSelected();
		switch (autoSelected) {
		case moveForward:
			drive.moveToPosition(1000);
			break;
		default:
			
			break;		
		}
	}
}
