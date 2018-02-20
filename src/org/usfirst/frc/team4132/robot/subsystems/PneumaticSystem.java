package org.usfirst.frc.team4132.robot.subsystems;

import org.usfirst.frc.team4132.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PneumaticSystem extends Subsystem{
	
	DoubleSolenoid lifterSolenoid;
	Command defaultCommand;
	
	public PneumaticSystem(int portOne, int portTwo, Command defaultCommand) {
		lifterSolenoid  = new DoubleSolenoid(portOne, portTwo);
		this.defaultCommand = defaultCommand;
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(defaultCommand);
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
