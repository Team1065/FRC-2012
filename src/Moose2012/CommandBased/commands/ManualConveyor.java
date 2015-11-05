/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Moose2012.CommandBased.commands;

/**
 *
 * @author 1065
 */
public class ManualConveyor extends CommandBase {
    
    public ManualConveyor() {
        // Use requires() here to declare subsystem dependencies
        requires(conveyor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //If Conveyor
        if(!oi.getConveyorUpButton())
        {
            //queue
            if(!lights.getTopLimit())
            {
                conveyor.conveyorStop();
            }
            else{
                conveyor.conveyorUp();
            }
        }
        else if(!oi.getConveyorDownButton())
        {   
            conveyor.conveyorDown();
        }
        //Liz
        else if (!oi.getConveyorOffButton())
        {
            if(oi.getFeederInButton())
            {
                 conveyor.conveyorStop();
            }
            else
            {
                if(!lights.getTopLimit())
                {
                    conveyor.conveyorStop();
                }
                else if(!lights.getMidLimit() && !lights.getBotLimit())
                {
                    conveyor.conveyorUp();
                }
                else if(!lights.getMidLimit())
                {
                    conveyor.conveyorStop();
                }
                else
                {
                    conveyor.conveyorUp();
                }
            }
        }   
        else{
            conveyor.conveyorStop();
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
