package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoWithGyro extends Command{
	public AutoWithGyro() {
		super("AutoWithGyro");
		
		requires(Robot.driveSystem);
		requires(Robot.piComSystem);
		
		
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	/*
	 * 
	 * turns robot with speed 'speed'(positive is clockwise) for degrees 'degrees'
	 */
	public void turn(double speed, double degrees) {
		
		double rotateDir = degrees/Math.abs(degrees);
		int reverse = -1;
		double currentDegree = 0;
		
		/* reverse right wheels when going in positive direction WHILE less than degrees to turn(must still write this part)*/
		while( Math.abs(currentDegree) < Math.abs(degrees) ) {
			Robot.driveSystem.controlAllDriveWheels(speed * rotateDir, speed * rotateDir * reverse, speed * rotateDir, speed * rotateDir * reverse);
		}
	}
	
	public void linearMovement(double speed, double distance) {
		
		double roboDistance;
		/* move all wheels at this speed for this amount of direction  */
		while( Math.abs((roboDistance = Robot.piComSystem.getPosData()[0])) < Math.abs(distance) ) {
			Robot.driveSystem.controlAllDriveWheels(speed, speed, speed, speed);
		}
		
	}

}
