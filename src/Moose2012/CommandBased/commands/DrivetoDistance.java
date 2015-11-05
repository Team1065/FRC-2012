/*
 * This comands allows the user to input a distance in measure of counts.
 * I                                                                            t uses the average of the 2 banner sensors to figure out when to
 * stop and the speed depending on how close we are. Also it looks for the 
 * differrence between the encoders to keep the bot straight.
 */
package Moose2012.CommandBased.commands;

/**
 *
 * @author Elean
 */
public class DrivetoDistance extends CommandBase {
    private double distance;
    double error, distanceToGo, leftSpeed, rightSpeed;
    
    public DrivetoDistance(double x) {
        // Use requires() here to declare subsystem dependencies
        requires(drivetrain);
        distance = x;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        drivetrain.startCounters();
        drivetrain.resetCounters();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        distanceToGo = Math.abs(distance) - drivetrain.getAverageCount();
        //start slowing down when we are 30 counts away form target
        if(distanceToGo > 20)
        {
            error = (double)drivetrain.getCounterDiff() / 50;
            if(distance>=0)
            {
                leftSpeed = .7 - error;
                rightSpeed = .7 + error;
            }
            else
            {
                leftSpeed = -.7 + error;
                rightSpeed = -.7 - error;
            }
        }
        else if(distanceToGo > 6)
        {
            
            error = (double)drivetrain.getCounterDiff() / 75;
            if(distance>=0)
            {
                leftSpeed = distanceToGo/20 - error;
                rightSpeed = distanceToGo/20 + error;
            }
            else
            {
                leftSpeed = -(distanceToGo/15) + error;
                rightSpeed = -(distanceToGo/15) - error;
            }
            
        }
        else
        {
            if(distance>=0)
            {
                leftSpeed = .5;
                rightSpeed = leftSpeed;
            }
            else
            {
                leftSpeed = -.5;
                rightSpeed = leftSpeed;
            }
            
        }
        
        if(leftSpeed>1)leftSpeed=1;
        else if(leftSpeed<-1)leftSpeed=-1;
        else if(rightSpeed>1)rightSpeed=1;
        else if(rightSpeed<-1)rightSpeed=-1;
        
        drivetrain.tankDrive(leftSpeed, -rightSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(drivetrain.getAverageCount() >= Math.abs(distance))
        {
            drivetrain.stopCounters();
            drivetrain.tankDrive(0, 0);
            return true;
        }
        else
        {
            return false;
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
