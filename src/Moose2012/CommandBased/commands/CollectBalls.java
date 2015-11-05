/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Moose2012.CommandBased.commands;

/**
 *
 * @author Lora Lee
 */
public class CollectBalls extends CommandBase {
    
    public CollectBalls() {
        // Use requires() here to declare subsystem dependencies
        requires(ballfeeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (oi.getloaderOffButton()){ // want to stop picking up balls
        ballfeeder.feedOff(); // turn motor off
        }
        // if we want to keep picking up balls but we already have 3 balls
        else if(!oi.getLoaderInButton() && (lights.getBotLimit()|| lights.getMidLimit()||lights.getTopLimit())){
        ballfeeder.feedOut(); // 
        }
        else{ // otherwise, keep picking up balls
        ballfeeder.feedIn();
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
