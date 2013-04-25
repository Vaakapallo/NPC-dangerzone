/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import java.util.ArrayList;
import java.util.List;
import textUI.IO;

/**
 *
 * @author lvapaaka
 */
public class IOStub implements IO {

    private String[] input;
    private int inputIndex;
    private List<String> output;

    public IOStub(String... input) {
        this.input = input;
        inputIndex = 0;
        output = new ArrayList();
    }

    @Override
    public int readInt() {
        return Integer.parseInt(input[inputIndex++]);
    }

    @Override
    public String readString() {
        return input[inputIndex++];
    }

    @Override
    public void printLine(String text) {
        output.add(text);
    }

    @Override
    public void printLineChange() {
        output.add("\n");
    }

    public List<String> getOutput() {
        return output;
    }

    @Override
    public int readPossiblyEmptyInt() {
        return Integer.parseInt(input[inputIndex++]);
    }

    @Override
    public String readPossiblyEmptyString() {
        return input[inputIndex++];
    }
    
    public String outputAsString(){
        String stringOutput = "";
        for (String string : output) {
            stringOutput += string;
        }
        return stringOutput;
    }
}
