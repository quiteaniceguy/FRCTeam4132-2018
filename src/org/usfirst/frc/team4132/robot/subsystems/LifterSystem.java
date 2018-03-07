package org.usfirst.frc.team4132.robot.subsystems;

import org.usfirst.frc.team4132.robot.RobotMap;
import org.usfirst.frc.team4132.robot.commands.LifterFromJoystick;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LifterSystem extends Subsystem{
	private Talon lifter;
	DigitalInput limitSwitch;
	
	public LifterSystem(){
		lifter = new Talon(RobotMap.armLifter);
		limitSwitch = new DigitalInput(RobotMap.limitSwitch);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new LifterFromJoystick());
	}
	
	public void setSpeed(double speed) {
		if(speed <= 0 && !limitSwitch.get()) {
			lifter.set(0);
		}
		else {
			lifter.set(speed);
		}
	}
	
}