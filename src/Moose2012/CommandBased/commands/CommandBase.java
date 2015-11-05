package Moose2012.CommandBased.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import Moose2012.CommandBased.OI;
import Moose2012.CommandBased.subsystems.*;
import edu.wpi.first.wpilibj.command.Scheduler;


/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static DriveTrain drivetrain = new DriveTrain();
    public static BallFeeder ballfeeder = new BallFeeder();
    public static BallShooter ballshooter = new BallShooter();
    public static Lights lights = new Lights();
    public static Hoof hoof = new Hoof();
    public static Conveyor conveyor = new Conveyor();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(ballfeeder);
        SmartDashboard.putData(ballshooter);
        SmartDashboard.putData(drivetrain);
        SmartDashboard.putData(hoof);
        SmartDashboard.putData(conveyor);
        //SmartDashboard.putData(basket);
        SmartDashboard.putData(lights);
        //SmartDashboard.putDouble("Encoder",ballshooter.getEncoder());
        
        
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
