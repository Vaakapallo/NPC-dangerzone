package Fields;

/**
 * Supports Inproceedings for now.
 */
public class CiteKeyGen {
    
    public static String generateCitationKey(Author author, Year year, Title title) {
        String toReturn = "";
        String auth = author.getField().toLowerCase().trim();
        
        if (auth.length() < 6) {
            toReturn += auth;
        } else {
            toReturn += auth.substring(0, 6);
        }
        
        toReturn += year.getField();
        toReturn += "-";
        
        String tit = title.getField().toLowerCase().trim();
        
        if (tit.length() < 6) {
            toReturn += tit;
        } else {
            toReturn += tit.substring(0, 6);
        }
        
        return toReturn;
    }
}
