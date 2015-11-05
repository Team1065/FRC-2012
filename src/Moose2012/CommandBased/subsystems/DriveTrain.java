package Moose2012.CommandBased.subsystems;

import Moose2012.CommandBased.RobotMap;
import Moose2012.CommandBased.commands.DriveWithJoySticks;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveTrain extends Subsystem {
    
    private static final double DEADBAND =.9;
    
    Jaguar frontLeft, frontRight, backLeft, backRight;
    Victor hoof;
    Counter driveEncoderLeft, driveEncoderRight;
    Gyro gyro;
    double gyroError;
    
    public DriveTrain()
    {
        frontLeft = new Jaguar(RobotMap.frontLeftMotor);
        frontRight = new Jaguar(RobotMap.frontRightMotor);
        backLeft = new Jaguar(RobotMap.backLeftMotor);
        backRight = new Jaguar(RobotMap.backRightMotor);
        hoof = new Victor(RobotMap.hoofWheel);
        gyro = new Gyro(RobotMap.gyro1);
        driveEncoderLeft = new Counter(RobotMap.encoderLeft);
        driveEncoderRight = new Counter(RobotMap.encoderRight);
        gyro.setSensitivity(0.007);
        gyro.reset();
    }
    
    public int getCounterDiff(){
        int error = driveEncoderLeft.get() - driveEncoderRight.get();
        return error;
    }
    
    public double getAverageCount(){
        return (driveEncoderLeft.get() + driveEncoderRight.get())/2;
    }
    
    public void resetCounters(){
        driveEncoderLeft.reset();
        driveEncoderRight.reset();
    }
    
    public void stopCounters(){
        driveEncoderLeft.stop();
        driveEncoderRight.stop();
    }
    
    public void startCounters(){
        driveEncoderLeft.start();
        driveEncoderRight.start();
    }
    public double getAngle(){
        return gyro.getAngle();
    }
    public void resetGyro(){
        gyro.reset();
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoySticks());
    }
    
    public void tankDrive(double leftVal, double rightVal){
        
        if(leftVal<0)
        {
            leftVal *= RobotMap.leftBackwardBias;
        }
        else
        {
            leftVal *= RobotMap.leftFowardBias;
        }
        if(rightVal>0)
        {
            rightVal *= RobotMap.rightBackwardBias;
        }
        else
        {
            rightVal *= RobotMap.rightFowardBias;
        }
        
        frontLeft.set(leftVal);
        backLeft.set(leftVal);
        frontRight.set(rightVal);
        backRight.set(rightVal);
        hoof.set(rightVal);
    }
    
    public void mecanumDrive(double yVal, double xVal, boolean useGyro)
    {
        if(useGyro)
        {
        gyro.reset();}
       if(Math.abs(yVal) < DEADBAND || Math.abs(xVal) < DEADBAND)
       {
        if(useGyro)
        gyroError = gyro.getAngle()/5;
        else
        gyroError = 0;
        if(xVal<0)
        {
            frontLeft.set(xVal + gyroError);
            backRight.set(-xVal - gyroError);
            backLeft.set(-xVal - gyroError);
            frontRight.set(xVal + gyroError);
        }
        else
        {
            frontLeft.set(xVal - gyroError);
            backRight.set(-xVal + gyroError);
            backLeft.set(-xVal + gyroError);
            frontRight.set(xVal - gyroError);
        }
       }
       else
       {
           if((xVal>0 && yVal>0) || (xVal<0 && yVal<0))
           {
               frontLeft.set(xVal);
               backRight.set(-xVal);
               
               backLeft.set(0);
               frontRight.set(0);
           }
           else
           {
               backLeft.set(xVal);
               frontRight.set(-xVal);
               
               frontLeft.set(0);
               backRight.set(0);
           }
       }
    }
    
    public void brake(){
        frontLeft.set(-RobotMap.brakeSpeed);
        frontRight.set(RobotMap.brakeSpeed);
        backLeft.set(RobotMap.brakeSpeed);
        backRight.set(-RobotMap.brakeSpeed);
    }
    
    public void updateStatus(){
        SmartDashboard.putDouble("Motor1",frontLeft.getSpeed());
        SmartDashboard.putDouble("Motor2",frontRight.getSpeed());
        SmartDashboard.putDouble("Motor3",backLeft.getSpeed());
        SmartDashboard.putDouble("Motor4",backRight.getSpeed());
        SmartDashboard.putDouble("Gyro",gyro.getAngle());
        SmartDashboard.putInt("Banner Left",driveEncoderLeft.get());
        SmartDashboard.putInt("Banner Right",driveEncoderRight.get());
    }
}

