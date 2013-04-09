import NPCBibtexter.*

description 'Käyttäjä voi lisätä inproceedings viitteen'

scenario "Käyttäjä lisää year -viitteen ja saa kivan Bibtext-viitteen ", {
    given 'Käyttäjä valitsee lisää viite ja syöttää year viitettä'
    when 'Käyttäjä syöttää oikeat tiedot'
    then 'Käyttäjä saa kivan Bibtext-viitteen'
}

scenario "Käyttäjä lisää year -viitteen väärillä tiedoilla ja saa huonon Bibtext-viitteen ", {
    given 'Käyttäjä valitsee lisää viite ja syöttää year viitettä'
    when 'Käyttäjä syöttää väärät tiedot'
    then 'Käyttäjä saa huonon Bibtext-viitteen'
}

scenario "Käyttäjä lisää booktitle -viitteen ja saa kivan Bibtext-viitteen ", {
    given 'Käyttäjä valitsee lisää viite ja syöttää booktitle viitettä'
    when 'Käyttäjä syöttää oikeat tiedot'
    then 'Käyttäjä saa kivan Bibtext-viitteen'
}

scenario "Käyttäjä lisää booktitle -viitteen väärillä tiedoilla ja saa huonon Bibtext-viitteen ", {
    given 'Käyttäjä valitsee lisää viite ja syöttää booktitle viitettä'
    when 'Käyttäjä syöttää väärät tiedot'
    then 'Käyttäjä saa huonon Bibtext-viitteen'
}

scenario "Käyttäjä lisää author -viitteen ja saa kivan Bibtext-viitteen ", {
    given 'Käyttäjä valitsee lisää viite ja syöttää author viitettä'
    when 'Käyttäjä syöttää oikeat tiedot'
    then 'Käyttäjä saa kivan Bibtext-viitteen'
}

scenario "Käyttäjä lisää author -viitteen väärillä tiedoilla ja saa huonon Bibtext-viitteen ", {
    given 'Käyttäjä valitsee lisää viite ja syöttää author viitettä'
    when 'Käyttäjä syöttää väärät tiedot'
    then 'Käyttäjä saa huonon Bibtext-viitteen'
}

scenario "Käyttäjä lisää title -viitteen ja saa kivan Bibtext-viitteen ", {
    given 'Käyttäjä valitsee lisää viite ja syöttää title viitettä'
    when 'Käyttäjä syöttää oikeat tiedot'
    then 'Käyttäjä saa kivan Bibtext-viitteen'
}

scenario "Käyttäjä lisää title -viitteen väärillä tiedoilla ja saa huonon Bibtext-viitteen ", {
    given 'Käyttäjä valitsee lisää viite ja syöttää title viitettä'
    when 'Käyttäjä syöttää väärät tiedot'
    then 'Käyttäjä saa huonon Bibtext-viitteen'
}