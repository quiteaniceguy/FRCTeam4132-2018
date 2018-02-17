package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoWithGyro extends Command{
	public AutoWithGyro() {
		super("AutoWithGyro");
		
		requires(Robot.driveSystem);
		requires(Robot.piComSystem);
		
		
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
