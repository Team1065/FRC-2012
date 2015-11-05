package Moose2012.CommandBased.subsystems;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Moose2012.CommandBased.RobotMap;
import Moose2012.CommandBased.commands.AutoLights;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author 1065
 */
public class Lights extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Relay bottom;
    Relay middle;
    Relay top;
    Relay ready;
    DigitalInput botLim;
    DigitalInput midLim;
    DigitalInput topLim;
    
    public Lights(){
        bottom = new Relay(RobotMap.botLight);
        middle = new Relay(RobotMap.midLight);
        top = new Relay(RobotMap.topLight);
        ready = new Relay(RobotMap.readyLight);
        botLim = new DigitalInput(RobotMap.ballSensorBottom);
        midLim = new DigitalInput(RobotMap.ballSensorMiddle);
        topLim = new DigitalInput(RobotMap.ballSensorTop);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new AutoLights());
    }
    
    public void autoPosLights(){
        if(botLim.get()==false){ // if bottom limit button is pressed, turn on botton light
            bottom.set(Relay.Value.kForward);
        }
        else{ // otherwise, keep the bottom light off
            bottom.set(Relay.Value.kReverse);
        }
        if(midLim.get()==false){ // if middle limit button is pressed, turn on middle light
            middle.set(Relay.Value.kForward);
        }
        else{ // otherwise, keep the middle light off
            middle.set(Relay.Value.kReverse);
        }
        if(topLim.get()==false){ // if top limit button is pressed, turn on top lights
            top.set(Relay.Value.kForward);
        }
        else{ // otherwise, keep the top light off
            top.set(Relay.Value.kReverse);
        }
    }
    public void readyLightOn(){ // turn on green shooting light
        ready.set(Relay.Value.kForward);
    }
    public void readyLightOff(){ // turn off green shooting light
        ready.set(Relay.Value.kReverse);
    }
    
    public boolean getTopLimit(){
        return topLim.get();
    }
    
    public boolean getMidLimit(){
        return midLim.get();
    }
    public boolean getBotLimit(){
        return botLim.get();
    }
    
    public void updateStatus(){
    SmartDashboard.putBoolean("TopLimit",this.getTopLimit());
    SmartDashboard.putBoolean("MiddleLimit",this.getMidLimit());
    SmartDashboard.putBoolean("BottomLimit",this.getBotLimit());
    }
}
