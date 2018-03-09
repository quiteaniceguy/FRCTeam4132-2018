package org.usfirst.frc.team4132.robot.subsystems;

import org.usfirst.frc.team4132.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class EncoderSystem extends Subsystem{
	
	public final double DISTANCE_RATE = 6*Math.PI/1440;
	
	public Encoder encoder;
	
	public EncoderSystem() {
		encoder = new Encoder(RobotMap.leftEncoderOne, RobotMap.leftEncoderTwo);
		encoder.setDistancePerPulse(DISTANCE_RATE);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	/* use this to convert count into a real distance */
	public double getDistance() {
		///must make distanc
		return encoder.getDistance();
	}
	
	public void distanceReset() {
		encoder.reset();
	}

}
