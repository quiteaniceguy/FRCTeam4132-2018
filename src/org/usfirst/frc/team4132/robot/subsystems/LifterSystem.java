package org.usfirst.frc.team4132.robot.subsystems;

import org.usfirst.frc.team4132.robot.RobotMap;
import org.usfirst.frc.team4132.robot.commands.LifterFromJoystick;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LifterSystem extends Subsystem{
	private Talon lifter;
	
	public LifterSystem(){
		lifter = new Talon(RobotMap.armLifter);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new LifterFromJoystick());
	}
	
	public void setSpeed(double speed) {
		lifter.set(speed);
	}
	
}
