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
	
	public double getGyroData() {
		double angle = 0;
		return angle;
	}
	
<<<<<<< HEAD
=======
	/*

	 * Returns array of phone position
	 */
	public double[] getPosData() {
		double[] position = new double[2];
		return position;
	}
	
>>>>>>> fcd5181312f8573a93f56fca061d41ac5005d0c9
	
	public int getPiTime() {
		
		return (int) 1/*table.getEntry("robotTime").getNumber(0)*/;
		
	}
	
	
	

}
