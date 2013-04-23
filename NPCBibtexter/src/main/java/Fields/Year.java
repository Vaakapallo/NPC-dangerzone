/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fields;

import java.util.ArrayList;

/**
 *
 * @author jjoonia
 */
public class Year extends GenericField {
    
    public Year(int year) {
       super("" + year);
       fieldName = "year";
    }

    @Override
    public void setField(String value) {
        if (isANumber(value)) {
            super.value = value;
        }
    }
    
    public void setField(int value) {
        super.value = "" + value;
    }

    private boolean isANumber(String value) {
       char[] numbers = {1,2,3,4,5,6,7,8,9,0};
       ArrayList<Character> list = new ArrayList(); 
        for (Character character : numbers) {
            list.add(character);
        }
        
        for (int i = 0; i < value.length(); i++) {
            if(!(list.contains(value.charAt(i)))) {
                return false;
        }
        }
         return true;
    }
    
}

