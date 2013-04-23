/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fields;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author laursuom
 */
public class GenericNumberField extends GenericField {

    public GenericNumberField(int number) {
        super("" + number);
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
        for (char character : value.toCharArray()) {
            if (!(Character.isDigit(character))) {
                return false;
            }
        }
        return true;
    }
}
