/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fields;

/**
 *
 * @author laursuom
 */
public class Editor extends Field {
    private String name;
    
    public Editor(String name) {
        this.name = name;
    }

    @Override
    public String getField() {
        return name;
    }

    @Override
    public String toString() {
        return "editor = {" + name + "},\n";
    }
    
}
