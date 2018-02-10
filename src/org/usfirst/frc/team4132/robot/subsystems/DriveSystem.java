package org.usfirst.frc.team4132.robot.subsystems;

import org.usfirst.frc.team4132.robot.Robot;
import org.usfirst.frc.team4132.robot.RobotMap;
import org.usfirst.frc.team4132.robot.commands.DriveFromJoystick;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveSystem extends Subsystem{
	final double ARCADE_DRIVE_SPEED = 1;
	private Talon frontLeftTalon;
	private Talon frontRightTalon;
	private Talon backLeftTalon;
	private Talon backRightTalon;
	
	public Encoder rightEncoder;
	public Encoder leftEncoder;
	
	private DifferentialDrive robotDrive;
	private DifferentialDrive robotDriveTwo;
	
	
	/*may need to change dependencies to make this work */
	

	
	public DriveSystem(){
		/*  motors  */
		frontLeftTalon = new Talon(RobotMap.frontLeftMotor);
		frontLeftTalon.setInverted(true);
		
		
		frontRightTalon = new Talon(RobotMap.frontRightMotor);
		frontRightTalon.setInverted(false);

		backLeftTalon = new Talon(RobotMap.backLeftMotor);
		backLeftTalon.setInverted(true);
		
		backRightTalon = new Talon(RobotMap.backRightMotor);
		
		
		SpeedControllerGroup left = new SpeedControllerGroup(frontLeftTalon, backLeftTalon);
		SpeedControllerGroup right = new SpeedControllerGroup(frontRightTalon, backRightTalon);
		
		robotDrive = new DifferentialDrive(left, right);
		
		/*  sensors */
		
		rightEncoder = new Encoder(RobotMap.rightEncoderOne, RobotMap.rightEncoderTwo);
		leftEncoder = new Encoder(RobotMap.leftEncoderOne, RobotMap.leftEncoderTwo);
		
	
		
		
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new DriveFromJoystick()); 
	}
	
	public void drive(double yDriveSpeed, double xDriveSpeed, double driveRotation){
		//why multiply? idk
		
		robotDrive.arcadeDrive(yDriveSpeed * ARCADE_DRIVE_SPEED, xDriveSpeed * ARCADE_DRIVE_SPEED);
		/*
		System.out.println("yDriveSpeed: " + yDriveSpeed);
		System.out.println("xDriveSpeed: " + xDriveSpeed);
		System.out.println("driveRotation: " + driveRotation);
		*/
		
		////lighting up 3
		
		/*     this is horrible stuff
		if(Robot.m_oi.stickOne.getRawButton(4)) {
			
			frontRightTalon.set(1);
			System.out.println("button 4");
		}else {
			frontRightTalon.set(0);
		}
		
		if(Robot.m_oi.stickOne.getRawButton(1)) {
			
			backRightTalon.set(1);
			System.out.println("button 1");
		}else {
			backRightTalon.set(0);
		}
		
		if(Robot.m_oi.stickOne.getRawButton(2)) {
		
			frontLeftTalon.set(1);
			System.out.println("button 2");
		}else {
			frontLeftTalon.set(0);
		}
		
		if(Robot.m_oi.stickOne.getRawButton(3)) {
			backLeftTalon.set(1);
			System.out.println("button 3");
		}else {
			backLeftTalon.set(0);
		}
		*/
		
	}
	
	public void setBackLeftWheel(double speed) {
		backLeftTalon.set(speed);
	}
	
	public void setFrontLeftWheel(double speed) {
		frontLeftTalon.set(speed);
	}
	
	public void setBackRightWheel(double speed) {
		backRightTalon.set(speed);
	}
	
	public void setFrontRightWheel(double speed) {
		frontRightTalon.set(speed);
	}
	
	public void controlAllDriveWheels(double backLeftSpeed, double backRightSpeed, double frontLeftSpeed, double frontRightSpeed) {
		setBackLeftWheel(backLeftSpeed);
		setFrontLeftWheel(frontLeftSpeed);
		setBackRightWheel(backRightSpeed);
		setFrontRightWheel(frontRightSpeed);
	}
	
	public void zeroEncoders() {
		rightEncoder.reset();
		leftEncoder.reset();
	}
	
	
	
	
}
