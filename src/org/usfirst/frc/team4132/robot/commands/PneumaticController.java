package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;
import org.usfirst.frc.team4132.robot.XboxControllerMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class PneumaticController {
	
	enum ShooterSolenoidStates{
		IN, OUT, DORMANTIN, DORMANTOUT;
	}
	
	private ShooterSolenoidStates shooterSolenoidState;
	private int button;
	DoubleSolenoid pneumaticSystem;
	
	public PneumaticController(int button, DoubleSolenoid pneumaticSystem) {
		shooterSolenoidState = ShooterSolenoidStates.IN;
		this.pneumaticSystem = pneumaticSystem;
		this.button = button;
		
	}
	
	public void run() {
		boolean XboxButton = Robot.m_oi.stickOne.getRawButton(button);
		switch(shooterSolenoidState) {
			case IN:
				pneumaticSystem.set(DoubleSolenoid.Value.kReverse);
				if(!XboxButton) {
					shooterSolenoidState = ShooterSolenoidStates.DORMANTIN;
				}
				
				break;
				
			case DORMANTIN:
				pneumaticSystem.set(DoubleSolenoid.Value.kReverse);
				if(XboxButton) {
					shooterSolenoidState = ShooterSolenoidStates.OUT;
				}
				
				break;
				
			case OUT:
				pneumaticSystem.set(DoubleSolenoid.Value.kForward);
				if(!XboxButton) {
					shooterSolenoidState = ShooterSolenoidStates.DORMANTOUT;
				}
				
				break;
				
			case DORMANTOUT:
				pneumaticSystem.set(DoubleSolenoid.Value.kForward);
				if(XboxButton) {
					shooterSolenoidState = ShooterSolenoidStates.IN;
				}
				
				break;
		}
		//System.out.println(shooterSolenoidState);
	}
}
