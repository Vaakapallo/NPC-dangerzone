import textUI.*
import ambassador.*

description 'Käyttäjä voi tallentaa käyttämänsä viitteet'

scenario "Käyttäjä haluaa tallentaa lisäämänsä viitteet", {
    given 'Käyttäjä on lisännyt viitteitä', {
        String[] input = ["1","Tag","Mr. Tag", "EasyB made Easy", "Frustrations of a CS Student", "2012", "2","9","4","3"]
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

scenario "Käyttäjä haluaa tallentaa viitteitä, muttei ole lisännyt niitä", {
    given 'Käyttäjä ei ole lisännyt viitteitä'
    when 'Käyttäjä valitsee tallenna viitteet'
    then 'Käyttäjälle ilmoitetaan että viitteet on lisättävä aluksi'
}