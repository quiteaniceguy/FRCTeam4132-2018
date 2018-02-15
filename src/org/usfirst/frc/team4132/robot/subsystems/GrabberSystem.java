package org.usfirst.frc.team4132.robot.subsystems;

import org.usfirst.frc.team4132.robot.RobotMap;
import org.usfirst.frc.team4132.robot.commands.DriveFromJoystick;
import org.usfirst.frc.team4132.robot.commands.UseGrabber;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class GrabberSystem extends Subsystem{
	
	public Talon leftGrabber;
	public Talon rightGrabber;
	SpeedControllerGroup grabber;
	
	public GrabberSystem(){
		
		leftGrabber = new Talon(RobotMap.leftGrabber);
		rightGrabber = new Talon(RobotMap.rightGrabber);
		grabber = new SpeedControllerGroup(leftGrabber, rightGrabber);
		
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new UseGrabber());
		
	}
	
	public void setSpeed(double speed) {
		grabber.set(speed);
	}
}
