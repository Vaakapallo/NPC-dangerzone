/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entries;

import Fields.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author lauri
 */
public abstract class Entry {
    public HashMap<Class<? extends Field>, Field> list;
    @Override
    public abstract String toString();
    public abstract boolean isValid();
    

}
