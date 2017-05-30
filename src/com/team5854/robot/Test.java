package com.team5854.robot;

import static com.team5854.robot.GlobalVariables.*;

public class Test {
	public static void init() {
		
	}
	static boolean con = true;
	public static void periodic() {
		if (con) {
			print("Start Moving");
			drive.moveToPosition(100);
			print("Stopped Moving");
			con = false;
		}
	}
}
