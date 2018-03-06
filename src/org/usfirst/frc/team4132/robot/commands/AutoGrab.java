package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoGrab extends Command{
	DoubleSolenoid pneumaticSystem = Robot.pneumaticGrabberSystem.lifterSolenoid;
	boolean done = false;
	boolean goOut;
	AutoGrab(boolean goOut) {
		this.goOut = goOut;
	}
	public void execute() {
		if (goOut) {
			pneumaticSystem.set(DoubleSolenoid.Value.kForward);
		}
		else {
			pneumaticSystem.set(DoubleSolenoid.Value.kReverse);
		}
		done = true;
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return done;
	}
}
