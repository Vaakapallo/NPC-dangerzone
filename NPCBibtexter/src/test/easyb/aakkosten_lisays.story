import NPCBibtexter.*

description 'Käyttäjä voi käyttää ääkkösiä viitteissään'

scenario "Käyttäjä käyttää ä -kirjainta", {
    given 'Käyttäjä syöttää ä kirjaimen viitteeseen'
    when 'Käyttäjä on syöttänyt kirjaimen'
    then 'Tuloksena BibText -viite, jossa ä on kivasti muotoiltu'
}

scenario "Käyttäjä käyttää å -kirjainta", {
    given 'Käyttäjä syöttää å kirjaimen viitteeseen'
    when 'Käyttäjä on syöttänyt kirjaimen'
    then 'Tuloksena BibText -viite, jossa å on kivasti muotoiltu'
}

scenario "Käyttäjä käyttää ö -kirjainta", {
    given 'Käyttäjä syöttää ö kirjaimen viitteeseen'
    when 'Käyttäjä on syöttänyt kirjaimen'
    then 'Tuloksena BibText -viite, jossa ö on kivasti muotoiltu'
}

scenario "Käyttäjä käyttää Ä -kirjainta", {
    given 'Käyttäjä syöttää Ä kirjaimen viitteeseen'
    when 'Käyttäjä on syöttänyt kirjaimen'
    then 'Tuloksena BibText -viite, jossa Ä on kivasti muotoiltu'
}

scenario "Käyttäjä käyttää Å -kirjainta", {
    given 'Käyttäjä syöttää Å kirjaimen viitteeseen'
    when 'Käyttäjä on syöttänyt kirjaimen'
    then 'Tuloksena BibText -viite, jossa Å on kivasti muotoiltu'
}

scenario "Käyttäjä käyttää Ö -kirjainta", {
    given 'Käyttäjä syöttää Ö kirjaimen viitteeseen'
    when 'Käyttäjä on syöttänyt kirjaimen'
    then 'Tuloksena BibText -viite, jossa Ö on kivasti muotoiltu'
}