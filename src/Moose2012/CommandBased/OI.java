
package Moose2012.CommandBased;

import Moose2012.CommandBased.commands.*;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO.EnhancedIOException;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
    
    DriverStationEnhancedIO ds;
    
    
   // Create the joystick 
    Joystick leftJoy = new Joystick(RobotMap.leftJoyPort);
    Joystick rightJoy = new Joystick(RobotMap.rightJoyPort);
    Joystick extraJoy = new Joystick (RobotMap.extraJoyPort);
    Button mecanumButton = new JoystickButton(rightJoy, RobotMap.mecanumButtonPort);
    Button trigger = new JoystickButton(rightJoy, RobotMap.triggerPort);
    Button leftTrigger = new JoystickButton(leftJoy, RobotMap.triggerPort);
    Button testButton = new JoystickButton(rightJoy, 11);
    Button testButton2 = new JoystickButton(leftJoy, 3);
    Button feederInButton = new DigitalIOButton(RobotMap.feederInPort);
    Button feederOutButton = new DigitalIOButton(RobotMap.feederOutPort);
    Button shooterButton = new DigitalIOButton(RobotMap.shooterSwitchPort); //manual or auto shooting
    Button pointButton = new DigitalIOButton(RobotMap.pointSwitch);
    Button hoofButton = new DigitalIOButton(RobotMap.hoofSwitch);
    Button conveyorUpButton = new DigitalIOButton(RobotMap.conveyorUpSwitch);
    Button conveyorDownButton = new DigitalIOButton(RobotMap.conveyorDownSwitch);
    Button conveyorOffButton = new DigitalIOButton(RobotMap.conveyorOffSwitch);
    Button basketButton = new DigitalIOButton(RobotMap.basketSwitchPort);
    Button brakeButton  = new JoystickButton(leftJoy,RobotMap.brakeButtonPort);
    
    public boolean getShooterButton;
    
 
    
    /**
     * Bind the press of each button to a specific command or command group.
     */
    public OI(){
        mecanumButton.whileHeld(new MecanumAssist());
        feederOutButton.whileHeld(new CollectBalls());
        feederInButton.whileHeld(new ReleaseBalls());   
        shooterButton.whileHeld(new AutoShooter());
        hoofButton.whileHeld(new HoofDown());
        trigger.whileHeld(new AutoConveyor());
        //testButton.whenPressed(new Autonomous1());
        testButton2.whenPressed(new TurnWithEncoder(2));
        brakeButton.whileHeld(new Braking());
        ds =DriverStation.getInstance().getEnhancedIO();
    }
    
    public int getAuto() throws EnhancedIOException{
        int auto = 1;
        if(ds.getAnalogIn(2)<RobotMap.autoVDposition1){
            auto = 1;
        }
        else if(ds.getAnalogIn(2)<RobotMap.autoVDposition2){
            auto = 2;
        }
        else if(ds.getAnalogIn(2)<RobotMap.autoVDposition3){
            auto = 3;
        }
        else{
            auto = 4;
        }
        return auto;
    }

    
    public int getPostion() throws EnhancedIOException{
        int position = 0;
        
        if(ds.getAnalogIn(1)<RobotMap.VDposition0){
            position = 0;
        }
        //If Station Knob is at 
        else if(ds.getAnalogIn(1)>=RobotMap.VDposition1 && ds.getAnalogIn(1)<RobotMap.VDposition1+.3){
            position = 1;
        }
        //If Station Knob is at 
        else if(ds.getAnalogIn(1)>=RobotMap.VDposition2 && ds.getAnalogIn(1)<RobotMap.VDposition2+.2){
            position = 2;
        }
        //If Station Knob is at 
        else if(ds.getAnalogIn(1)>=RobotMap.VDposition3&& ds.getAnalogIn(1)<RobotMap.VDposition3+.3){
            position = 3;
        }
        //If Station Knob is at 
        else if(ds.getAnalogIn(1)>=RobotMap.VDposition4&& ds.getAnalogIn(1)<RobotMap.VDposition4+.3){
            position = 4;
        }
        //If Station Knob is at 
        else if(ds.getAnalogIn(1)>=RobotMap.VDposition5){
            position = 5;
         }
         return position;
    }
    
    /**
     * @return The value of the left joystick.
     */
    public double getLeftY() {
        return leftJoy.getY();
    }
    
    public boolean getLeftTrigger() {
        return leftTrigger.get();
    }
    
    public double getLeftX() {
        return leftJoy.getX();
    }
 
    public double getRightY() {
        return rightJoy.getY();
    }
    
    public double getRightX() {
        return rightJoy.getX();
    }
    
    public double getExtraY(){
    return extraJoy.getY();
    }
    
    public boolean getPointButton() {
        return pointButton.get();
    }
    
    public boolean getShooterButton() {
        return shooterButton.get();
    }
    // logic for the conveyor buttons doesn't entirely make sense but works
    public boolean getConveyorUpButton() {
        return conveyorUpButton.get(); 
    }
    public boolean getConveyorDownButton() {
        return conveyorDownButton.get();
    }
    
    public boolean getLoaderInButton(){
        return feederInButton.get();
    }
    
    public boolean getLoaderOutButton(){
        return feederOutButton.get();
    }
    
    //Liz's code
   public boolean getConveyorOffButton() { 
       if (!getConveyorDownButton() && !getConveyorUpButton()) //up & down buttons  aren't pressed
       //return conveyorOffButton.get();
       { return true; } // true = turn off
       else
       {return false;} // false = do not turn off
   }
   
   public boolean getloaderOffButton() {
       if (getLoaderInButton() && getLoaderOutButton()) 
       //return conveyorOffButton.get();
       { return true; }
       else
       {return false;}
   }
   
    
    public boolean getBasketButton(){
        return basketButton.get();
    }
    public boolean getHoofButton() {
        return hoofButton.get();
    }
    public boolean getFeederInButton () {
        return feederInButton.get ();
    }
    public boolean getFeederOutButton () {
        return feederOutButton.get();
    }
  
    public void updateStatus(){
    SmartDashboard.putBoolean("Mecanum", mecanumButton.get());
    SmartDashboard.putBoolean("Trigger", rightJoy.getTrigger());
    SmartDashboard.putBoolean("Conveyor Up", this.getConveyorUpButton());
    SmartDashboard.putBoolean("Conveyor Down",this.getConveyorDownButton());
    SmartDashboard.putBoolean("Loader In", this.getFeederInButton());
    SmartDashboard.putBoolean("Loader Out",this.getFeederOutButton());
    SmartDashboard.putBoolean("Manual Shoot",this.getShooterButton());
   //SmartDashboard.putBoolean(("Basket Out"),this.getBasketButton());
    SmartDashboard.putBoolean("Hoof Down",this.getHoofButton());
    SmartDashboard.putBoolean("3 Pt",this.getPointButton());
    /*try{
    SmartDashboard.putDouble("Analog",ds.getAnalogIn(1));}
    catch(EnhancedIOException e)
    {}*/
    }
}

