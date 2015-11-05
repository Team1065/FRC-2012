/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Moose2012.CommandBased.commands;

/**
 *
 * @author 1065
 */
public class DriveWithJoySticks extends CommandBase {
    
    public DriveWithJoySticks() {
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(oi.getLeftTrigger()){
        drivetrain.tankDrive(-oi.getLeftY()*.35, oi.getRightY()*.35);
        }
        else{
        drivetrain.tankDrive(-oi.getLeftY(), oi.getRightY());
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
