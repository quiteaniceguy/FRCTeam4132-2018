package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class UseGrabber extends Command{
	private double maxSpeed = 0.5;
	public UseGrabber() {
		super("UseGrabber");
		requires(Robot.grabberSystem);
	}
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void execute(){
		
		if(Robot.m_oi.stickOne.getRawButton(3)) {
			Robot.grabberSystem.setSpeed(maxSpeed);
		}//
		else if(Robot.m_oi.stickOne.getRawButton(4)) {
			Robot.grabberSystem.setSpeed(maxSpeed);
		}
		
	}
}
