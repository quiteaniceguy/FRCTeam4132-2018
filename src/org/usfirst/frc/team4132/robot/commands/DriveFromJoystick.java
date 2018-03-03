package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;
import org.usfirst.frc.team4132.robot.XboxControllerMap;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveFromJoystick extends Command{
	private final double DRIVE_SPEED = .8d;
	private int invert = -1;
	private double currSpeed = 0;
	private double desiredSpeed = 0;
	private double maxChange = 0.0125;
	
	DifferentialDrive robotDrive;
	
	public DriveFromJoystick(){
		super("DriveFromJoystick");
		requires(Robot.driveSystem);
		
		
		
		
		robotDrive = new DifferentialDrive(Robot.driveSystem.leftSpeedGrp(), Robot.driveSystem.rightSpeedGrp());
		
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void execute(){
		/*
		desiredSpeed = Robot.m_oi.stickOne.getRawAxis(XboxControllerMap.LEFT_JOY_Y);
		
		double yMovement = 0;
		double xMovement = 0;
		double movementRotation = 0;

		if(Math.abs(desiredSpeed - currSpeed) > maxChange){
			currSpeed += maxChange * (Math.abs(desiredSpeed-currSpeed) / desiredSpeed-currSpeed);
		}
		else {
			currSpeed = desiredSpeed;
		}
		
		yMovement = currSpeed * DRIVE_SPEED;
		xMovement = invert * Robot.m_oi.stickOne.getRawAxis(XboxControllerMap.LEFT_JOY_X) * DRIVE_SPEED;
		movementRotation = Robot.m_oi.stickOne.getRawAxis(2);
		
		robotDrive.arcadeDrive(yMovement, xMovement);
		
		currSpeed = desiredSpeed;
		
		//System.out.println("getting the angle: " + Robot.ahrs.getAngle());
		*/
	}

}
