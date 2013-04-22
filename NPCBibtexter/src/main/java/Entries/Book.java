/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entries;

import Fields.*;
import applicationLogic.ScandicConverter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author laursuom
 */
public class Book extends Entry {
//    final static private Class[] requiredFields = {Author.class, Editor.class, Title.class, Publisher.class, Year.class};
    final static private Class[] requiredFields = {Field.class, Title.class, Publisher.class, Year.class};
    final static private Class[] optionalFields = {Volume.class, Series.class, Address.class, Edition.class, Month.class, Note.class, Key.class};
    final public HashSet optionalSet = new HashSet(Arrays.asList(optionalFields));
    String tag;

    public Book(HashMap<Class<? extends Field>, Field> map, String tag) {
        list = map;
        this.tag = tag;

    }
    
    //Note, that Book class has to contain either Author or Editor or both.
    
    /**
     * Piti saada yöllä testattua tota parsimista niin tää palauttaa nyt suoraan true. Toiminnallisuus on myös ohjelman osalta muuten about kondiksessa.
     * @return 
     */
    @Override
    public boolean isValid() {
        HashMap<Class<? extends Field>, Field> tmpHashMap = (HashMap) list.clone();
        if (!(tmpHashMap.containsKey(Author.class.asSubclass(Field.class))) && !(tmpHashMap.containsKey(Editor.class.asSubclass(Field.class))) || ((tmpHashMap.containsKey(Author.class.asSubclass(Field.class))) && (tmpHashMap.containsKey(Editor.class.asSubclass(Field.class))))) {
            return false;
        }
        if(tmpHashMap.containsKey(Author.class.asSubclass(Field.class))){
            tmpHashMap.remove(Author.class.asSubclass(Field.class));
        } else {
            tmpHashMap.remove((Editor.class.asSubclass(Field.class)));
        }
        for (int i = 1; i < requiredFields.length; i++) {
            Class field = requiredFields[i];
            if (!tmpHashMap.containsKey(field)) {
                return false;
            } else {
                tmpHashMap.remove(field);
            }
        }
        for (Class field2 : tmpHashMap.keySet()) {
            if (!optionalSet.contains(field2)) {
                return false;
            } else {
                tmpHashMap.remove(field2);
            }
        }
        return true;
    }

    @Override
    public String toString() {
        
        String resString = "@Book{ " + tag + ",\n";
        if(list.containsKey(Author.class.asSubclass(Field.class))){
            resString = resString + list.get(Author.class.asSubclass(Field.class));
        } else {
           resString = resString + list.get(Editor.class.asSubclass(Field.class));
        }
        for (int i = 1; i < requiredFields.length; i++) {
            if (list.containsKey(requiredFields[i])) {
                resString = resString + list.get(requiredFields[i]);
            }
        }
        for (Class class1 : optionalFields) {
            if (list.containsKey(class1)) {
                resString = resString + list.get(class1);
            }
        }
        resString = resString + "}";
        resString = ScandicConverter.convertScandicsToBibText(resString);
        return resString;
    }
    
    public HashMap<Class<? extends Field>, Field> getList() {
        return list;
    }

    public static Class[] getRequiredFields() {
        return requiredFields;
    }

    public static Class[] getOptionalFields() {
        return optionalFields;
    }
    @Override
    public String getCitationKey(){
        return this.tag;
    }

    @Override
    public void setCitationKey(String key) {
        this.tag = key;
    }
}

