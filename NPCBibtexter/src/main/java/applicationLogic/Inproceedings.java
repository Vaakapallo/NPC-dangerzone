package applicationLogic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class Inproceedings extends Entry {


    final static private Class[] requiredFields = {Author.class, Title.class, Booktitle.class, Year.class};
    final static private Class[] optionalFields = {};
    final public HashSet optionalSet = new HashSet(Arrays.asList(optionalFields));

    public Inproceedings(HashMap<Class<? extends Field>, Field> map) {
        list = new HashMap();
        try {
            for (Class field : requiredFields) {
                if (!map.containsKey(field)) {
                    throw new Exception();
                } else {
                    list.put(field, map.get(field));
                    map.remove(field);
                }
            }
            for (Class field2 : map.keySet()) {
                if (!optionalSet.contains(field2)) {
                    throw new Exception();
                } else {
                    list.put(field2, map.get(field2));
                    map.remove(field2);
                }
            }

        } catch (Exception e) {
            System.out.println("Fields are not valid!");
        }
    }

    public void testimetodi() {
        System.out.println(list.containsKey((Author.class)));
        System.out.println(list.containsKey((Title.class)));
        System.out.println(list.get(Author.class).getField());
        ;

    }

    @Override
    public String toString() {
        String palautettava = "";
        return palautettava;
    }

    
    public static Class[] getRequiredFields() {
        return requiredFields;
    }

    
    public static Class[] getOptionalFields() {
        return optionalFields;
    }
}


