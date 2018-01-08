package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveFromJoystick extends Command{
	
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
		double yMovement = Robot.m_oi.stickOne.getRawAxis(0);
		double xMovement = Robot.m_oi.stickOne.getRawAxis(1);
		double movementRotation = Robot.m_oi.stickOne.getRawAxis(2);
		
		Robot.driveSystem.drive(yMovement, xMovement, movementRotation);
	}

}
