/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package textUI;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lvapaaka
 */
public class IOStub implements IO {
    
    private String[] input;
    private int inputIndex;
    private List<String> output;
    
    public IOStub(String[] input) {
        this.input = input;
        inputIndex = 0;
        output = new ArrayList();
    }
    
    public int readInt() {
        return Integer.parseInt(input[inputIndex++]);
    }
    
    public String readString() {
        return input[inputIndex++];
    }
    
    public void printSomething(String text) {
        output.add(text);
    }
    
    public void printLineChange() {
        output.add("\n");
    }
    
    public List<String> getOutput(){
        return output;
    }
}
