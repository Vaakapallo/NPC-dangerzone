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

    /**
     * Hoitaa viitteiden lisäykseen siirtymisen
     */
    public void addReference();

    /**
     * Hoitaa viitteiden tallentamiseen siirtymisen
     */
    public void saveReferences();

    /**
     * Hoitaa viitteiden tulostamiseen siirtymisen
     */
    public void printReferences();
}
