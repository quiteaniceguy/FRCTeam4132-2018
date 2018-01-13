package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;
import org.usfirst.frc.team4132.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;

public class SpinGumball extends Command{
	public SpinGumball() {
		super("SpinGumball");
		requires(Robot.gumballSystem);
		
		setTimeout(2);
	}
	
	@Override
	protected void initialize() {
		Robot.gumballSystem.setWheelSpeed(.5);
	}
	
	protected void execute() {
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}
	
	@Override protected void end() {
		Robot.gumballSystem.setWheelSpeed(0);
	}
	
	protected void interrupted() {
		end();
	}
	
	
	
}
