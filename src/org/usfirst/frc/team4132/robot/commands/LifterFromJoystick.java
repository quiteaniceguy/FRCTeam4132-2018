package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;
import org.usfirst.frc.team4132.robot.XboxControllerMap;

import edu.wpi.first.wpilibj.command.Command;

public class LifterFromJoystick extends Command{
	private double lifterLowerSpeed = - 0.8d;
	private double lifterRaiseSpeed = .8d;
	
	public LifterFromJoystick() {
		super("LifterFromJoystick");
		requires(Robot.lifterSystem);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void execute() {
		double lifterSpeed = 0;
		
		if(Robot.m_oi.stickOne.getRawButton(XboxControllerMap.LB)) {
			lifterSpeed = lifterLowerSpeed;
		}
		else if(Robot.m_oi.stickOne.getRawButton(XboxControllerMap.RB)){
			lifterSpeed = lifterRaiseSpeed;
		}
		
		Robot.lifterSystem.setSpeed(lifterSpeed);
		
	}
	

}
