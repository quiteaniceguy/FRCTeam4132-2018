package org.usfirst.frc.team4132.robot.subsystems;

import org.usfirst.frc.team4132.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PneumaticSystem extends Subsystem{
	
	DoubleSolenoid lifterSolenoid;
	
	public PneumaticSystem() {
		lifterSolenoid  = new DoubleSolenoid(RobotMap.lifterSolenoidOne, RobotMap.lifterSolenoidTwo);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
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
