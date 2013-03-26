package applicationLogic;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lauri
 */
public class Booktitle extends Field {
    
    private String name;
    
    public Booktitle(String name, boolean required) {
    super(required);
    this.name = name;
    }
    
    @Override
    public String getField() {
        return name;
    }

    @Override
    public String toString() {
        return "booktitle = { " + name + " }";
    }
}
