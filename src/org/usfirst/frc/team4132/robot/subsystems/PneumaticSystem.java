package org.usfirst.frc.team4132.robot.subsystems;

import org.usfirst.frc.team4132.robot.RobotMap;
import org.usfirst.frc.team4132.robot.commands.SolenoidGearFromJoystick;
import org.usfirst.frc.team4132.robot.commands.SolenoidGrabberFromJoystick;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PneumaticSystem extends Subsystem{
	
	DoubleSolenoid lifterSolenoid;
	String defaultCommand;
	
	public PneumaticSystem(int portOne, int portTwo, String defaultCommand) {
		lifterSolenoid  = new DoubleSolenoid(portOne, portTwo);
		this.defaultCommand = defaultCommand;
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		switch(defaultCommand) {
		case "grabber":
			setDefaultCommand(new SolenoidGrabberFromJoystick());
			break;
			
		case "gearShift":
			setDefaultCommand(new SolenoidGearFromJoystick());
			break;
		default:
			/* maybe not have this or have better thing */
			System.out.println("ERROR: Set default command for 'PneumaticSystem' not found");
			break;
		}
	}
	
	public void solenoidIn() {
		lifterSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void solenoidOut() {
		lifterSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void solenoidOff() {
		lifterSolenoid.set(DoubleSolenoid.Value.kOff);
	}
}
