
package Moose2012.CommandBased.subsystems;

import Moose2012.CommandBased.RobotMap;
import Moose2012.CommandBased.commands.BallFeederOff;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

 
public class BallFeeder extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Victor loadingMotor;
    //DigitalInput topLim;
    //DigitalInput midLim;
    //DigitalInput botLim;
       
    public BallFeeder ()
    {
        loadingMotor = new Victor(RobotMap.loadingMotor);
        //topLim= new DigitalInput(RobotMap.ballSensorTop);
        //midLim= new DigitalInput(RobotMap.ballSensorMiddle);
        //botLim= new DigitalInput(RobotMap.ballSensorBottom);
       
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new BallFeederOff());
    }
    
    public void feedOff() { // don't pick up balls
            loadingMotor.set(0); 
    }
    
    public void feedIn() { // pick up balls
            loadingMotor.set(-RobotMap.loaderSpeed);
    }
    
    public void feedOut() {  // release balls
        loadingMotor.set(RobotMap.loaderSpeed);
    }
}
    
