/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;

/**
 *
 * @author jjoonia
 */
class Title extends Field {
    private String name;
    
    public Title(String name) {
        this.name = name;
    }

    @Override
    public String getField() {
        return name;
    }

    @Override
    public String toString() {
        return "title = {" + name + "},\n";
    }
    
}
