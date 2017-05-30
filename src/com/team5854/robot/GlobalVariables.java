package com.team5854.robot;

import com.team5854.robot.utils.RobotState;
import com.team5854.robot.utils.TalonDrive;

import edu.wpi.first.wpilibj.Joystick;

public class GlobalVariables {
	public static RobotState RoboState; 
	public static Joystick js0 = new Joystick(0);
	public static Joystick js1 = new Joystick(1);
	public static TalonDrive drive = new TalonDrive(true);

	public static boolean isDebug = true;

	
	
	public static void print(String print) {
		if (isDebug) {
			System.out.println(print);
		}
	}
}
