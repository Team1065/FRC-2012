/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Moose2012.CommandBased.commands;

/**
 *
 * @author Elean
 */
public class TurnWithGyro extends CommandBase {
    double angle, difference, speed;
    
    
    public TurnWithGyro(double angle) {
        // Use requires() here to declare subsystem dependencies
        requires(drivetrain);
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        drivetrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        difference = angle - drivetrain.getAngle();
        if(difference<15){
            if(angle<0)
                speed=-.25;
            else 
                speed = .2;
        }
        else if(difference < 45)
        {
            if(angle<0)speed=-1;
            else speed = difference/90;;
        }
        else
        {
                if(angle<0)speed=-1;
                else speed = .3;
        }
       drivetrain.tankDrive(-speed, -speed);

}
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Math.abs(difference) < 3)
        {
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
