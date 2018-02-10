package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveFromJoystick extends Command{
	
	private int invert = -1;
	private double oldInput = 0;
	private double newInput = 0;
	private double maxChange = 0.0125;
	
	public DriveFromJoystick(){
		super("DriveFromJoystick");
		requires(Robot.driveSystem);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void execute(){
		newInput = Robot.m_oi.stickOne.getRawAxis(0);
		
		double yMovement = 0;
		
		/* this is all garbage
		if(Math.abs(newInput-oldInput) > maxChange && newInput > oldInput) {
			yMovement = oldInput + maxChange;
			oldInput = yMovement;
		}
		else if(Math.abs(newInput-oldInput) > maxChange && newInput < oldInput) {
			yMovement = oldInput - maxChange;
			oldInput = yMovement;
		}
		else {
			yMovement = newInput;
			oldInput = newInput;
		}
		*/
		
		yMovement = newInput;
		double xMovement = invert * Robot.m_oi.stickOne.getRawAxis(1);
		double movementRotation = Robot.m_oi.stickOne.getRawAxis(2);
		
		Robot.driveSystem.drive(yMovement, xMovement, movementRotation);
		
		//System.out.println("getting the angle: " + Robot.ahrs.getAngle());
	}

}
