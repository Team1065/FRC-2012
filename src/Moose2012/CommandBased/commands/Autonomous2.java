
package Moose2012.CommandBased.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Elean
 */
public class Autonomous2 extends CommandGroup {
    
    public Autonomous2() {
        addParallel(new HoofUp());
        addSequential(new StopAndWait(2));
        addSequential(new Shoot1Ball());
        addSequential(new StopAndWait(1));
        addSequential(new Shoot1Ball());
        addSequential(new StopAndWait(1));
        addSequential(new Shoot1Ball());
        addSequential(new StopAndWait(1));
        addSequential(new Shoot1Ball());
        addSequential(new StopAndWait(1));
        addSequential(new MecanumToDistance(24));
        addSequential(new StopAndWait(.25));
        addSequential(new TurnWithEncoder(4));
        addSequential(new StopAndWait(.25));
        addParallel(new HoofDown());
        addSequential(new DrivetoDistance(-17));
        
    }
}
