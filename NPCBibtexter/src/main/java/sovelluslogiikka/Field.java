/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

/**
 *
 * @author jjoonia
 */
public abstract class Field {

    protected boolean required;

    public Field(boolean required){
	this.required = required;
    }	

    public boolean isRequired(){
	return required;
    }

    public abstract String getField();
    @Override
    public abstract String toString();
}
