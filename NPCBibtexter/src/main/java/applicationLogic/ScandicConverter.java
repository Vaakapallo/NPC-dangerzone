/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;

import java.util.HashMap;
import java.util.Map;

/**
 * Static class that converts Scandic letters to a format BibText understands
 *
 * @author lvapaaka
 */
public class ScandicConverter {

    private static final Map<String, String> charAndReplacement;

    static {
        charAndReplacement = new HashMap<String, String>();
        charAndReplacement.put("ä", "\\\"{a}");
        charAndReplacement.put("å", "\\\"{aa}");
        charAndReplacement.put("ö", "\\\"{o}");
        charAndReplacement.put("Ä", "\\\"{A}");
        charAndReplacement.put("Å", "\\\"{AA}");
        charAndReplacement.put("Ö", "\\\"{O}");
    }

    /**
     * Converts all scandic characters in the given string into BibText-friendly
     * ones.
     *
     * @param convertee String with potential scandic letters
     * @return string that BibText accepts
     */
    public static String convertScandicsToBibText(String convertee) {
        for (CharSequence cs : charAndReplacement.keySet()) {
            convertee = convertee.replace(cs, charAndReplacement.get(cs));
        }
        return convertee;
    }
}
