/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fields;

/**
 *
 * @author Lauri
 */
public class Edition implements Field {
    
    String name;
    
    public Edition(String name) {
        this.name = name;
    }
    
    @Override
    public String getField() {
        return name;
    }
    
    @Override
    public String toString() {
        return "edition = {" + name + "},\n";
    }
}
