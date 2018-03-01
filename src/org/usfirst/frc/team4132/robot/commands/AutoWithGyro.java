package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoWithGyro extends Command{
	public final double LOW_TURN_COMP = .8d;
	public final double HIGH_TURN_COMP = 1.2d;
	public AutoWithGyro() {
		super("AutoWithGyro");
		
		requires(Robot.driveSystem);
		//requires(Robot.piComSystem);
		
		
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
		double deltaDegree = 0;
		
		/* reverse right wheels when going in positive direction WHILE less than degrees to turn(must still write this part)*/
		while( Math.abs(deltaDegree) < Math.abs(degrees) ) {
			Robot.driveSystem.controlAllDriveWheels(speed * rotateDir, speed * rotateDir * reverse, speed * rotateDir, speed * rotateDir * reverse);
		}
	}
	
	/* magnitude must be positive */
	public void linearMovement(double speed, double magnitude, double directionToFace) {
		
		double roboDistance;
		/* move all wheels at this speed for this amount of direction  */
		while( Math.abs(roboDistance = Robot.encoderSystem.encoder.getDistance()) < Math.abs(magnitude) ) {
			double leftSpeed, rightSpeed;
			leftSpeed = rightSpeed = speed;
			
			Robot.driveSystem.controlAllDriveWheels(speed, speed, speed, speed);
			if (Robot.piComSystem.getGyroData() < directionToFace) {
				
				leftSpeed = speed * HIGH_TURN_COMP;
				rightSpeed = speed * LOW_TURN_COMP;
				
			}else if(Robot.piComSystem.getGyroData() > directionToFace) {
				
				rightSpeed = speed * HIGH_TURN_COMP;
				leftSpeed = speed * LOW_TURN_COMP;
				
			}
			Robot.driveSystem.controlAllDriveWheels(leftSpeed, rightSpeed, leftSpeed, rightSpeed);
		}
		
	}

}
