package org.usfirst.frc.team4132.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightSideStartRightSideGoal extends CommandGroup {
	double startX = 239;
	double startY = 18;
	
	double[] pointsX =
		{
				220.4,
				220.4
		}
			;
	double[] pointsY = 
		{
				54,
				122
		}
			;
	public RightSideStartRightSideGoal() {
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
