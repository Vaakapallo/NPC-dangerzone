/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fields;

/**
 *
 * @author Lauri
 */
public class Address implements Field {
    
    String name;
    
    public Address(String name) {
        this.name = name;
    }
    
    @Override
    public String getField() {
        return name;
    }
    
    @Override
    public String toString() {
        return "address = {" + name + "},\n";
    }
}
