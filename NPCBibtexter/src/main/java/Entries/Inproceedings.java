package Entries;

import Fields.*;
import applicationLogic.ScandicConverter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Inproceedings extends Entry {

    final static private Class[] requiredFields = {Author.class, Title.class, Booktitle.class, Year.class};
    final static private Class[] optionalFields = {Editor.class, Pages.class, Organization.class, Publisher.class, Address.class, Month.class, Key.class };
    final public HashSet optionalSet = new HashSet(Arrays.asList(optionalFields));
    private String citationKey;

    public Inproceedings(HashMap<Class<? extends Field>, Field> map, String tag) {
        list = map;
        this.citationKey = tag;

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
        String resString = "@Inproceedings{ " + citationKey + ",\n";
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
