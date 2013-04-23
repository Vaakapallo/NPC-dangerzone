/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fields;

/**
 *
 * @author laursuom
 */
public class GenericField implements Field{
    
   protected String value;
   protected String fieldName;
    
    public GenericField(String name) {
        value = name;
    }
    
    @Override
    public String toString() {
        return fieldName + " = {" + value + "},\n";
    }
    
    
    @Override
    public String getField() {
        return value;
    }

    @Override
    public void setField(String value) {
        this.value = value;
    }
    
}
