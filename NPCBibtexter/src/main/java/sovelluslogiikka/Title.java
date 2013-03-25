/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

/**
 *
 * @author jjoonia
 */
class Title extends Field {
    private String name;
    
    public Title(String name, boolean required) {
        super(required);
        this.name = name;
    }

    @Override
    public String getField() {
        return name;
    }

    @Override
    public String toString() {
        return "title = { " + name + " }";
    }
    
}
