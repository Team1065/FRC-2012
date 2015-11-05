/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Moose2012.CommandBased.commands;

import Moose2012.CommandBased.RobotMap;
import Moose2012.CommandBased.subsystems.Conveyor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Logan and Elisabeth
 */
public class AutoConveyor extends CommandBase {
    
    public AutoConveyor() {
        // Use requires() here to declare subsystem dependencies
        requires(conveyor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        //if topLimit is pressed (ball ready to shoot)
        if (!lights.getTopLimit()){
            //if Shooterbutton pressed for auto shooting
            if (!oi.getShooterButton()){
                //If within threshold
                if((Math.abs(ballshooter.getPosition()-ballshooter.getSetpoint()))/ballshooter.getSetpoint() > RobotMap.threshold){
                    conveyor.feed();}    //feed ball into shooter
                else{                   //Ball is not within threshold
                    conveyor.conveyorStop();
                    }//Stop conveyor
                }
            else {          //If
                conveyor.feed();
                }
    }
    else {      //Toplimit is not pressed
        conveyor.feed();//move balls up conveyor
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
