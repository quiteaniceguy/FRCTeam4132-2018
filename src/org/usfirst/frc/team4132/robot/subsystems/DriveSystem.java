package org.usfirst.frc.team4132.robot.subsystems;

import org.usfirst.frc.team4132.robot.RobotMap;
import org.usfirst.frc.team4132.robot.commands.DriveFromJoystick;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class DriveSystem extends Subsystem{
	private Talon frontLeftTalon;
	private Talon frontRightTalon;
	private Talon backLeftTalon;
	private Talon backRightTalon;
	
	private MecanumDrive robotDrive;
	

	
	public DriveSystem(){
		frontLeftTalon = new Talon(RobotMap.frontLeftMotor);
		frontRightTalon = new Talon(RobotMap.frontRightMotor);
		backLeftTalon = new Talon(RobotMap.backLeftMotor);
		backRightTalon = new Talon(RobotMap.backRightMotor);
	
		robotDrive = new MecanumDrive(frontLeftTalon, frontRightTalon, backLeftTalon, backRightTalon);
		
		
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new DriveFromJoystick()); 
	}
	
	public void drive(double yDriveSpeed, double xDriveSpeed, double driveRotation){
		robotDrive.driveCartesian(yDriveSpeed, xDriveSpeed, driveRotation);
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
	
	public void driveStraight()
	
	
}
