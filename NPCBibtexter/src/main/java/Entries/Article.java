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
public class Article extends Entry{

       final static private Class[] requiredFields = {Author.class, Title.class, Journal.class, Year.class};
    final static private Class[] optionalFields = {};
    final public HashSet optionalSet = new HashSet(Arrays.asList(optionalFields));
    String tag;

    public Article(HashMap<Class<? extends Field>, Field> map, String tag) {
        list = map;
        this.tag = tag;

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
        String resString = "@Article{ " + tag + ",\n";
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

    public static Class[] getRequiredFields() {
        return requiredFields;
    }

    public static Class[] getOptionalFields() {
        return optionalFields;
    }
}