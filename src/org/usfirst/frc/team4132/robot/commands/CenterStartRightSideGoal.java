package org.usfirst.frc.team4132.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterStartRightSideGoal extends CommandGroup {
	double startX = 167;
	double startY = 19;
	
	double[] pointsX =
		{
				221.5,
				221.5
		}
			;
	double[] pointsY = 
		{
				61.2,
				66,
				123
		}
			;
	public CenterStartRightSideGoal() {
		addSequential(new SetInitialPositions(startX, startY));
		for(int i=0; i < pointsX.length; i++) {
			addSequential(new AutoDriveToPoint(pointsX[i], pointsY[i]));
		}
		addSequential(new AutoLift(0.8, 3));
		addSequential(new AutoGrab(true));
		addSequential(new Pause(0.5));
		addSequential(new AutoGrab(false));
		addSequential(new Pause(0.2));
		addSequential(new AutoLift(-0.8, 2));
	}
}
