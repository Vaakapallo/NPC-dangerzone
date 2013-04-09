import NPCBibtexter.*

description 'Käyttäjä voi lisätä Article, Book tai Misc viitteen'

scenario "Käyttäjä lisää article -viitteen ja saa kivan Bibtext-viitteen ", {
    given 'Käyttäjä valitsee lisää viite ja syöttää article viitettä'
    when 'Käyttäjä syöttää oikeat tiedot'
    then 'Käyttäjä saa kivan Bibtext-viitteen'
}

scenario "Käyttäjä lisää article -viitteen väärillä tiedoilla ja saa huonon Bibtext-viitteen ", {
    given 'Käyttäjä valitsee lisää viite ja syöttää article viitettä'
    when 'Käyttäjä syöttää väärät tiedot'
    then 'Käyttäjä saa huonon Bibtext-viitteen'
}

scenario "Käyttäjä lisää book -viitteen ja saa kivan Bibtext-viitteen ", {
    given 'Käyttäjä valitsee lisää viite ja syöttää book viitettä'
    when 'Käyttäjä syöttää oikeat tiedot'
    then 'Käyttäjä saa kivan Bibtext-viitteen'
}

scenario "Käyttäjä lisää book -viitteen väärillä tiedoilla ja saa huonon Bibtext-viitteen ", {
    given 'Käyttäjä valitsee lisää viite ja syöttää book viitettä'
    when 'Käyttäjä syöttää väärät tiedot'
    then 'Käyttäjä saa huonon Bibtext-viitteen'
}

scenario "Käyttäjä lisää misc -viitteen ja saa kivan Bibtext-viitteen ", {
    given 'Käyttäjä valitsee lisää viite ja syöttää misc viitettä'
    when 'Käyttäjä syöttää oikeat tiedot'
    then 'Käyttäjä saa kivan Bibtext-viitteen'
}

scenario "Käyttäjä lisää misc -viitteen väärillä tiedoilla ja saa huonon Bibtext-viitteen ", {
    given 'Käyttäjä valitsee lisää viite ja syöttää misc viitettä'
    when 'Käyttäjä syöttää väärät tiedot'
    then 'Käyttäjä saa huonon Bibtext-viitteen'
}
