import textUI.*
import ambassador.*

description 'Käyttäjä voi tallentaa ja ladata käyttämänsä viitteet'

scenario "Käyttäjä haluaa tallentaa lisäämänsä viitteet", {
    given 'Käyttäjä on lisännyt viitteitä', {
        String[] input = ["1", "1", "Tag","Mr. Tag", "EasyB made Easy", "Frustrations of a CS Student", "2012", "e" "2", "2", "9"]
        io = new IOStub(input)
        writer = new Bibwriter("test.bib") 
        UI = new TextUI(io)
    }
    when 'Käyttäjä valitsee tallenna viitteet', {
        UI.run()
    }
    then 'Tuloksena tiedosto, jossa tiedot on kivasti BibTextinä', {
        writer.readAndListReferences().shouldHave("Frustrations of a CS Student")
        writer.readAndListReferences().shouldHave("EasyB made Easy")
    }
}

scenario "Käyttäjä lataa viitteen tiedostosta", {
    given 'Käyttäjä on lisännyt viitteitä', {
        String[] input = ["4","3","9"]
        io = new IOStub(input)
        writer = new Bibwriter("test.bib")
        UI = new TextUI(io)
    }

    when 'Käyttäjä valitsee lataa ja tulsota viitteet ohjelman uudelleen', {
        UI.run()
    }

    then 'Ohjelma tulostaa lisätyt tiedot BibTextinä', {
        io.getOutput().shouldHave("Frustrations of a CS Student")
        io.getOutput().shouldHave("EasyB made Easy")
    }
}