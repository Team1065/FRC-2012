/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Moose2012.CommandBased.commands;

/**
 *
 * @author Team1065
 */
public class TurnWithEncoder extends CommandBase {
    
    double distance, distanceToGo, speed;
    
    public TurnWithEncoder(double distance) {
        // Use requires() here to declare subsystem dependencies
        requires(drivetrain);
        this.distance = distance;
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
        if(distanceToGo > 30)
        {
            if(distance>=0)
            {
                speed = .8;
            }
            else
            {
                speed = -.8;
            }
        }
        else if(distanceToGo > 10)
        {
            
            if(distance>=0)
            {
                speed = distanceToGo/20;
            }
            else
            {
                speed = -(distanceToGo/20);
            }
            
        }
        else
        {
            if(distance>=0)
            {
                speed = .5;
            }
            else
            {
                speed = -.5;
            }
            
        }
        
        if(speed>1)speed=1;
        else if(speed<-1)speed=-1;
        drivetrain.tankDrive(-speed, -speed);
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
