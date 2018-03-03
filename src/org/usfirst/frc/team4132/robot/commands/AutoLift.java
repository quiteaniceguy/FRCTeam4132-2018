package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoLift extends Command{
	private double liftSpeed;
	public AutoLift(double liftSpeed, double time) {
		
		super("AutoLift");
		
		requires(Robot.lifterSystem);
		
		setTimeout(time);
		
		this.liftSpeed = liftSpeed;
	}
	
	public void execute() {
		Robot.lifterSystem.setSpeed(liftSpeed);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}
	
	@Override
	protected void end() {
		Robot.lifterSystem.setSpeed(0.1);
	}
	
	@Override
	protected void interrupted() {
		end();
	}

}
