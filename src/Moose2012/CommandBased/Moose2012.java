/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package Moose2012.CommandBased;


import Moose2012.CommandBased.commands.*;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO.EnhancedIOException;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;


public class Moose2012 extends IterativeRobot {

    Command autonomousCommand1;
    Command autonomousCommand2;
    Command autonomousCommand3;
    Command autonomousCommand4;
    Command initConveyor;
    Command initDrive;
    //AxisCamera cam;
    Compressor compressor;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        autonomousCommand1 = new Autonomous1();
        autonomousCommand2 = new Autonomous2();
        autonomousCommand3 = new Autonomous3();
        autonomousCommand4 = new Autonomous4();
        
        // Initialize all subsystems
       //cam = AxisCamera.getInstance("10.10.65.11");
       //cam.writeResolution(AxisCamera.ResolutionT.k160x120);
       compressor = new Compressor(RobotMap.pressureSwitch, RobotMap.compressor);
       initConveyor = new ManualConveyor();
       initDrive = new DriveWithJoySticks();
       CommandBase.init();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        
        compressor.start();
        try {
            switch(CommandBase.oi.getAuto()){
                case(1): 
                    autonomousCommand1.start();
                    break;
                
                case(2): 
                    autonomousCommand2.start();
                    break;
                case(3): 
                    autonomousCommand3.start();
                    break;
                 case(4): 
                    autonomousCommand4.start();
                    break;
                     
                default:  autonomousCommand4.start();
            }
        } catch (EnhancedIOException ex) {
            ex.printStackTrace();
        }
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to 
		// continue until interrupted by another command, remove
		// this line or comment it out.
		//autonomousCommand.cancel();
        
        //cam = AxisCamera.getInstance("10.10.65.11");
        //cam.writeResolution(AxisCamera.ResolutionT.k160x120);
        compressor.start();
        initConveyor.start();
        initDrive.start();
        
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        CommandBase.oi.updateStatus();
        CommandBase.ballshooter.updateStatus();
        CommandBase.drivetrain.updateStatus();
        CommandBase.hoof.updateStatus();
        CommandBase.lights.updateStatus();
        CommandBase.conveyor.updateStatus();
        
    }
    
    public void updateStatus(){
    CommandBase.drivetrain.updateStatus();
    CommandBase.ballshooter.updateStatus();
    CommandBase.oi.updateStatus();
    CommandBase.hoof.updateStatus();
    CommandBase.lights.updateStatus();
    CommandBase.conveyor.updateStatus();
    }
}
