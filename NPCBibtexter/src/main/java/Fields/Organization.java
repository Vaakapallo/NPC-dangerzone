/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fields;

/**
 *
 * @author Lauri
 */
public class Organization implements Field{
    
    public String name;
    
    public Organization(String name) {
        this.name = name;
    }

    @Override
    public String getField() {
        return name;
    }
    
    @Override
    public String toString() {
        return "organization = {" + name + "},\n";
    }

    @Override
    public void setField(String value) {
        this.name = value;
    }
    
}
