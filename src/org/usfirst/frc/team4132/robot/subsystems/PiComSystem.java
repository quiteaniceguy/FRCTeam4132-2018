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
	public double[] getGyroData() {
		
		return null;
	}
	
	/*
	 * Returns array of phone position
	 */
	public double[] getPosData() {
		
		return null;
	}
	
	
	/*
	 * Returns time on raspberry pi. May get rid of this, not necessary?
	 */
	public int getPiTime() {
		
		return (int) table.getEntry("robotTime").getNumber(0);
		
	}
	
	
	

}
