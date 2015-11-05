/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Moose2012.CommandBased.commands;

import Moose2012.CommandBased.RobotMap;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO.EnhancedIOException;

/**
 *
 * @author 1065
 */
public class AutoShooter extends CommandBase {
    
    public AutoShooter() {
        // Use requires() here to declare subsystem dependencies
        requires(ballshooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        ballshooter.setSetpoint(0);
        ballshooter.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    // automatic shooting system - encoder controlled
    protected void execute() {
        double speed = 0;
        
        if(oi.getPointButton()){ // button is true so we are going for 3 pointer
            //3 pointer
            try {
                //3 pointer
                if(oi.getPostion()== 0){ // if switch is set to off, turn off motor
                    ballshooter.setActuatorOff();
                    speed = 0;
                }
                else if(oi.getPostion()== 1) // position 1
                {
                    ballshooter.setActuatorOff();
                    speed = RobotMap.RPMLocation1Point3;
                }
                else if(oi.getPostion()== 2) // position 2
                {
                    ballshooter.setActuatorOff();
                    speed = RobotMap.RPMLocation2Point3;
                }
                else if(oi.getPostion()== 3) // position 3
                {
                    ballshooter.setActuatorOff();
                    speed = RobotMap.RPMLocation3Point3;
                }
                else if(oi.getPostion()== 4) // position 4
                {
                    ballshooter.setActuatorOn();
                    speed = RobotMap.RPMLocation4Point3;
                }
                else // position 5 - go all out
                {
                    ballshooter.setActuatorOn();
                    speed = RobotMap.RPMLocation5Point3;
                }
            } catch (EnhancedIOException ex) {
                ex.printStackTrace();
            }
        }
        else{ // button is set to false or a 2 pointer
            try {
                //2 pointer
                if(oi.getPostion()== 0){ // shooter switch is 0 - turn motor off
                    ballshooter.setActuatorOff();
                    speed = 0;
                }
                else if(oi.getPostion()== 1) // position 1
                {
                    ballshooter.setActuatorOff();
                    speed = RobotMap.RPMLocation1Point2;
                }
                else if(oi.getPostion()== 2) // position 2
                {
                    ballshooter.setActuatorOff();
                    speed = RobotMap.RPMLocation2Point2;
                }
                else if(oi.getPostion()== 3) // position 3
                {
                    ballshooter.setActuatorOff();
                    speed = RobotMap.RPMLocation3Point2;
                }
                else if(oi.getPostion()== 4) // position 4
                {
                    ballshooter.setActuatorOn();
                    speed = RobotMap.RPMLocation4Point2;
                }
                else // position 5 - go all out
                {
                    ballshooter.setActuatorOn();
                    speed = RobotMap.RPMLocation5Point2;
                }
            } catch (EnhancedIOException ex) {
                ex.printStackTrace();
            }
        }
        
        //set shooter speed
        ballshooter.setSetpoint(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        ballshooter.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        ballshooter.disable();
    }
}
