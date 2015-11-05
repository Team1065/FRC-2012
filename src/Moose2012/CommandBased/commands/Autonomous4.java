/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Moose2012.CommandBased.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Owner
 */
public class Autonomous4 extends CommandGroup {
    
    public Autonomous4() {
        addParallel(new HoofUp());
        addSequential(new StopAndWait(3));
        addSequential(new Shoot1Ball());
        addSequential(new StopAndWait(1));
        addSequential(new Shoot1Ball());
        addSequential(new StopAndWait(1));
        addSequential(new Shoot1Ball());
        addSequential(new StopAndWait(1));
        addSequential(new Shoot1Ball());
        addSequential(new StopAndWait(1));
        addSequential(new Shoot1Ball());
        addSequential(new StopAndWait(1));
        addSequential(new Shoot1Ball());
        addSequential(new StopAndWait(1));
    }
}
