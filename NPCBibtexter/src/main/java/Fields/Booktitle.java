package Fields;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lauri
 */
public class Booktitle implements Field {
    
    private String name;
    
    public Booktitle(String name) {
    this.name = name;
    }
    
    @Override
    public String getField() {
        return name;
    }

    @Override
    public String toString() {
        return "booktitle = {" + name + "},\n";
    }
}
