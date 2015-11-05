/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Moose2012.CommandBased.commands;

import Moose2012.CommandBased.RobotMap;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO.EnhancedIOException;

/**
 *
 * @author Phu
 */
public class ManualShooter extends CommandBase {
    
    public ManualShooter() {
        // Use requires() here to declare subsystem dependencies
        requires(ballshooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //determine speed
        double speed = 0;
        
        if(oi.getPointButton()){ // if getPointButton = true (on), we are going for 3 points
            try {
                //3 pointer
                if(oi.getPostion()== 0){
                    ballshooter.setActuatorOff();
                    speed = 0;
                }
                else if(oi.getPostion()== 1)
                {
                    ballshooter.setActuatorOff();
                    speed = RobotMap.valueLocation1Point3;
                }
                else if(oi.getPostion()== 2)
                {
                    ballshooter.setActuatorOn();
                    speed = RobotMap.valueLocation2Point3;
                }
                else if(oi.getPostion()== 3)
                {
                    ballshooter.setActuatorOff();
                    speed = RobotMap.valueLocation3Point3;
                }
                else if(oi.getPostion()== 4)
                {
                    ballshooter.setActuatorOn();
                    speed = RobotMap.valueLocation4Point3;
                }
                else
                {
                    ballshooter.setActuatorOn();
                    speed = RobotMap.valueLocation5Point3;
                }
            } catch (EnhancedIOException ex) {
                ex.printStackTrace();
            }
        }
        else{ // if point switch is set to false, we are going for 2 pointer
            try {
                //2 pointer
                if(oi.getPostion()== 0){
                    ballshooter.setActuatorOff();
                    speed = 0;
                }
                else if(oi.getPostion()== 1)
                {
                    ballshooter.setActuatorOff();
                    speed = RobotMap.valueLocation1Point2;
                }
                else if(oi.getPostion()== 2)
                {
                    ballshooter.setActuatorOff();
                    speed = RobotMap.valueLocation2Point2;
                }
                else if(oi.getPostion()== 3)
                {
                    ballshooter.setActuatorOff();
                    speed = RobotMap.valueLocation3Point2;
                }
                else if(oi.getPostion()== 4)
                {
                    ballshooter.setActuatorOff();
                    speed = RobotMap.valueLocation4Point2;
                }
                else
                {
                    ballshooter.setActuatorOff();
                    speed = RobotMap.valueLocation5Point2;
                }
            } catch (EnhancedIOException ex) {
                ex.printStackTrace();
            }
        }
        
        //set shooter speed
        ballshooter.ShooterSet(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
