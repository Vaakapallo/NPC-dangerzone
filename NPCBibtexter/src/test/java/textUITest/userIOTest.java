/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package textUITest;

import applicationLogic.EntryStorage;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import textUI.userIO;

/**
 *
 * @author Cobrelli
 */
public class userIOTest extends TestCase {

    userIO io;
    private final ByteArrayOutputStream outContent;

    public userIOTest() {
        io = new userIO();
        outContent = new ByteArrayOutputStream();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        EntryStorage.empty();
    }

    public void testPrintLinePrintRightContent() {
        io.printLine("toimii");
        assertTrue(outContent.toString().contains("toimii"));
    }

    public void testPrintLineChangeWorks() {
        io.printLineChange();
        assertTrue(outContent.toString().contains(""));
    }
}
