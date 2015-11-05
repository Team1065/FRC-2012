package Moose2012.CommandBased;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    //turn on gyro assist for mecanum drive
    public static final boolean
            gyroAssistEnable = false;
    
    //Shooter error Threshold 0->1
    public static final double 
            threshold = -.10;
    
    //motor bias
    public static final double 
            leftFowardBias = 1,
            leftBackwardBias = .65, //lower because to prevent tipping 
            rightFowardBias = .85,
            rightBackwardBias = .7; //lower because to prevent tipping 
    
    
    //Shooter PID values
    public static final double 
            proportional = -.0002,
            iterative    = -.0000,
            derivative   = -.001;
    
    //Autonomous Knob values
    public static final double 
            autoVDposition1 = 0.5,
            autoVDposition2 = 1.2,
            autoVDposition3 = 2,
            autoVDposition4 = 3;// not used because an else is used in logic
    
    //Shooter Knob values
    public static final double 
            VDposition0 = 0.5,
            VDposition1 = 1,
            VDposition2 = 1.7,
            VDposition3 = 2.05,
            VDposition4 = 2.7,
            VDposition5 = 3.15;
    
    //Shooter Speed Values
    public static final double
            valueLocation1Point2 = .4,
            valueLocation1Point3 = .5,
            valueLocation2Point2 = .45,
            valueLocation2Point3 = .55,
            valueLocation3Point2 = .45,
            valueLocation3Point3 = .55,
            valueLocation4Point2 = .65,
            valueLocation4Point3 = .70,
            valueLocation5Point2 = .75,
            valueLocation5Point3 = 1;
    
    //Shooter RPM Values
    public static final double
            RPMLocation1Point2 = -450,
            RPMLocation1Point3 = -645,
            RPMLocation2Point2 = -635,
            RPMLocation2Point3 = -655,
            RPMLocation3Point2 = -690,
            RPMLocation3Point3 = -700,
            RPMLocation4Point2 = -860,
            RPMLocation4Point3 = -870,
            RPMLocation5Point2 = -950,
            RPMLocation5Point3 = -1000;
            
    //Motor Speeds
    public static final double
            hoofElbowSpeed     = 0.6,  // 60% hoof
            queueSpeed         = -.6,  // 60% feed
            conveyorUpSpeed    = -.9,  // 90% queue
            conveyorDownSpeed = .8,    // 80% down
            conveyorStopSpeed = 0,     // turn motor off
            loaderSpeed        = -.9,   // 90% power
            brakeSpeed         =.5;
            
    //JoyStick Inpts
    public static final int 
            leftJoyPort       = 1,
            rightJoyPort      = 2,
            extraJoyPort      = 3,
            triggerPort       = 1,  // shoot the balls
            mecanumButtonPort = 2,  // turn on mecanum
            brakeButtonPort   = 2;
    
    //Enhanced Operator Inputs
    public static final int 
            basketSwitchPort  = 1,   // open/close the basket
            pointSwitch       = 2,   // 2 or 3 point hoop
            conveyorDownSwitch = 7,  // turn conveyor system down
            feederInPort      = 4,   // pick balls up
            feederOutPort     = 5,   // release balls
            shooterSwitchPort = 6,   // encoder or manual shooter control
            conveyorUpSwitch  = 3,   // turn conveyor system up
            hoofSwitch        = 8,   // move the hoof
            conveyorOffSwitch = 9;   // turn conveyor system down
            
            
            
    //Motors PMW input on Robot
    public static final int 
            frontLeftMotor  = 1,  // Drive motor
            frontRightMotor = 2,  // Drive motor
            backLeftMotor   = 3,  // drive motor
            backRightMotor  = 4,  // drive motor
            shooterMotor    = 5,  // shooter motor - this runs 2 motors
            loadingMotor    = 6,  // feed/loading motor at bottom of robot
            conveyorMotor   = 7,  // conveyor motor
            hoofElbow       = 8,  // motor for lifting and lowering hoof
            hoofWheel       = 9;  // motor removed - used to be for driving the hoof wheel
            
    //Pneumatic Actuators
    public static final int
            shooterAct = 1,
            hoofAct    = 2,
            basketAct  = 3;
    
    //Relays
    public static final int
            compressor = 1,  // compressor relay 
            readyLight = 2,  // green shooter light relay
            midLight   = 4,  // middle limit button on conveyor
            topLight   = 3,  // top limit button on conveyor
            botLight   = 5;  // bottom limit button on conveyor
            
    //Digital sensors on robot
    public static final int 
            pressureSwitch   = 1,  //11 - pressure switch for compressor
            encoderShooterA  = 2,  //1 - shooter encoder 
            encoderShooterB  = 3,  //2 - shooter encoder
            encoderLeft      = 4,  // drive encoder
            encoderRight     = 5,  // drive encoder
            feedingReady     = 6,  // top limit switch for shooting
            ballSensorTop    = 7,  // top limit button on conveyor
            ballSensorMiddle = 8,  // middle limit button on conveyor
            ballSensorBottom = 9,  // bottom limit button on conveyor
            hoofLimitUp      = 10, // hoof has hit the up position - false is pressed
            hoofLimitDown    = 11; // hoof has hit the down position - false is pressed
            
    //Analog sensors
    public static final int 
            gyro1      = 1,
            autoSelect = 2;
    
    
}
