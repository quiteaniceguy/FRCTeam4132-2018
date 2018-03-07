package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;
import org.usfirst.frc.team4132.robot.XboxControllerMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveFromJoystick extends Command{
	private final double DRIVE_SPEED = 1d;
	private int invert = -1;
	private double currSpeed = 0;
	private double desiredSpeed = 0;
	private double maxChange = 0.06125;
	
	DifferentialDrive robotDrive;
	
	private double yMovement = 0;
	private double xMovement = 0;
	private double deltaSpeed = 0;
	
	public DriveFromJoystick(){
		super("DriveFromJoystick");
		requires(Robot.driveSystem);
	
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
		deltaSpeed = 0;

		if(Math.abs(desiredSpeed - currSpeed) > maxChange){
			deltaSpeed = maxChange * (Math.abs(desiredSpeed-currSpeed) / (desiredSpeed-currSpeed));
			currSpeed += deltaSpeed;
		}
		else {
			currSpeed = desiredSpeed;
		}
		
	
		yMovement = currSpeed * DRIVE_SPEED * invert;
		xMovement = Robot.m_oi.stickOne.getRawAxis(XboxControllerMap.LEFT_JOY_X) * DRIVE_SPEED;
		
		robotDrive.arcadeDrive(xMovement, yMovement);
		
		
	}

}