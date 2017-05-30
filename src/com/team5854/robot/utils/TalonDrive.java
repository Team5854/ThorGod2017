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
			list[4].set(list[0].getDeviceID());
			list[5] = new CANTalon(7);	
			list[5].changeControlMode(CANTalon.TalonControlMode.Follower);
			list[5].set(list[1].getDeviceID());
			list[6] = new CANTalon(6);	
			list[6].changeControlMode(CANTalon.TalonControlMode.Follower);
			list[6].set(list[2].getDeviceID());
			list[7] = new CANTalon(8);	
			list[7].changeControlMode(CANTalon.TalonControlMode.Follower);
			list[7].set(list[3].getDeviceID());
		}
		
		roboDrive = new RobotDrive(list[0], list[2], list[1], list[3]);
	
	}
	/**
	 * CANTalon four motor drive system.
	 * @param fl - Front Left
	 * @param rl - Rear Left
	 * @param fr - Front Right
	 * @param rr - Rear Right
	 */
	public TalonDrive(int fl, int rl, int fr, int rr) {
		//create first set of motors
		list[0] = new CANTalon(fl);
		list[0].changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		list[1] = new CANTalon(fr);
		list[1].changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		list[2] = new CANTalon(rl);
		list[2].changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		list[3] = new CANTalon(rr);
		list[3].changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		
		roboDrive = new RobotDrive(list[0], list[2], list[1], list[3]);
	
	}
	/**
	 * CANTalon eight motor drive system
	 * @param fl1 - Front Left One
	 * @param rl1 - Rear Left One
	 * @param fr1 - Front Right One
	 * @param rr1 - Rear Right One
	 * @param fl2 - Front Left Two
	 * @param rl2 - Rear Left Two
	 * @param fr2 - Front Right Two
	 * @param rr2 - Rear Right Two
	 */
	public TalonDrive(int fl1, int rl1, int fr1, int rr1, int fl2, int rl2, int fr2, int rr2) {
		//create first set of motors
		list[0] = new CANTalon(fl1);
		list[0].changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		list[1] = new CANTalon(fr1);
		list[1].changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		list[2] = new CANTalon(rl1);
		list[2].changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		list[3] = new CANTalon(rr1);
		list[3].changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		
		//create second set of motors
		list[4] = new CANTalon(fl2);	
		list[4].changeControlMode(CANTalon.TalonControlMode.Follower);
		list[4].set(list[0].getDeviceID());
		list[5] = new CANTalon(fr2);	
		list[5].changeControlMode(CANTalon.TalonControlMode.Follower);
		list[5].set(list[1].getDeviceID());
		list[6] = new CANTalon(rl2);	
		list[6].changeControlMode(CANTalon.TalonControlMode.Follower);
		list[6].set(list[2].getDeviceID());
		list[7] = new CANTalon(rr2);	
		list[7].changeControlMode(CANTalon.TalonControlMode.Follower);
		list[7].set(list[3].getDeviceID());
		
		roboDrive = new RobotDrive(list[0], list[2], list[1], list[3]);
	
	}
	
	
	public void mecanumDrive_Cartesian(double x, double y, double rotation, double gyroAngle) {
		roboDrive.mecanumDrive_Cartesian(x, y, rotation, gyroAngle);
	}
	public void mecanumDrive_Polar(double magnitude, double direction, double rotation) {
		roboDrive.mecanumDrive_Polar(magnitude, direction, rotation);
	}
	public void arcadeDrive(double moveValue, double rotateValue) {
		roboDrive.arcadeDrive(moveValue, rotateValue);
	}
	public void tankDrive(double leftValue, double rightValue) {
		roboDrive.tankDrive(leftValue, rightValue);
	}
	public void drive(double outputMagnitude, double curve) {
		roboDrive.drive(outputMagnitude, curve);
	}
	
	/**
	 * Set how fast each side of the robot drives. (kind of like tank)
	 * @param leftOutput - speed of left side
	 * @param rightOutput - speed of right side.
	 */
	public void setLeftRightMotorOutputs(double leftOutput, double rightOutput) {
		roboDrive.setLeftRightMotorOutputs(leftOutput, rightOutput);
	}
	
	/**
	 * Sets the talon ramp speed. auto ramps the talons.
	 * @param isAuto - If your are in auto or not. Could use RoboState.isAuto()
	 * @param rampRate - How fast you want to ramp. Research how to use correctly!
	 */
	public void setRampRate(boolean isAuto, double rampRate) {
		int g = 4;
		if (isAuto) {
			g = 2;
		}
		for (int i = 0; i < g; i++) {
			list[i].setCloseLoopRampRate(rampRate);
		}
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
