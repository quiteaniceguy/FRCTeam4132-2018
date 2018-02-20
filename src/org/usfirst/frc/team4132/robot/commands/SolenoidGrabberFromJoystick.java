package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;
import org.usfirst.frc.team4132.robot.XboxControllerMap;

import edu.wpi.first.wpilibj.command.Command;

public class SolenoidGrabberFromJoystick extends Command{
	
	PneumaticController pneController;
	
	public SolenoidGrabberFromJoystick() {
		requires(Robot.pneumaticGrabberSystem);
		pneController = new PneumaticController(XboxControllerMap.Y, Robot.pneumaticGrabberSystem);
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
