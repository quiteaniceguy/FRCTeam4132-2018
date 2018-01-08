package org.usfirst.frc.team4132.robot.subsystems;

import org.usfirst.frc.team4132.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GumballSystem extends Subsystem{
	Talon gumball;
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		gumball = new Talon(RobotMap.gumballWheel);
	}
	
	public void setWheelSpeed(double speed){
		gumball.set(speed);
	}

}
