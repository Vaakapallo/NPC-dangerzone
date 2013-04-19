import textUI.*

description 'Käyttäjä voi käyttää ääkkösiä viitteissään'

scenario "Käyttäjä käyttää skandinaaveja", {
    given 'Käyttäjä syöttää ääkkösiä sisältäviä tietoja viitteeseen', {
        String[] input = ["1", "1", "tag","Mäyrä, Tero", "EasyB made Easy", "Frustrations of a CS Student", "2012", "e" "9"]
        io = new IOStub(input)
        UI = new TextUI(io)
    }

    when 'Käyttäjä on syöttänyt kirjaimen', {
        UI.run()
    }

    then 'Tuloksena BibText -viite, jossa ä on kivasti muotoiltu', {
        io.getOutput().shouldHave("@Inproceedings")
        io.getOutput().shouldHave("EasyB made Easy")
        io.getOutput().shouldHave("M\\\"{a}yr\\\"{a}, Tero")
    }
}