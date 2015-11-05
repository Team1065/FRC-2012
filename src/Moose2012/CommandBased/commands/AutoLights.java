/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Moose2012.CommandBased.commands;

import Moose2012.CommandBased.RobotMap;

/**
 *
 * @author 1065
 */
public class AutoLights extends CommandBase {
    
    public AutoLights() {
        // Use requires() here to declare subsystem dependencies
        requires(lights);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        lights.autoPosLights();
        if(oi.getShooterButton()) // manual mode for shooting
        {
            // if the encoder says that the motors are up to speed
            if((Math.abs(ballshooter.getPosition()-ballshooter.getSetpoint()))/ballshooter.getSetpoint() > RobotMap.threshold){
                lights.readyLightOn(); // turn on green shooter light
            }
            else{ // otherwise, keep the lights off
                lights.readyLightOff();
            }
        }
        else // if we don't want to shoot the balls, keep the lights off
        {
            lights.readyLightOff();
        }
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
