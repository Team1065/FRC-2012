package Moose2012.CommandBased.commands;

/**
 * @author Elean
 */
public class Shoot1Ball extends CommandBase {
    
    public Shoot1Ball() {
        // Use requires() here to declare subsystem dependencies
        requires(conveyor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        conveyor.feed();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(conveyor.getFeedLim()){ 
            return false;
        }
        else
        {
            conveyor.conveyorStop();
            return true;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
