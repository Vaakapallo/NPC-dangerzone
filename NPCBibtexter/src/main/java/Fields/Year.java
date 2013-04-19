/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fields;

/**
 *
 * @author jjoonia
 */
public class Year implements Field {
    private int year;
    
    public Year(int year) {
        
        this.year= year;
    }

    @Override
    public String getField() {
        return String.valueOf(year);
    }

    @Override
    public String toString() {
        return "year = {" + year + "},\n";
    }

    @Override
    public void setField(String value) {
        try {
            this.year = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println("Virhetilanne, anna vain numeroita, viitettä ei muutettu");
        }
        
    }
    
}

