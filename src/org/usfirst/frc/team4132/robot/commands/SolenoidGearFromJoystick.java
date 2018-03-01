package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;
import org.usfirst.frc.team4132.robot.XboxControllerMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class SolenoidGearFromJoystick extends Command{
	
	PneumaticController pneController;
	
	public SolenoidGearFromJoystick() {
		requires(Robot.pneumaticGearSystem);
		pneController = new PneumaticController(XboxControllerMap.X, Robot.pneumaticGearSystem.gearSolenoid);
		
		
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void execute() {
		
		//pneController.run();
		
		boolean rb = Robot.m_oi.stickOne.getRawButton(XboxControllerMap.RB);
		boolean lb = Robot.m_oi.stickOne.getRawButton(XboxControllerMap.LB);
		
		/* idk which is high gear and low gear */
		if(rb) {
			Robot.pneumaticGearSystem.gearSolenoid.set(DoubleSolenoid.Value.kForward);
		}else if(lb) {
			Robot.pneumaticGearSystem.gearSolenoid.set(DoubleSolenoid.Value.kReverse);
		}
	}
}
