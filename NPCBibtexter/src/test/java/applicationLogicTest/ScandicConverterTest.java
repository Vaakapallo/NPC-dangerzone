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
        assertEquals(ScandicConverter.convertScandicsToBibText("ä"), "\"{a}");
    }

    public void testSingleScandicOConversion() {
        assertEquals(ScandicConverter.convertScandicsToBibText("ö"), "\"{o}");
    }

    public void testMayra() {
        assertEquals(ScandicConverter.convertScandicsToBibText("Mäyrä"), "M\"{a}yr\"{a}");
    }

    public void testPolja() {
        assertEquals(ScandicConverter.convertScandicsToBibText("Pöljä"), "P\"{o}lj\"{a}");
    }
}
