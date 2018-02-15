package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;
import org.usfirst.frc.team4132.robot.XboxControllerMap;

import edu.wpi.first.wpilibj.command.Command;

public class UseGrabber extends Command{
	private double maxSpeed = 1;
	public UseGrabber() {
		super("UseGrabber");
		requires(Robot.grabberSystem);
	}
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void execute(){
		
		Robot.grabberSystem.leftGrabber.set(1);
		if(Robot.m_oi.stickOne.getRawButton(XboxControllerMap.C)) {
			Robot.grabberSystem.leftGrabber.set(maxSpeed);
		}//
		else if(Robot.m_oi.stickOne.getRawButton(XboxControllerMap.D)) {
			Robot.grabberSystem.rightGrabber.set(maxSpeed);
		}
		
	}
}
