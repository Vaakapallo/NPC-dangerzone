import NPCBibtexter.*

description 'Käyttäjä voi lisätä inproceedings viitteen'

scenario "Käyttäjä lisää viitteen ja saa kivan Bibtext-viitteen ", {
    given 'Käyttäjä valitsee lisää viite'
    when 'Käyttäjä syöttää oikeat tiedot'
    then 'Käyttäjä saa kivan Bibtext-viitteen'
}