/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter;

import textUI.IO;

/**
 * A runnable command for the menu.
 * 
 * @author lvapaaka
 */
public abstract class Command {
    
    protected IO io;

    public Command(IO io) {
        this.io = io;
    }
    
    public abstract void run();
    
}
