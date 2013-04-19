/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fields;

/**
 *
 * @author Lauri
 */
public class Note implements Field {
    
    String note;
    
    public Note(String note) {
        this.note = note;
    }
    
    @Override
    public String getField() {
        return note;
    }
    
    @Override
    public String toString() {
        return "note = {" + note + "},\n";
    }
}
