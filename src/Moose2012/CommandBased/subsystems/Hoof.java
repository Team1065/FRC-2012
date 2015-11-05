package Moose2012.CommandBased.subsystems;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Moose2012.CommandBased.RobotMap;
import Moose2012.CommandBased.commands.HoofUp;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author 1065
 */
public class Hoof extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Victor elbowMotor;
    Solenoid hoofActuator;
    DigitalInput upLim;
    DigitalInput downLim;
    
    public Hoof () {
    elbowMotor = new Victor (RobotMap.hoofElbow); 
    hoofActuator = new Solenoid (RobotMap.hoofAct);
    upLim = new DigitalInput (RobotMap.hoofLimitUp);
    downLim   = new DigitalInput (RobotMap.hoofLimitDown);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new HoofUp());
    }
    public void hoofUp () {
       hoofActuator.set(false); 
        if (upLim.get()){ // if the hoof is not fully up
            elbowMotor.set(-.2); // keep putting the hoof up
        }
        else { // we hit the up position for the hoof, stop the hoof
            elbowMotor.set(0);
        }
    }
    public void hoofDown () {
        if (downLim.get()){ // if the hoof is not fully down
            elbowMotor.set(RobotMap.hoofElbowSpeed); // keep going down
            hoofActuator.set(false);

        }
        else { // we hit the down position for the hoof, stop the hoof
            elbowMotor.set(0);
            hoofActuator.set(true);}
    }
    
    public boolean getHoofUpLim(){ // false is pressed, true is open
        return upLim.get();
        }
    public boolean getHoofDownLim(){ // false is presed, true is open
        return downLim.get();
        }
    
    public void updateStatus(){
        SmartDashboard.putBoolean("HoofUpLimit", this.getHoofUpLim());
        SmartDashboard.putBoolean("HoofDownLim",this.getHoofDownLim());
    }
}

