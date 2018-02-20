package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;
import org.usfirst.frc.team4132.robot.XboxControllerMap;
import org.usfirst.frc.team4132.robot.subsystems.PneumaticSystem;

public class PneumaticController {
	
	enum ShooterSolenoidStates{
		IN, OUT, DORMANTIN, DORMANTOUT;
	}
	
	private ShooterSolenoidStates shooterSolenoidState;
	private int button;
	PneumaticSystem pneumaticSystem;
	
	public PneumaticController(int button, PneumaticSystem pneumaticSystem) {
		shooterSolenoidState = ShooterSolenoidStates.IN;
		this.pneumaticSystem = pneumaticSystem;
		this.button = button;
		
	}
	
	public void run() {
		boolean XboxButton = Robot.m_oi.stickOne.getRawButton(button);
		switch(shooterSolenoidState) {
			case IN:
				pneumaticSystem.solenoidIn();
				if(!XboxButton) {
					shooterSolenoidState = ShooterSolenoidStates.DORMANTIN;
				}
				
				break;
				
			case DORMANTIN:
				pneumaticSystem.solenoidIn();
				if(XboxButton) {
					shooterSolenoidState = ShooterSolenoidStates.OUT;
				}
				
				break;
				
			case OUT:
				pneumaticSystem.solenoidOut();
				if(!XboxButton) {
					shooterSolenoidState = ShooterSolenoidStates.DORMANTOUT;
				}
				
				break;
				
			case DORMANTOUT:
				pneumaticSystem.solenoidOut();
				if(XboxButton) {
					shooterSolenoidState = ShooterSolenoidStates.IN;
				}
				
				break;
		}
		System.out.println(shooterSolenoidState);
	}
}
