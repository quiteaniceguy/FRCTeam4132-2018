package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.
robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4132.robot.RobotPosData;

public class AutoDriveToPoint extends Command{
	double angleToDest, robotAngle, xPos, yPos, xDest, yDest, disatanceToDest; //angleToDest is the angleToDest to the point, and robotAngle is the robot's current angleToDest
	double angleErrorMargin = .25;
	double lastTime;
	double driveSpeed = .8;
	double rotateSpeed = .4;
	boolean done = false;
	
	AutoDriveToPoint(double xDest, double yDest) {
		this.xPos = RobotPosData.xPos;
		this.yPos = RobotPosData.yPos;
		
		this.xDest = xDest;
		this.yDest = yDest;
		


		robotAngle = Robot.testAngle*Math.PI/180;
		//System.out.println(robotAngle + " " + angleToDest);
		robotAngle = robotAngle % (2*Math.PI);


		lastTime = System.currentTimeMillis();
		
		disatanceToDest = Math.sqrt(Math.pow((xDest - xPos), 2)+Math.pow((yDest-yPos), 2));
		if (xDest >= xPos) {
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
		Robot.testAngle = robotAngle*180/Math.PI;
		done = true;
	}
	
	public void turn() {
		while ((robotAngle < angleToDest - angleErrorMargin && robotAngle + 2*Math.PI > angleToDest + angleErrorMargin) || (robotAngle > angleToDest + angleErrorMargin && robotAngle < angleToDest - angleErrorMargin + 2*Math.PI)) {
			if ((Math.abs(angleToDest - robotAngle) > Math.PI && robotAngle < angleToDest) || (robotAngle > angleToDest && (Math.abs(angleToDest - robotAngle) < Math.PI))) {
				Robot.driveSystem.controlAllDriveWheels(rotateSpeed, rotateSpeed, -rotateSpeed, -rotateSpeed); //May not rotate the correct way, does not give the correct acceleration value
				//System.out.println("clockwise");
				System.out.println(robotAngle + " " + angleToDest);
			}
			else {
				Robot.driveSystem.controlAllDriveWheels(-rotateSpeed, -rotateSpeed, rotateSpeed, rotateSpeed); //May not rotate the correct way, does not give the correct acceleration value
				System.out.println(robotAngle + " " + angleToDest);
			}
			//robotAngle = Robot.testAngle*Math.PI/180;
			robotAngle += ((-Robot.ahrs.getRawGyroX()-Robot.offset) * ((System.currentTimeMillis() - lastTime)/1000))*Math.PI/180;
			lastTime = System.currentTimeMillis();
			robotAngle = robotAngle % (2*Math.PI);
		}
		Robot.driveSystem.zeroWheels();
		System.out.println("done");
	}
	
	public void linearMovement() {
		/*Robot.encoderSystem.distanceReset();
		while (Robot.encoderSystem.getDistance() < disatanceToDest) {
			Robot.driveSystem.controlAllDriveWheels(driveSpeed, driveSpeed, driveSpeed, driveSpeed);
		}
		Robot.driveSystem.zeroWheels();*/
	}
	
	
}