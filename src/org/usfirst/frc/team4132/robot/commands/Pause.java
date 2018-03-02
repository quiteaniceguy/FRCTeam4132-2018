package org.usfirst.frc.team4132.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class Pause extends Command{
	
	Pause(double time) {
		setTimeout(time);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

}
