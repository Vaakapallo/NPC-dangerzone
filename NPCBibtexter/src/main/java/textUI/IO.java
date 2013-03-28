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
    public int read();
    
    public String readString();

    /**
     * Tulostaa System.out.Printin avulla halutun tekstin
     *
     * @param text Parametrinä annetaan tulostettava teksti
     */
    public void printSomething(String text);

    /**
     * Tulostaa rivinvaihdon
     */
    public void printLineChange();
}
