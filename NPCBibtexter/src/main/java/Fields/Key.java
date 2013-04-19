/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fields;

/**
 *
 * @author Lauri
 */
public class Key implements Field {
    
    String key;
    
    public Key(String key) {
        this.key = key;
    }
    
    @Override
    public String getField() {
        return key;
    }
    
    @Override
    public String toString() {
        return "key = {" + key + "},\n";
    }

    @Override
    public void setField(String value) {
        this.key = value;
    }
}