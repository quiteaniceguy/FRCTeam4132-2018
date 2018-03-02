package org.usfirst.frc.team4132.robot.commands;

import org.usfirst.frc.team4132.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveToPoint extends CommandGroup{
	private double a = 0, g = 9.81, d = 0, u = 0.8, xPos, yPos, angle, rAngle;
	double[] positions = new double[2];
	public DriveToPoint(double x, double y) {
		super("DriveToPoint");
		
		requires(Robot.driveSystem);
		//requires(Robot.piComSystem);

		//rAngle = Robot.piComSystem.getGyroData();
		//positions = Robot.piComSystem.getPosData();
		xPos = positions[0];
		yPos = positions[1];
		
		if (xPos >= x) {
			angle = Math.atan((y-yPos)/(x-xPos));
		}
		else {
			angle = Math.atan((y-yPos)/(x-xPos)) + Math.PI;
		}
		if (angle < 0) {
			angle = 2 * Math.PI + angle;
		}
		while (rAngle < angle - 0.25 || rAngle > angle + 0.25) {
			if (angle - rAngle > Math.PI) {
				Robot.driveSystem.controlAllDriveWheels(a, -a, a, -a); //May not rotate the correct way, does not give the correct acceleration value
			}
			else {
				Robot.driveSystem.controlAllDriveWheels(-a, a, -a, a); //May not rotate the correct way, does not give the correct acceleration value
			}
			//rAngle = Robot.piComSystem.getGyroData();
		}
		d = Math.sqrt(Math.pow(x - xPos, 2) + Math.pow(y - yPos, 2));
		double[] times = findMoveTimes(a,g,d,u);
		addSequential(new AutoDriveRobot(a, a, a, a, times[0]));
		addSequential(new AutoDriveRobot(-a, -a, -a, -a, times[1]));
		addSequential(new AutoDriveRobot(0, 0, 0, 0, 0.1));
	}
	
	public void execute() {
		
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}
	
	@Override
	protected void end() {
		Robot.driveSystem.controlAllDriveWheels(0, 0, 0, 0);
	}
	
	@Override
	protected void interrupted() {
		end();
	}
	
	double[] findMoveTimes(double a, double g, double d, double u) {
		double deccelTime = Math.sqrt((Math.pow(d,2)*(a-u*g)*2)/((a+u*g)*(1-3*d*(a-u*g)))); //Formula derived from kinematic equations
		double accelTime = (a+u*g)*deccelTime/(a-u*g);
		double[] times = {accelTime, deccelTime};
		return times;
	}

}
