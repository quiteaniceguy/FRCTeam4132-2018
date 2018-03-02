package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.RobotPosData;

import edu.wpi.first.wpilibj.command.Command;

public class SetInitialPositions extends Command{
	boolean done = false;
	
	SetInitialPositions(double x, double y) {
		RobotPosData.xPos = x;
		RobotPosData.yPos = y;
		done = true;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return done;
	}

}
