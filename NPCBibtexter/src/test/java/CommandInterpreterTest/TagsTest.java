/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandInterpreterTest;

import CommandInterpreter.AddTag;
import CommandInterpreter.DeleteTag;
import CommandInterpreter.PrintTags;
import Entries.Entry;
import applicationLogic.Build;
import applicationLogic.EntryStorage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import textUI.IOStub;

/**
 *
 * @author lassi
 */
public class TagsTest {

    private Entry entry;
    private IOStub io;

    public TagsTest() {
    }

    @Before
    public void setUp() {
        entry = Build.Inproceedings("Hurjaa, Monkel", "Olipa kerran Patu", "Tarinoita", 2012);
        EntryStorage.addEntry(entry);

    }

    @After
    public void tearDown() {
        EntryStorage.empty();
    }

    @Test
    public void addTagAddsATagToEntry() {
        io = new IOStub("tonk");
        new AddTag(io, entry).run();
        assertTrue(entry.tagExists("tonk"));
    }

    @Test
    public void addingTwicAddsTwoTagsToEntry() {
        io = new IOStub("tonk", "honk");
        new AddTag(io, entry).run();
        new AddTag(io, entry).run();
        assertTrue(entry.tagExists("tonk"));
        assertTrue(entry.tagExists("honk"));
    }

    @Test
    public void removingTagFromTaglessEntryFails() {
        io = new IOStub("shonk");
        new DeleteTag(io, entry).run();
        assertTrue(io.outputAsString().contains("Tagin poistaminen epäonnistui!"));
    }

    @Test
    public void removingOnlyTagOnEntryWorks() {
        io = new IOStub("shonk", "shonk");
        new AddTag(io, entry).run();
        new DeleteTag(io, entry).run();
        assertTrue(io.outputAsString().contains("Tagi poistettu!"));
        assertFalse(entry.tagExists("shonk"));
    }

    @Test
    public void removingOneTagFromManyWorks() {
        io = new IOStub("shonk", "tonk", "tonk");
        new AddTag(io, entry).run();
        new AddTag(io, entry).run();
        new DeleteTag(io, entry).run();
        assertTrue(io.outputAsString().contains("Tagi poistettu!"));
        assertTrue(entry.tagExists("shonk"));
        assertFalse(entry.tagExists("tonk"));
    }

    @Test
    public void removingNonexistentTagFromManyFails() {
        io = new IOStub("shonk", "tonk", "shonkodonk");
        new AddTag(io, entry).run();
        new AddTag(io, entry).run();
        new DeleteTag(io, entry).run();
        assertTrue(io.outputAsString().contains("Tagin poistaminen epäonnistui!"));
        assertTrue(entry.tagExists("shonk"));
        assertTrue(entry.tagExists("tonk"));
    }

    @Test
    public void printTagsPrintsNoTagsIfThereIsNone() {
        io = new IOStub("a");
        new PrintTags(io, entry).run();
        assertTrue(io.outputAsString().contains("Viitteellä ei ole tageja"));
    }
}