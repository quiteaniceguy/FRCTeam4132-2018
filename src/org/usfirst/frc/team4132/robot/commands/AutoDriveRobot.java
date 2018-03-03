package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveRobot extends Command{
	//private double backLeftSpeed, backRightSpeed, frontRightSpeed, frontLeftSpeed;
	public AutoDriveRobot(double backLeftSpeed, double backRightSpeed, double frontRightSpeed, double frontLeftSpeed, double time) {
		
		super("AutoDriveRobot");
		
		requires(Robot.driveSystem);
		/*
		setTimeout(time);
		
		this.backLeftSpeed = backLeftSpeed;
		this.backRightSpeed = backRightSpeed;
		this.frontLeftSpeed = frontLeftSpeed;
		this.frontRightSpeed = frontRightSpeed;
		*/
	}
	
	public void execute() {
		//Robot.driveSystem.controlAllDriveWheels(-backLeftSpeed, backRightSpeed, -frontLeftSpeed, frontRightSpeed);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		//return isTimedOut();
		return false;
	}
	
	@Override
	protected void end() {
		//Robot.driveSystem.controlAllDriveWheels(0, 0, 0, 0);
	}
	
	@Override
	protected void interrupted() {
		end();
	}

}
