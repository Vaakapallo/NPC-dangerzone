import NPCBibtexter.*

description 'Käyttäjä voi tallentaa käyttämänsä viitteet'

scenario "Käyttäjä haluaa tallentaa lisäämänsä viitteet", {
    given 'Käyttäjä on lisännyt viitteitä'
    when 'Käyttäjä valitsee tallenna viitteet'
    then 'Tuloksena tiedosto, jossa tiedot on kivasti BibTextinä'
}

scenario "Käyttäjä haluaa tallentaa viitteitä, muttei ole lisännyt niitä", {
    given 'Käyttäjä ei ole lisännyt viitteitä'
    when 'Käyttäjä valitsee tallenna viitteet'
    then 'Käyttäjälle ilmoitetaan että viitteet on lisättävä aluksi'
}