package com.team5854.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class RobotState {
	private boolean isAuto = false;
	private boolean isTest = false;
	public void checkState() {
		isAuto= DriverStation.getInstance().isAutonomous();
		isTest = DriverStation.getInstance().isTest();
	}
	public boolean isAuto() {
		return isAuto;
	}
	public boolean isTest() {
		return isTest;
	}
}
