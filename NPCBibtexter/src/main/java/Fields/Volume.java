/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fields;

/**
 *
 * @author Lauri
 */
public class Volume implements Field {
    
    String name;
    
    public Volume(String name) {
        this.name = name;
    }
    
    @Override
    public String getField() {
        return name;
    }
    
    @Override
    public String toString() {
        return "volume = {" + name + "},\n";
    }

    @Override
    public void setField(String value) {
        this.name = value;
    }
}
