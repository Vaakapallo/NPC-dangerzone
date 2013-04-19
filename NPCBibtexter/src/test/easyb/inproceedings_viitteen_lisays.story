import textUI.*

description 'Käyttäjä voi lisätä inproceedings viitteen'

scenario "Käyttäjä lisää inproceedings-viitteen ja saa sen BibTex-muodossa ", {
    given 'Käyttäjä valitsee lisää viite ja syöttää tiedot', {
        String[] input = ["1", "1", "Tag","Mr. Tag", "EasyB made Easy", "Frustrations of a CS Student", "2012", "e", "9"]
        io = new IOStub(input)
        UI = new TextUI(io)
    }

    when 'Käyttäjä syöttää oikeat tiedot', {
        UI.run()
    }

    then 'Käyttäjä saa kivan Bibtext-viitteen', {
        io.getOutput().shouldHave("@Inproceedings")
        io.getOutput().shouldHave("EasyB made Easy")
    }
}