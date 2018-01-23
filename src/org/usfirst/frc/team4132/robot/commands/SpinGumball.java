package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;
import org.usfirst.frc.team4132.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;

public class SpinGumball extends Command{
	public int counter = 0;
	public SpinGumball() {
		super("SpinGumball");
		
		System.out.println("pressed");
		
		try {
			requires(Robot.driveSystem);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	@Override
	protected void initialize() {
		
	
	}
	
	protected void execute() {
		System.out.println("gumball counter: " + counter++);
		Robot.driveSystem.setBackRightWheel(.5);
		System.out.println("wheel set to .5");
		setTimeout(2);

	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
		
	}
	
	@Override protected void end() {
		Robot.driveSystem.setBackRightWheel(0);
		System.out.println("wheel set to 0");

	}
	
	protected void interrupted() {
		end();
	}
	
	
	
}
