package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveStraight extends CommandGroup{
	//drive straight
	public DriveStraight() {
		/*
		addSequential(new AutoGrab(true));
		Timer.delay(1);
		addSequential(new AutoLift(.8, 2));
		addSequential(new AutoGrab(true));
		Timer.delay(1);
		addSequential(new AutoLift(-0.8, 2));
		*/
		//addSequential(new AutoDriveRobot(.66, .25, .66, .25, 3));
		
		addSequential(new AutoDriveRobot(1, 0, 0, 0, 1)); //Back left
		//addSequential(new AutoDriveRobot(0, 1, 0, 0, 1)); //Back Right
		//addSequential(new AutoDriveRobot(0, 0, 1, 0, 1)); //Front left
		//addSequential(new AutoDriveRobot(0, 0, 0, 1, 1)); //Front Right
		
	}
}
