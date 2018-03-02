/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4132.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4132.robot.commands.CenterStartLeftSideGoal;
import org.usfirst.frc.team4132.robot.commands.CenterStartRightSideGoal;
import org.usfirst.frc.team4132.robot.commands.LeftSideStartLeftSideGoal;
import org.usfirst.frc.team4132.robot.commands.LeftSideStartRightSideGoal;
import org.usfirst.frc.team4132.robot.commands.RightSideStartLeftSideGoal;
import org.usfirst.frc.team4132.robot.commands.RightSideStartRightSideGoal;
import org.usfirst.frc.team4132.robot.commands.SolenoidGearFromJoystick;
import org.usfirst.frc.team4132.robot.commands.SolenoidGrabberFromJoystick;
import org.usfirst.frc.team4132.robot.subsystems.DriveSystem;
import org.usfirst.frc.team4132.robot.subsystems.EncoderSystem;
import org.usfirst.frc.team4132.robot.subsystems.LifterSystem;
import org.usfirst.frc.team4132.robot.subsystems.PiComSystem;
import org.usfirst.frc.team4132.robot.subsystems.PneumaticGearSystem;
import org.usfirst.frc.team4132.robot.subsystems.PneumaticGrabberSystem;
import org.usfirst.frc.team4132.robot.subsystems.VisionSystem;

//import com.kauailabs.navx.frc.AHRS;

//import com.kauailabs.navx.frc.AHRS;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	//subsystems
	public static DriveSystem driveSystem;
	public static LifterSystem lifterSystem;

	public static PiComSystem piComSystem;

	public static PneumaticGrabberSystem pneumaticGrabberSystem;
	public static PneumaticGearSystem pneumaticGearSystem;
	public static EncoderSystem encoderSystem;
	public static VisionSystem visionSystem;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	//public static AHRS ahrs;
	public static OI m_oi;


	/*
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		m_chooser.addDefault("Right Side Auto", new RightSideStartRightSideGoal());
		m_chooser.addObject("Center Auto", new CenterStartRightSideGoal());
		m_chooser.addObject("Left Side Auto", new LeftSideStartRightSideGoal());
		
		SmartDashboard.putData("Auto mode", m_chooser);
		
		/*  subsystems  */
		driveSystem = new DriveSystem();
		lifterSystem = new LifterSystem();
		piComSystem = new PiComSystem();
		pneumaticGrabberSystem = new PneumaticGrabberSystem(RobotMap.grabberSolenoidOne, RobotMap.grabberSolenoidTwo);
		pneumaticGearSystem = new PneumaticGearSystem(RobotMap.gearSolenoidOne, RobotMap.gearSolenoidTwo);
		visionSystem = new VisionSystem();
		//encoderSystem = new EncoderSystem();

		//ahrs = new AHRS(SerialPort.Port.kOnboard);
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		//m_autonomousCommand = m_chooser.getSelected();
		//m_autonomousCommand = new DriveStraightAndRight();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		 //schedule the autonomous command (example)String gameData;
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		// If the goal is to the left, then change the autonomous accordingly
        if (gameData.length() > 0) {
        	if (gameData.charAt(0) == 'L') {
        		if(m_chooser.getSelected().getClass().getName() == "org.usfirst.frc.team4132.robot.commands.RightSideStartRightSideGoal") {
        			m_autonomousCommand = new RightSideStartLeftSideGoal();
        		}
        		else if(m_chooser.getSelected().getClass().getName() == "org.usfirst.frc.team4132.robot.commands.CenterStartRightSideGoal") {
        			m_autonomousCommand = new CenterStartLeftSideGoal();
        		}
        		else {
        			m_autonomousCommand = new LeftSideStartLeftSideGoal();
        		}
        	} 
        	// If the goal is not to the left, use the selected autonomous
        	else {
        		m_autonomousCommand = m_chooser.getSelected();
        	}
        }
        // If the goal is not to the left, use the selected autonomous
        else {
        	m_autonomousCommand = m_chooser.getSelected();
        }
        
        // Start autonomous
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
