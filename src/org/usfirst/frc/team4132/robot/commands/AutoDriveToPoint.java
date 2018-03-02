package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDriveToPoint extends CommandGroup{
	double angle, rAngle, xPos, yPos, xDest, yDest, distance; //angle is the angle to the point, and rAngle is the robot's current angle
	double angleErrorMargin = 0.25;
	double speed = .8;
	AutoDriveToPoint(double xPos, double yPos, double xDest, double yDest) {
		this.xPos = xPos;
		this.yPos = yPos;
		distance = Math.sqrt(Math.pow((xDest - xPos), 2)+Math.pow((yDest-yPos), 2));
		if (xPos >= xDest) {
			angle = Math.atan((yDest-yPos)/(xDest-xPos));
		}
		else {
			angle = Math.atan((yDest-yPos)/(xDest-xPos)) + Math.PI;
		}
		if (angle < 0) {
			angle = 2 * Math.PI + angle;
		}
		while (rAngle < angle - angleErrorMargin || rAngle > angle + angleErrorMargin) {
			if (angle - rAngle > Math.PI) {
				Robot.driveSystem.controlAllDriveWheels(speed, -speed, speed, -speed); //May not rotate the correct way, does not give the correct acceleration value
			}
			else {
				Robot.driveSystem.controlAllDriveWheels(-speed, speed, -speed, speed); //May not rotate the correct way, does not give the correct acceleration value
			}
			rAngle = Robot.piComSystem.getGyroData();
		}
	}
}