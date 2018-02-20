package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;
import org.usfirst.frc.team4132.robot.XboxControllerMap;

import edu.wpi.first.wpilibj.command.Command;

public class SolenoidGearFromJoystick extends Command{
	
	PneumaticController pneController;
	
	public SolenoidGearFromJoystick() {
		requires(Robot.pneumaticGearSystem);
		pneController = new PneumaticController(XboxControllerMap.X, Robot.pneumaticGearSystem);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void execute() {
		
		pneController.run();
	}
}
