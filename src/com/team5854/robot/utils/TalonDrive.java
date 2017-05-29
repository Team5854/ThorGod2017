package com.team5854.robot.utils;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;

public class TalonDrive {
	RobotDrive roboDrive;
	CANTalon fl1, fl2;
	CANTalon fr1, fr2;
	CANTalon rl1, rl2;
	CANTalon rr1, rr2;
	
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
		fl1 = new CANTalon(1);
		fl1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		fr1 = new CANTalon(3);
		fl1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		rl1 = new CANTalon(2);
		rl1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		rr1 = new CANTalon(4);
		rr1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		
		if(isEight){
			//create second set of motors
			fl2 = new CANTalon(5);	
			fl2.changeControlMode(CANTalon.TalonControlMode.Follower);
			fl2.set(fl1.getDeviceID());
			fr2 = new CANTalon(7);	
			fr2.changeControlMode(CANTalon.TalonControlMode.Follower);
			fr2.set(fr1.getDeviceID());
			rl2 = new CANTalon(6);	
			rl2.changeControlMode(CANTalon.TalonControlMode.Follower);
			rl2.set(rl1.getDeviceID());
			rr2 = new CANTalon(8);	
			rr2.changeControlMode(CANTalon.TalonControlMode.Follower);
			rr2.set(rr1.getDeviceID());
		}
		
		roboDrive = new RobotDrive(fl1, rl1, fr1, rr1);
	}
	public void mecanumDrive_Cartesian(double x, double y, double rotation, double gyroAngle) {
		roboDrive.mecanumDrive_Cartesian(x, y, rotation, gyroAngle);
	}
}
