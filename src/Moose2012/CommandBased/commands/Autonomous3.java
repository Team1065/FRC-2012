package Moose2012.CommandBased.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Elean
 */
public class Autonomous3 extends CommandGroup {
    
    public Autonomous3() {
        addParallel(new HoofUp());
        addSequential(new StopAndWait(2));
        addSequential(new Shoot1Ball());
        addSequential(new StopAndWait(1));
        addSequential(new Shoot1Ball());
        addSequential(new StopAndWait(1));
        addSequential(new TurnWithEncoder(4));
        addSequential(new StopAndWait(.25));
        addParallel(new HoofDown());
        addSequential(new DrivetoDistance(-26));
    }
}
