package org.usfirst.frc.team4132.robot.subsystems;

import org.usfirst.frc.team4132.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class EncoderSystem extends Subsystem{
	public Encoder encoder;
	
	public EncoderSystem() {
		encoder = new Encoder(RobotMap.leftEncoderOne, RobotMap.leftEncoderTwo);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
