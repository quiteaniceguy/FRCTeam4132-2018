package org.usfirst.frc.team4132.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveStraightAndRight extends CommandGroup{
	public DriveStraightAndRight() {
		//drive straight
		addSequential(new AutoDriveRobot(0, 0, .8, .8, 3));
		//turn
		addSequential(new AutoDriveRobot(0, 0, -.8, -.8, 3));
		//dirve straight
		addSequential(new AutoDriveRobot(.8, .8, -.8, .8, 3));
	}
}
