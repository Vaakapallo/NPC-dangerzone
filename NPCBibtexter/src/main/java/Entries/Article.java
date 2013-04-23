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
public class Article extends Entry {

    final static private Class[] requiredFields = {Author.class, Title.class, Journal.class, Year.class};
    final static private Class[] optionalFields = {Volume.class, Fields.BibNumber.class, Pages.class, Month.class, Note.class, Key.class};
    final public HashSet optionalSet = new HashSet(Arrays.asList(optionalFields));
    String citationKey;

    public Article(HashMap<Class<? extends Field>, Field> map, String citeKey) {
        list = map;
        this.citationKey = citeKey;

    }

    @Override
    public boolean isValid() {
        HashMap<Class<? extends Field>, Field> tmpHashMap = (HashMap) list.clone();
        for (Class field : requiredFields) {
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
        String resString = "@Article{ " + citationKey + ",\n";
        for (Class class1 : requiredFields) {
            if (list.containsKey(class1)) {
                resString = resString + list.get(class1);
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

    @Override
    public Class[] getRequiredFields() {
        return requiredFields;
    }

    @Override
    public Class[] getOptionalFields() {
        return optionalFields;
    }
    @Override
    public String getCitationKey(){
        return this.citationKey;
    }

    @Override
    public void setCitationKey(String key) {
        this.citationKey = key;
    }
}