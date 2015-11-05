/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Moose2012.CommandBased.commands;

/**
 *
 * @author Team1065
 */
public class Braking extends CommandBase {
    
    public Braking() {
        //Use requires() here to declare subsystem dependencies
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drivetrain.brake();
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
