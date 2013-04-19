package textUI;

/**
 * Interface tekstikäyttöliittymän riippuvuuksien poistoa varten
 *
 * @author vito
 */
public interface IO {

    /**
     * Lukee käyttöliittymälle Scannerilla uuden käskyn.
     *
     * @return Palauttaa käskyn numeron
     */
    public int readInt();
    
    public int readPossiblyEmptyInt();
    
    public String readString();
    
    public String readPossiblyEmptyString();

    /**
     * Tulostaa System.out.Printin avulla halutun tekstin
     *
     * @param text Parametrinä annetaan tulostettava teksti
     */
    public void printLine(String text);

    /**
     * Tulostaa rivinvaihdon
     */
    public void printLineChange();
}
