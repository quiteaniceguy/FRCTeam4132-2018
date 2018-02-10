package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveWithEncoders extends Command{
	private double goalLeftEncoderDistance = 0;
	private double goalRightEncoderDistance = 0;
	
	private double leftMotorSpeed = 0;
	private double rightMotorSpeed = 0;
	
	private double motorSpeedChange = .05d;
	
	private double goalMoveTimeLength = 0;
	
	private double startTime;
	
	private double oldTime;
	private double newTime;
	
	private double oldLeftEncoderCount = 0;
	private double oldRightEncoderCount = 0;
	
	private double newLeftEncoderCount = 0;
	private double newRightEncoderCount = 0;
	
	private double deltaTime = 0;
	private double goalTimeLeft = 0;
	
	public AutoDriveWithEncoders(double goalLeftEncoderDistance, double goalRightEncoderDistance, double leftMotorSpeed, double rightMotorSpeed, double goalMoveTimeLength){
		super("AutoDriveWithEncoders");
		requires(Robot.driveSystem);
		
		Robot.driveSystem.zeroEncoders();
		
		startTime = System.currentTimeMillis();
		
		this.goalLeftEncoderDistance = goalLeftEncoderDistance;
		this.goalRightEncoderDistance = goalRightEncoderDistance;
		
		this.leftMotorSpeed = leftMotorSpeed;
		this.rightMotorSpeed = rightMotorSpeed;
		
		this.goalMoveTimeLength = goalMoveTimeLength;
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return !(newLeftEncoderCount < goalLeftEncoderDistance || newRightEncoderCount < goalRightEncoderDistance);
	}
	
	public void execute() {
		newTime = System.currentTimeMillis();
		
		newLeftEncoderCount = Robot.driveSystem.leftEncoder.getRaw();
		newRightEncoderCount = Robot.driveSystem.rightEncoder.getRaw();
		
		deltaTime = newTime - oldTime;
		
		goalTimeLeft = startTime + goalMoveTimeLength - newTime;
		
		double leftSpeedToGo = (goalLeftEncoderDistance - Robot.driveSystem.leftEncoder.getRaw()) / goalTimeLeft;
		double rightSpeedToGo = (goalRightEncoderDistance - Robot.driveSystem.rightEncoder.getRaw()) / goalTimeLeft;
		
		double rightCurrentSpeed = (newRightEncoderCount - oldRightEncoderCount) / deltaTime;
		double leftCurrentSpeed = (newLeftEncoderCount - oldLeftEncoderCount) / deltaTime;
		
		
			
		/* if the current speed isn't the same as the speed needed to go  */
		if(rightCurrentSpeed != rightSpeedToGo) {
			rightMotorSpeed += motorSpeedChange * ((rightSpeedToGo - rightCurrentSpeed) / Math.abs(rightSpeedToGo - rightCurrentSpeed));
		}
		
		if(leftCurrentSpeed != leftSpeedToGo) {
			leftMotorSpeed += motorSpeedChange * ((leftSpeedToGo - leftCurrentSpeed) / Math.abs(leftSpeedToGo - leftCurrentSpeed));
		}
		
		Robot.driveSystem.controlAllDriveWheels(leftMotorSpeed, rightMotorSpeed, leftMotorSpeed, rightMotorSpeed);
		
		
		
		
		oldTime = newTime;
		oldLeftEncoderCount = newLeftEncoderCount;
		oldRightEncoderCount = newRightEncoderCount;
	}
	
	@Override 
	protected void end() {
		Robot.driveSystem.controlAllDriveWheels(0, 0, 0 ,0);

	}
	
	protected void interrupted() {
		end();
	}
	

}
