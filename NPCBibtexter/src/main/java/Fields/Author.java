/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fields;

/**
 *
 * @author jjoonia
 */
public class Author extends Field{
    private String name;
    
    public Author(String name) {
        this.name = name;
    }

    @Override
    public String getField() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public String toString(){
    return "author = {" + name + "},\n";
    }
}