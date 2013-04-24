import textUI.*

description 'Käyttäjä lisää artikkelin ilman valinnaisia kenttiä'

scenario "Käyttäjä valitsee artikkelin lisäämisen", {
    given 'Käyttäjä valitsee lisää viite ja syöttää tiedot', {
        String[] input = ["1", "3", " ", "jake","eki", "japi", "1992", "e", "9"]
        io = new IOStub(input)
        UI = new TextUI(io)
    }

    when 'Käyttäjä syöttää oikeat tiedot', {
        UI.run()
    }

    then 'Käyttäjä saa kivan Bibtext-viitteen', {
        io.getOutput().shouldHave("jake")
        io.getOutput().shouldHave("@Article")
    }
}