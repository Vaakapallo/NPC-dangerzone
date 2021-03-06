import textUI.*
import stub.*

description 'Käyttäjä muokkaa Entryä'

scenario "Käyttäjä haluaa muokata Inproceedings -viitettä ilman vaihtoehtoisia kenttiä", {
    given 'Käyttäjä valitsee lisää viite ja syöttää tiedot ja päättää muokata syöttämiään', {
        String[] input = ["1", "1", "vesa", "jake","eki", "japi", "1992", "e", "5", "vesa", "vesa", "ekaj", "ike", "ipaj", "2991", "e", "9"]
        io = new IOStub(input)
        UI = new TextUI(io)
    }

    when 'Käyttäjä syöttää oikeat tiedot', {
        UI.run()
    }

    then 'Käyttäjä saa kivan Bibtext-viitteen', {
        io.getOutput().shouldHave("ike")
        io.getOutput().shouldHave("2991")
    }
}

scenario "Käyttäjä haluaa muokata Book -viitettä ilman vaihtoehtoisia kenttiä", {
    given 'Käyttäjä valitsee lisää viite ja syöttää tiedot ja päättää muokata syöttämiään', {
        String[] input = ["1", "2", "esa2", "jake","eki", "japi", "1992", "e", "5", "esa2", "esa2", "ekaj", "ike", "2991", "e", "9"]
        io = new IOStub(input)
        UI = new TextUI(io)
    }

    when 'Käyttäjä syöttää oikeat tiedot', {
        UI.run()
    }

    then 'Käyttäjä saa kivan Bibtext-viitteen', {
        io.getOutput().shouldHave("ike")
        io.getOutput().shouldHave("2991")
    }
}

scenario "Käyttäjä haluaa muokata Article -viitettä ilman vaihtoehtoisia kenttiä", {
    given 'Käyttäjä valitsee lisää viite ja syöttää tiedot ja päättää muokata syöttämiään', {
        String[] input = ["1", "3", "esa1", "jake","eki", "japi", "1992", "e", "5", "esa1", "esa1", "ekaj", "ike", "ipaj", "2991", "e", "9"]
        io = new IOStub(input)
        UI = new TextUI(io)
    }

    when 'Käyttäjä syöttää oikeat tiedot', {
        UI.run()
    }

    then 'Käyttäjä saa kivan Bibtext-viitteen', {
        io.getOutput().shouldHave("ike")
        io.getOutput().shouldHave("2991")
    }
}
