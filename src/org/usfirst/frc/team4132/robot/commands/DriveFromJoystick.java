package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;
import org.usfirst.frc.team4132.robot.XboxControllerMap;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveFromJoystick extends Command{
	private final double DRIVE_SPEED = .8d;
	private int invert = -1;
	private double currSpeed = 0;
	private double desiredSpeed = 0;
	private double maxChange = 0.05;
	double preTime;
	
	DifferentialDrive robotDrive;
	
	private double yMovement = 0;
	private double xMovement = 0;
	private double movementRotation = 0;
	private double deltaSpeed = 0;
	
	public DriveFromJoystick(){
		super("DriveFromJoystick");
		requires(Robot.driveSystem);
		preTime = System.currentTimeMillis();
	
		robotDrive = new DifferentialDrive(Robot.driveSystem.leftSpeedGrp(), Robot.driveSystem.rightSpeedGrp());
		robotDrive.setSafetyEnabled(false);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void execute(){
		desiredSpeed = Robot.m_oi.stickOne.getRawAxis(XboxControllerMap.LEFT_JOY_Y);


		/*if(Math.abs(desiredSpeed - currSpeed) > maxChange){
			deltaSpeed = maxChange * (Math.abs(desiredSpeed-currSpeed) / desiredSpeed-currSpeed);
			currSpeed += deltaSpeed;
		}
		else {
			currSpeed = desiredSpeed;
		}*/
		
		System.out.println(System.currentTimeMillis()-preTime);
		preTime = System.currentTimeMillis();
		yMovement = desiredSpeed * DRIVE_SPEED * invert;
		xMovement = Robot.m_oi.stickOne.getRawAxis(XboxControllerMap.LEFT_JOY_X) * DRIVE_SPEED;
		//movementRotation = Robot.m_oi.stickOne.getRawAxis(2);
		
		robotDrive.arcadeDrive(xMovement, yMovement);
		
		
		//currSpeed = desiredSpeed;
		//System.out.println("Current Speed: " + currSpeed + " Desired Speed:" + desiredSpeed + " deltaSpeed: " + deltaSpeed);
		//System.out.println("getting the angle: " + Robot.ahrs.getAngle());
		
	}

}
