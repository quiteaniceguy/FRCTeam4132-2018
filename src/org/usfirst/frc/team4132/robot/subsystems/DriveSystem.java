package org.usfirst.frc.team4132.robot.subsystems;

import org.usfirst.frc.team4132.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem{
	
	final double ARCADE_DRIVE_SPEED = 1;
	
	public Talon frontLeftTalon;
	public Talon frontRightTalon;
	public Talon backLeftTalon;
	public Talon backRightTalon;
			
	public SpeedControllerGroup right;
	public SpeedControllerGroup left;
	
	/*may need to change dependencies to make this work */
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		//setDefaultCommand(new DriveFromJoystick()); 
	}
	
	public DriveSystem(){
		/*  motors  */
		frontLeftTalon = new Talon(RobotMap.frontLeftMotor);
		
		
		frontRightTalon = new Talon(RobotMap.frontRightMotor);
		frontRightTalon.setInverted(true);

		backLeftTalon = new Talon(RobotMap.backLeftMotor);
		backLeftTalon.setInverted(true);
		
		backRightTalon = new Talon(RobotMap.backRightMotor);
		
		left = new SpeedControllerGroup(frontLeftTalon, backLeftTalon);
		right = new SpeedControllerGroup(frontRightTalon, backRightTalon);
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
	
	public void controlAllDriveWheels(double backLeftSpeed, double frontLeftSpeed, double backRightSpeed, double frontRightSpeed) {
		
		setBackLeftWheel(backLeftSpeed);
		setFrontLeftWheel(frontLeftSpeed);
		setBackRightWheel(backRightSpeed);
		setFrontRightWheel(frontRightSpeed);
	}
	
	public void zeroWheels() {
		
		setBackLeftWheel(0);
		setFrontLeftWheel(0);
		setBackRightWheel(0);
		setFrontRightWheel(0);
	}
	
	public SpeedControllerGroup rightSpeedGrp(){
		return right;
	}
	
	public SpeedControllerGroup leftSpeedGrp(){
		return left;
	}
}