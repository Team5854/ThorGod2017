package org.usfirst.frc.team5854.robot;

import com.team5854.robot.Autonomous;
import com.team5854.robot.Disable;
import com.team5854.robot.Teleop;
import com.team5854.robot.Test;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {
	
	@Override
	public void robotInit() {
		com.team5854.robot.Robot.init();
	}
	
	@Override
	public void robotPeriodic() {
		com.team5854.robot.Robot.periodic();
	}

	@Override
	public void autonomousInit() {
		Autonomous.init();
	}

	private int i = 0;
	@Override
	public void autonomousPeriodic() {
		if (i == 0) {
			Autonomous.periodic();
			i++;
		}
	}

	@Override
	public void teleopInit() {
		Teleop.init();
	}
	
	@Override
	public void teleopPeriodic() {
		Teleop.periodic();
	}

	@Override
	public void disabledInit() {
		Disable.init();
	}
	
	@Override
	public void disabledPeriodic() {
		Disable.periodic();
	}

	@Override
	public void testInit() {
		Test.init();
	}
	
	@Override
	public void testPeriodic() {
		Test.periodic();
	}
}

