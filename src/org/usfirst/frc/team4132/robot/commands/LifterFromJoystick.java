package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;
import org.usfirst.frc.team4132.robot.XboxControllerMap;

import edu.wpi.first.wpilibj.command.Command;

public class LifterFromJoystick extends Command{
	private final double LIFTER_CAP = .8;
	private final double INVERT_LIFT_CONTROLLER = -1;
	private double lifterLowerSpeed = - 0.3d;
	private double lifterRaiseSpeed = .7d;
	
	
	
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
		/* alternate lifter controls */
		/*
		if(Robot.m_oi.stickOne.getRawButton(XboxControllerMap.LB)) {
			lifterSpeed = lifterLowerSpeed;
		}
		else if(Robot.m_oi.stickOne.getRawButton(XboxControllerMap.RB)){
			lifterSpeed = lifterRaiseSpeed;
		}
		*/
		lifterSpeed = Robot.m_oi.stickOne.getRawAxis(XboxControllerMap.RIGHT_JOY_Y) * LIFTER_CAP * INVERT_LIFT_CONTROLLER;
		Robot.lifterSystem.setSpeed(lifterSpeed);
		
	}
	

}
