/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreter;

import textUI.IO;

/**
 *
 * @author lvapaaka
 */
public class Quit extends Command {

    public Quit(IO io) {
        super(io);
    }

    @Override
    public void run() {
        io.printLine("suljetaan");
//        System.exit(0);
    }
    
}
