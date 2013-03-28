/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogicTest;

import applicationLogic.ScandicConverter;
import junit.framework.TestCase;

/**
 *
 * @author lvapaaka
 */
public class ScandicConverterTest extends TestCase {

    public ScandicConverterTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    // TODO add test methods here. The name must begin with 'test'. For example:

    public void testSingleScandicAConversion() {
        assertEquals("\\\"{a}", ScandicConverter.convertScandicsToBibText("ä"));
    }

    public void testSingleScandicOConversion() {
        assertEquals("\\\"{o}", ScandicConverter.convertScandicsToBibText("ö"));
    }

    public void testSingleSwedishOConversion() {
        assertEquals("\\\"{aa}", ScandicConverter.convertScandicsToBibText("å"));
    }

    public void testMayra() {
        assertEquals("M\\\"{a}yr\\\"{a}", ScandicConverter.convertScandicsToBibText("Mäyrä"));
    }

    public void testAalio() {
        assertEquals("\\\"{A}\\\"{a}li\\\"{o}", ScandicConverter.convertScandicsToBibText("Ääliö"));
    }

    public void testPolja() {
        assertEquals("P\\\"{o}lj\\\"{a}", ScandicConverter.convertScandicsToBibText("Pöljä"));
    }

    public void testOland() {
        assertEquals("\\\"{AA}land", ScandicConverter.convertScandicsToBibText("Åland"));
    }

    public void testTorta() {
        assertEquals("T\\\"{aa}rta", ScandicConverter.convertScandicsToBibText("Tårta"));
    }

    public void testOljylaikka() {
        assertEquals("\\\"{O}ljyl\\\"{a}ikk\\\"{a}", ScandicConverter.convertScandicsToBibText("Öljyläikkä"));
    }

    public void testNames() {
        System.out.println(ScandicConverter.convertScandicsToBibText("Hassinen, Marko and Mäyrä, Hannu"));
        assertEquals("Hassinen, Marko and M\\\"{a}yr\\\"{a}, Hannu", ScandicConverter.convertScandicsToBibText("Hassinen, Marko and Mäyrä, Hannu"));
    }
}
