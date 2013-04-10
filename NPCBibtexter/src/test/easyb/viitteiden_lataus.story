import textUI.*

description 'Käyttäjä voi tallentaa käyttämänsä viitteet'

scenario "Käyttäjä lisää year -viitteen ja saa kivan Bibtext-viitteen ", {
    given 'Käyttäjä on lisännyt viitteitä'
    when 'Käyttäjä valitsee tallenna viitteet'
    then 'Tuloksena tiedosto, jossa tiedot on kivasti BibTextinä'
}
