package org.usfirst.frc.team4132.robot.subsystems;

import org.usfirst.frc.team4132.robot.Robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PiComSystem extends Subsystem{
	
	private static final String TABLE_NAME = "testDatatable";
	
	NetworkTable table;
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
		NetworkTableInstance networkTable = NetworkTableInstance.getDefault();
		table = networkTable.getTable(TABLE_NAME);
		
	}
	
	/*
	 * Returns array of gyroscope data
	 */
	public double getGyroData() {
		double angle = 0;
		return angle;
	}
	
	/*

	 * Returns array of phone position
	 */
	public double[] getPosData() {
		double[] position = new double[2];
		return position;
	}
	
	
	/*
>>>>>>> a2915a0824b8af35ec9f06f951b06a237b6fd624
	 * Returns time on raspberry pi. May get rid of this, not necessary?
	 */
	public int getPiTime() {
		
		return (int) 1/*table.getEntry("robotTime").getNumber(0)*/;
		
	}
	
	
	

}
