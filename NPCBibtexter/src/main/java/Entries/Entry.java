/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entries;

import Fields.Field;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author lauri
 */
public abstract class Entry {

    public HashMap<Class<? extends Field>, Field> list;
    public HashSet<String> tags;
    
    public Entry() {
        tags = new HashSet();
    }

    @Override
    public abstract String toString();

    public abstract boolean isValid();

    public abstract String getCitationKey();

    public abstract void setCitationKey(String key);
    
    public abstract Class[] getOptionalFields();
    public abstract Class[] getRequiredFields();
    
    public void addTag(String tag) {
        tags.add(tag);
    }
    public boolean tagExists(String tag) {
        return tags.contains(tag);
    }
    public boolean removeTag(String tag) {
        if (tagExists(tag)) {
            tags.remove(tag);
            return true;
        }
        return false;
    }
}
