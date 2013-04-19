/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fields;

/**
 *
 * @author Lauri
 */
public class BibNumber implements Field {
    
    int number;
    
    public BibNumber(int number) {
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
