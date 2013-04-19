/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fields;

/**
 *
 * @author Lauri
 */
public class Month implements Field {

    String month;

    public Month(String month) {
        this.month = month;
    }

    @Override
    public String getField() {
        return month.toString();
    }

    @Override
    public String toString() {
        return "month = {" + month.toString() + "},\n";
    }

    public enum MonthConstant {

        jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec
    }
}
