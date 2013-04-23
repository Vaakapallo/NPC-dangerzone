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

import static org.mockito.Mockito.*;

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

    public void testReadingIntegerWorks() {
        userIO mockIO = mock(userIO.class);
        when(mockIO.readInt()).thenReturn(5);

        int testattava = mockIO.readInt();

        assertEquals(5, testattava);
    }

    public void testReadingPossiblyEmptyIntegerWorks() {
        userIO mockIO = mock(userIO.class);
        when(mockIO.readPossiblyEmptyInt()).thenReturn(5);

        int testattava = mockIO.readPossiblyEmptyInt();

        assertEquals(5, testattava);
    }

    public void testReadingStringWorks() {
        userIO mockIO = mock(userIO.class);
        when(mockIO.readString()).thenReturn("toimii");

        String testattava = mockIO.readString();

        assertEquals("toimii", testattava);
    }

    public void testReadingPossiblyEmptyStringWorks() {
        userIO mockIO = mock(userIO.class);
        when(mockIO.readPossiblyEmptyString()).thenReturn("toimii");

        String testattava = mockIO.readPossiblyEmptyString();

        assertEquals("toimii", testattava);
    }
}
