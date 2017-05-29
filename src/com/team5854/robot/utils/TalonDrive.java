package com.team5854.robot.utils;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;

public class TalonDrive {
	RobotDrive roboDrive;
	CANTalon fl1, fl2;
	CANTalon fr1, fr2;
	CANTalon rl1, rl2;
	CANTalon rr1, rr2;
	CANTalon[] list = {fl1, fr1, rl1, rr1, fl2, fr2, rl2, rr2};
	/**
	 * Create a basic drive train. <br>
	 * if isEight is true, creates an eight motor drive train. <br>
	 * sets default pin layout to. <br>
	 * 1 &nbsp &nbsp &nbsp 3<br>
	 * 5 &nbsp &nbsp &nbsp 7<br>		
	 * <br>
	 * <br>
	 * 2 &nbsp &nbsp &nbsp 4<br>
	 * 6 &nbsp &nbsp &nbsp 8<br>
	 */
	public TalonDrive(boolean isEight) {
		//create first set of motors
		list[0] = new CANTalon(1);
		list[0].changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		list[1] = new CANTalon(3);
		list[1].changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		list[2] = new CANTalon(2);
		list[2].changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		list[3] = new CANTalon(4);
		list[3].changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		
		if(isEight){
			//create second set of motors
			list[4] = new CANTalon(5);	
			list[4].changeControlMode(CANTalon.TalonControlMode.Follower);
			list[4].set(fl1.getDeviceID());
			list[5] = new CANTalon(7);	
			list[5].changeControlMode(CANTalon.TalonControlMode.Follower);
			list[5].set(fr1.getDeviceID());
			list[6] = new CANTalon(6);	
			list[6].changeControlMode(CANTalon.TalonControlMode.Follower);
			list[6].set(rl1.getDeviceID());
			list[7] = new CANTalon(8);	
			list[7].changeControlMode(CANTalon.TalonControlMode.Follower);
			list[7].set(rr1.getDeviceID());
		}
		
		roboDrive = new RobotDrive(list[0], list[2], list[1], list[3]);
	
	}
	public void mecanumDrive_Cartesian(double x, double y, double rotation, double gyroAngle) {
		roboDrive.mecanumDrive_Cartesian(x, y, rotation, gyroAngle);
	}
	public void arcadeDrive(double moveValue, double rotateValue) {
		roboDrive.arcadeDrive(moveValue, rotateValue);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Method that changes the front two motors to position and the rest to follower.
	 */
	public void setToAuto() {
		for (int i = 0; i < 2; i++) {
			list[0].changeControlMode(CANTalon.TalonControlMode.Position); //Change control mode of talon, default is PercentVbus (-1.0 to 1.0)
			list[0].setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder); //Set the feedback device that is hooked up to the talon
			list[0].setPID(0.5, 0.001, 0.0); //Set the PID constants (p, i, d)
			list[0].enableControl(); //Enable PID control on the talon
			list[0].setVoltageRampRate(1);
		}
		for (int i = 2; i < 8; i += 2) {
			list[i].changeControlMode(CANTalon.TalonControlMode.Follower);
			list[i].set(list[0].getDeviceID());
			list[i+1].changeControlMode(CANTalon.TalonControlMode.Follower);
			list[i+1].set(list[1].getDeviceID());	
		}
	}
	
	/**
	 * tells the front two motors to move until encoders reach set pos.
	 * @param pos - position you wish to go to.
	 */
	public void moveToPosition(double pos) {
		list[0].set(pos);
		list[1].set(pos);
	}
	
	/**
	 * returns the drive system back to %VBus for teleop control.
	 */
	public void setToTeleop() {
		for (int i = 0; i < 4; i++) {
			list[i].changeControlMode(CANTalon.TalonControlMode.PercentVbus); //Change control mode of talon, default is PercentVbus (-1.0 to 1.0)
			list[i].setPID(0.0, 0.0, 0.0); //Set the PID constants (p, i, d)
			list[i].enableControl(); //Enable PID control on the talon
		}
		for (int i = 4; i < 8; i++) {
			list[i].changeControlMode(CANTalon.TalonControlMode.Follower);
			list[i].set(list[i-4].getDeviceID());
		}
	}
}
