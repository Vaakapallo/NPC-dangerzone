/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fields;

/**
 *
 * @author Lauri
 */
public class Number implements Field {
    
    int number;
    
    public Number(int number) {
        this.number = number;
    }
    
    @Override
    public String getField() {
        return "" + number;
    }
    
    @Override
    public String toString() {
        return "number = {" + number + "},\n";
    }
}
