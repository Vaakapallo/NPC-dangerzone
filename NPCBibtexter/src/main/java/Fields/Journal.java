/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fields;

/**
 *
 * @author laursuom
 */
public class Journal implements Field {
    
    private String name;
    
    public Journal(String name) {
        this.name = name;
    }

    @Override
    public String getField() {
        return name;
    }

    @Override
    public String toString() {
        return "journal = {" + name + "},\n";
    }

    @Override
    public void setField(String value) {
        this.name = value;
    }
    
}
