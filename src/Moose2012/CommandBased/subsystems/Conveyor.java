/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Moose2012.CommandBased.subsystems;

import Moose2012.CommandBased.RobotMap;
import Moose2012.CommandBased.commands.ManualConveyor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.Timer;

/**
 *
 * @author 1065
 */
public class Conveyor extends Subsystem {
    Victor theChosenOne;
    DigitalInput feedingLim;
    Timer time;
    
    
    public Conveyor(){
        theChosenOne = new Victor(RobotMap.conveyorMotor);
        feedingLim = new DigitalInput(RobotMap.feedingReady);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ManualConveyor());
    }
    
    public void conveyorUp(){ // conveyor going up
        theChosenOne.set(RobotMap.conveyorUpSpeed);
    }
    
    
    public void conveyorDown(){ // conveyor going down
        theChosenOne.set(RobotMap.conveyorDownSpeed);
    }
    
    public void conveyorStop(){ // turn off conveyor
        //theChosenOne.set(RobotMap.conveyorStopSpeed);
    theChosenOne.set(0);
    }
    
    public void feed(){
        if(!feedingLim.get()){ // if we hit the top limit switch for feeding, turn conveyor off
            conveyorStop();
            }
        
        else{
            conveyorQueue(); // otherwise, keep going up
            }
    }
    public void conveyorQueue(){
        theChosenOne.set(RobotMap.queueSpeed);
}

    public boolean getFeedLim(){
        return feedingLim.get();
    }
    
    public void updateStatus(){
        SmartDashboard.putBoolean("ReadyLimit",this.getFeedLim());
        
    }
}
