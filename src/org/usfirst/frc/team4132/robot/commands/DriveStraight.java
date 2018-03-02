package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveStraight extends CommandGroup{
	//drive straight
	public DriveStraight() {
		super("DriveStraight");
		addSequential(new AutoDriveRobot(.8, .8, .8, .8, 3));
	}
}
