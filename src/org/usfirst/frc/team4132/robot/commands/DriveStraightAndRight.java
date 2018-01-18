package org.usfirst.frc.team4132.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveStraightAndRight extends CommandGroup{
	public DriveStraightAndRight() {
		//drive straight
		addSequential(new AutoDriveRobot(.5, .5, .5, .5, 3));
		//turn
		addSequential(new AutoDriveRobot(.5, .5, -.5, -.5, 2));
		//dirve straight
		addSequential(new AutoDriveRobot(.5, .5, .5, .5, 3));
	}
}
