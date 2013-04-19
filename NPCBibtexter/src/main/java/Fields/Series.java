/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fields;

/**
 *
 * @author Lauri
 */
public class Series implements Field {
    
    String name;
    
    public Series(String name) {
        this.name = name;
    }
    
    @Override
    public String getField() {
        return name;
    }
    
    @Override
    public String toString() {
        return "series = {" + name + "},\n";
    }
}
    

