package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4132.robot.RobotPosData;

public class AutoDriveToPoint extends Command{
	double angleToDest, robotAngle, xPos, yPos, xDest, yDest, disatanceToDest; //angleToDest is the angleToDest to the point, and robotAngle is the robot's current angleToDest
	double angleErrorMargin = 0.25;
	double driveSpeed = .8;
	double rotateSpeed = 1;
	boolean done = false;
	
	AutoDriveToPoint(double xDest, double yDest) {
		this.xPos = RobotPosData.xPos;
		this.yPos = RobotPosData.yPos;
		
		this.xDest = xDest;
		this.yDest = yDest;
		
		robotAngle = Robot.piComSystem.getGyroData();
		
		disatanceToDest = Math.sqrt(Math.pow((xDest - xPos), 2)+Math.pow((yDest-yPos), 2));
		if (xPos >= xDest) {
			angleToDest = Math.atan((yDest-yPos)/(xDest-xPos));
		}
		else {
			angleToDest = Math.atan((yDest-yPos)/(xDest-xPos)) + Math.PI;
		}
		if (angleToDest < 0) {
			angleToDest = 2 * Math.PI + angleToDest;
		}
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return done;
	}
	
	public void execute() {
		/*
		while (robotAngle < angleToDest - angleErrorMargin || robotAngle > angleToDest + angleErrorMargin) {
			if (angleToDest - robotAngle > Math.PI) {
				Robot.driveSystem.controlAllDriveWheels(rotateSpeed, -rotateSpeed, rotateSpeed, -rotateSpeed); //May not rotate the correct way, does not give the correct acceleration value
			}
			else {
				Robot.driveSystem.controlAllDriveWheels(-rotateSpeed, rotateSpeed, -rotateSpeed, rotateSpeed); //May not rotate the correct way, does not give the correct acceleration value
			}
			robotAngle = Robot.piComSystem.getGyroData();
		}
		Robot.encoderSystem.distanceReset();
		while (Robot.encoderSystem.getDistance() < disatanceToDest) {
			Robot.driveSystem.controlAllDriveWheels(driveSpeed, driveSpeed, driveSpeed, driveSpeed);
		}
		*/
		turn();
		Timer.delay(0.1);
		linearMovement();
		Timer.delay(0.1);
		
		RobotPosData.xPos = xDest;
		RobotPosData.yPos = yDest;
		done = true;
	}
	
	public void turn() {
		while (robotAngle < angleToDest - angleErrorMargin || robotAngle > angleToDest + angleErrorMargin) {
			if (angleToDest - robotAngle > Math.PI) {
				Robot.driveSystem.controlAllDriveWheels(rotateSpeed, -rotateSpeed, rotateSpeed, -rotateSpeed); //May not rotate the correct way, does not give the correct acceleration value
			}
			else {
				Robot.driveSystem.controlAllDriveWheels(-rotateSpeed, rotateSpeed, -rotateSpeed, rotateSpeed); //May not rotate the correct way, does not give the correct acceleration value
			}
			robotAngle = Robot.piComSystem.getGyroData();
		}
	}
	
	public void linearMovement() {
		Robot.encoderSystem.distanceReset();
		while (Robot.encoderSystem.getDistance() < disatanceToDest) {
			Robot.driveSystem.controlAllDriveWheels(driveSpeed, driveSpeed, driveSpeed, driveSpeed);
		}
		Robot.driveSystem.zeroWheels();
	}
	
	
}