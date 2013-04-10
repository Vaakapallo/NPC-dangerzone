import textUI.*
import ambassador.*

description 'Käyttäjä voi tallentaa käyttämänsä viitteet'

scenario "Käyttäjä lisää viitteen tiedot ja saa sen BibTex-muodossa ", {
    given 'Käyttäjä on lisännyt viitteitä', {
        String[] input = ["1","Tag","Mr. Tag", "EasyB made Easy", "Frustrations of a CS Student", "2012", "2","9","4","3","9"]
        io = new IOStub(input)
        writer = new Bibwriter("test.bib")
        UI = new TextUI(io)
    }

    when 'Käyttäjä valitsee tallenna viitteet ja käynnistää ohjelman uudelleen', {
        UI.run()
        UI.run()
    }

    then 'Tuloksena tiedosto, jossa tiedot on kivasti BibTextinä', {
        writer.readAndListReferences().shouldHave("Frustrations of a CS Student")
        writer.readAndListReferences().shouldHave("EasyB made Easy")
    }
}
