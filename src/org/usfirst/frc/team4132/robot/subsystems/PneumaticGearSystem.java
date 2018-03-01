package org.usfirst.frc.team4132.robot.subsystems;

import org.usfirst.frc.team4132.robot.commands.SolenoidGearFromJoystick;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PneumaticGearSystem extends Subsystem{
	public DoubleSolenoid gearSolenoid;

	
	public PneumaticGearSystem(int portOne, int portTwo) {
		gearSolenoid  = new DoubleSolenoid(portOne, portTwo);
		
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
		setDefaultCommand(new SolenoidGearFromJoystick());
		
	}
	
	
	

}
