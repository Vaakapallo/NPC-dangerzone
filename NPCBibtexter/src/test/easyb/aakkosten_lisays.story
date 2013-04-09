import NPCBibtexter.*

description 'Käyttäjä voi käyttää ääkkösiä viitteissään'

scenario "Käyttäjä käyttää skandinaaveja", {
    given 'Käyttäjä syöttää ä kirjaimen viitteeseen'
    when 'Käyttäjä on syöttänyt kirjaimen'
    then 'Tuloksena BibText -viite, jossa ä on kivasti muotoiltu'
}