/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

/**
 *
 * @author jjoonia
 */
class Author extends Field{
    private String name;
    private boolean required;
    
    public Author(String name, boolean required) {
        this.name = name;
        this.required = required;
    }

    @Override
    public boolean isRequired() {
        return required;
    }

    @Override
    public String getField() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public String toString(){
    return "author = { " + name + " }";
    }
}
