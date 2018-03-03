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
		
	private DifferentialDrive robotDrive;
	
	private SpeedControllerGroup right;
	private SpeedControllerGroup left;
	
	
	/*may need to change dependencies to make this work */
	

	
	public DriveSystem(){
		/*  motors  */
		
		frontLeftTalon = new Talon(RobotMap.frontLeftMotor);
		frontLeftTalon.setInverted(true);
		
		
		frontRightTalon = new Talon(RobotMap.frontRightMotor);
		frontRightTalon.setInverted(true);

		backLeftTalon = new Talon(RobotMap.backLeftMotor);
		
		
		backRightTalon = new Talon(RobotMap.backRightMotor);
		
		left = new SpeedControllerGroup(frontLeftTalon, backLeftTalon);
		right = new SpeedControllerGroup(frontRightTalon, backRightTalon);
		
		
		
		
		
		
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new DriveFromJoystick()); 
	}
	
	
	
	public void setBackLeftWheel(double speed) {
		//backLeftTalon.set(speed);
	}
	
	public void setFrontLeftWheel(double speed) {
		//frontLeftTalon.set(speed);
	}
	
	public void setBackRightWheel(double speed) {
		//backRightTalon.set(speed);
	}
	
	public void setFrontRightWheel(double speed) {
		//frontRightTalon.set(speed);
	}
	
	public void controlAllDriveWheels(double backLeftSpeed, double backRightSpeed, double frontLeftSpeed, double frontRightSpeed) {
		
		setBackLeftWheel(backLeftSpeed);
		setFrontLeftWheel(frontLeftSpeed);
		setBackRightWheel(backRightSpeed);
		setFrontRightWheel(frontRightSpeed);
	}
	
	public Talon getFRTalon() {
		return frontRightTalon;
	}
	public Talon getBRTalon() {
		return backRightTalon;
	}
	public Talon getFLTalon() {
		return frontLeftTalon;
	}
	public Talon getBLTalon() {
		return backLeftTalon;
	}
	
	public SpeedControllerGroup rightSpeedGrp(){
		return right;
	}
	
	public SpeedControllerGroup leftSpeedGrp(){
		return left;
	}
	
	
	

	
	
	
	
}
