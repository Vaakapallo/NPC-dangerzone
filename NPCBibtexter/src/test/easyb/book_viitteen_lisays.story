import textUI.*

description 'Käyttäjä voi lisätä book viitteen'

scenario "Käyttäjä lisää Book-viitteen ja saa sen BibTex-muodossa ", {
    given 'Käyttäjä valitsee lisää viite ja syöttää tiedot', {
        String[] input = ["1", "2", " ","Mr. Henderson", "Adding Books", "NextPracticeConsulting", "2013", "e", "9"]
        io = new IOStub(input)
        UI = new TextUI(io)
    }

    when 'Käyttäjä syöttää oikeat tiedot', {
        UI.run()
    }

    then 'Käyttäjä saa kivan Bibtext-viitteen', {
        io.getOutput().shouldHave("@Book")
        io.getOutput().shouldHave("Adding Books")
        io.getOutput().shouldHave("publisher = {NextPracticeConsulting}")
    }
}