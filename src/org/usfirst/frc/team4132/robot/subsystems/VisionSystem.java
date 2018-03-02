package org.usfirst.frc.team4132.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class VisionSystem extends Subsystem{
	UsbCamera camera; 
	
	public VisionSystem(){
		camera = CameraServer.getInstance().startAutomaticCapture("cam0", 0);
		camera.setResolution(320, 240);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
