/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Moose2012.CommandBased.subsystems;

import Moose2012.CommandBased.RobotMap;
import Moose2012.CommandBased.commands.AutoShooter;
import Moose2012.CommandBased.commands.CommandBase;
import Moose2012.CommandBased.commands.ManualShooter;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 * @author 1065
 */
public class BallShooter extends PIDSubsystem {
    
    Jaguar shootingMotor;
    Encoder shooterEncoder;
    Solenoid shooterActuator;
    
    private static final double Kp = RobotMap.proportional;
    private static final double Ki = RobotMap.iterative;
    private static final double Kd = RobotMap.derivative;
    
    public BallShooter(){
     super("BallShooter", Kp, Ki, Kd);
    shootingMotor= new Jaguar(RobotMap.shooterMotor);
    shooterEncoder = new Encoder(RobotMap.encoderShooterA,RobotMap.encoderShooterB,false,CounterBase.EncodingType.k1X);
    shooterEncoder.setDistancePerPulse(8*3.14/360);
    shooterEncoder.start();
    shooterActuator = new Solenoid (RobotMap.shooterAct);
    }

    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ManualShooter());
    }
    
    public void setActuatorOn(){
        shooterActuator.set(true);
    }
    
    public void setActuatorOff(){
        shooterActuator.set(false);
    }
    
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        return shooterEncoder.getRate();
    }
    
    protected void usePIDOutput(double output) {
        double speed = shootingMotor.get()+ output;
        if (speed > 1)
            speed = 1;
        else if(speed < -1)
            speed = -1;
        
        ShooterSet(speed);
    }
    
    public void ShooterStop () {
       shootingMotor.set(0);
   }
    public void ShooterSet (double speed) {
        shootingMotor.set(speed);
    }
    
    public double getEncoder () {
        return shooterEncoder.getRate();
    }
   
    public double getEncoderRaw () {
        return shooterEncoder.getRaw();
    }
    
    
    public void updateStatus(){
    SmartDashboard.putDouble("Encoder",shooterEncoder.getRate());
    SmartDashboard.putDouble("Encoder",shooterEncoder.getRate());
    SmartDashboard.putDouble("threashgolf", (Math.abs(this.getPosition()-this.getSetpoint()))/this.getSetpoint());

    }
}
