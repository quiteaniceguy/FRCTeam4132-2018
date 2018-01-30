package org.usfirst.frc.team4132.robot.subsystems;

import org.usfirst.frc.team4132.robot.RobotMap;
import org.usfirst.frc.team4132.robot.commands.DriveFromJoystick;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveSystem extends Subsystem{
	private Talon frontLeftTalon;
	private Talon frontRightTalon;
	private Talon backLeftTalon;
	private Talon backRightTalon;
	
	private DifferentialDrive robotDrive;
	private DifferentialDrive robotDriveTwo;
	
	
	/*may need to change dependencies to make this work */
	AHRS ahrs;
	

	
	public DriveSystem(){
		frontLeftTalon = new Talon(RobotMap.frontLeftMotor);
		frontLeftTalon.setInverted(false);
		
		frontRightTalon = new Talon(RobotMap.frontRightMotor);
		frontRightTalon.setInverted(false);

		backLeftTalon = new Talon(RobotMap.backLeftMotor);
		backRightTalon = new Talon(RobotMap.backRightMotor);
		
		SpeedControllerGroup left = new SpeedControllerGroup(frontLeftTalon, backLeftTalon);
		SpeedControllerGroup right = new SpeedControllerGroup(frontRightTalon, backRightTalon);
		
		robotDrive = new DifferentialDrive(left, right);
		
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new DriveFromJoystick()); 
	}
	
	public void drive(double yDriveSpeed, double xDriveSpeed, double driveRotation){
		//why multiply? idk
		robotDrive.arcadeDrive(-xDriveSpeed , yDriveSpeed);
		System.out.println("yDriveSpeed: " + yDriveSpeed);
		System.out.println("xDriveSpeed: " + xDriveSpeed);
		System.out.println("driveRotation: " + driveRotation);
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
	
	
	
	
}
