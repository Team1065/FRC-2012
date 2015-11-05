package Moose2012.CommandBased.subsystems;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Moose2012.CommandBased.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author 1065
 */
public class Basket extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Solenoid basketActuator;
    
    public Basket () {
        basketActuator = new Solenoid (RobotMap.basketAct);
    }
            
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
       
    }
    public void basketOut () {
        basketActuator.set(true);
    }
    public void basketIn () {
        basketActuator.set (false);
    }
}
