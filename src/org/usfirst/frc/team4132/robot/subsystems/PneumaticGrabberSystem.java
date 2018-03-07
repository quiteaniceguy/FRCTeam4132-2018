package org.usfirst.frc.team4132.robot.subsystems;

import org.usfirst.frc.team4132.robot.commands.SolenoidGrabberFromJoystick;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PneumaticGrabberSystem extends Subsystem{
	public DoubleSolenoid lifterSolenoid;

	
	public PneumaticGrabberSystem(int portOne, int portTwo) {
		lifterSolenoid  = new DoubleSolenoid(portOne, portTwo);
		
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
		setDefaultCommand(new SolenoidGrabberFromJoystick());
		
	}

}
