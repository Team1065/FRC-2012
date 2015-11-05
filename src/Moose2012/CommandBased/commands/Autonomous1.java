/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Moose2012.CommandBased.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Team1065
 */
public class Autonomous1 extends CommandGroup {
    
    public Autonomous1(){
        addParallel(new HoofUp());
        addSequential(new StopAndWait(2));
        addParallel(new ConveyorDown());
        addParallel(new HoofDown());
        addSequential(new StopAndWait(2));
        addSequential(new DrivetoDistance(-17));
    }
}
