import textUI.*
import stub.*

description 'Käyttäjä voi käyttää ääkkösiä viitteissään'

scenario "Käyttäjän antamassa kirjoittajan nimessä on skandinaaveja", {
    given 'Käyttäjä syöttää ääkkösiä sisältävän kirjoittajan nimen', {
        String[] input = ["1", "1", " ","Mäyrä, Tero", "EasyB made Easy", "Frustrations of a CS Student", "2012", "e" ,"9"]
        io = new IOStub(input)
        UI = new TextUI(io)
    }

    when 'Käyttäjä on syöttänyt kirjaimen', {
        UI.run()
    }

    then 'Tuloksena BibText -viite, jossa kirjoittaja on kivasti muotoiltu', {
        io.getOutput().shouldHave("@Inproceedings")
        io.getOutput().shouldHave("EasyB made Easy")
        io.getOutput().shouldHave("M\\\"{a}yr\\\"{a}, Tero")
    }
}

scenario "Käyttäjän antamassa kirjoituksen nimessä on skandinaaveja", {
    given 'Käyttäjä syöttää ääkkösiä sisältävän kirjoittajan nimen', {
        String[] input = ["1", "1", " ","Muuri, Tero", "Älyttömän hieno artikkeli", "Frustrations of a CS Student", "2012", "e" ,"9"]
        io = new IOStub(input)
        UI = new TextUI(io)
    }

    when 'Käyttäjä on syöttänyt kirjaimen', {
        UI.run()
    }

    then 'Tuloksena BibText -viite, jossa title on kivasti muotoiltu', {
        io.getOutput().shouldHave("@Inproceedings")
        io.getOutput().shouldHave("Muuri, Tero")
        io.getOutput().shouldHave("title = {\\\"{A}lytt\\\"{o}m\\\"{a}n hieno artikkeli}")
 
    }
}

scenario "Käyttäjän antamassa kirjan nimessä on skandinaaveja", {
    given 'Käyttäjä syöttää ääkkösiä sisältävän kirjan nimen', {
        String[] input = ["1", "1", " ","Mauri, Tero", "Aika hieno artikkeli", "Öinen kirjoituskokoelma", "2013", "e" ,"9"]
        io = new IOStub(input)
        UI = new TextUI(io)
    }

    when 'Käyttäjä on syöttänyt kirjaimen', {
        UI.run()
    }

    then 'Tuloksena BibText -viite, jossa title on kivasti muotoiltu', {
        io.getOutput().shouldHave("@Inproceedings")
        io.getOutput().shouldHave("Mauri, Tero")
        io.getOutput().shouldHave("booktitle = {\\\"{O}inen kirjoituskokoelma}")
 
    }
}
