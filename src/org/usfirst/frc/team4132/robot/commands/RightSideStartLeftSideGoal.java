package org.usfirst.frc.team4132.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightSideStartLeftSideGoal extends CommandGroup {
	double startX = 239;
	double startY = 17.5;
	
	double[] pointsX =
		{
				209,
				102,
				102
		}
			;
	double[] pointsY = 
		{
				63,
				63,
				122
		}
			;
	public RightSideStartLeftSideGoal() {
		addSequential(new SetInitialPositions(startX, startY));
		for(int i=0; i < pointsX.length; i++) {
			addSequential(new AutoDriveToPoint(pointsX[i], pointsY[i]));
		}
		addSequential(new AutoLift(0.8, 3));
		addSequential(new AutoGrab(true));
		Timer.delay(0.5);
		addSequential(new AutoGrab(false));
		Timer.delay(0.2);
		addSequential(new AutoLift(-0.8, 2));
	}
}
