# OOP-2.ryhmatoo
Objektorienteeritud programmeerimine LTAT.03.003 2.rühmatöö
Autorid: Adele Tasa, Annabel Jürjenson

**Projekti kirjeldus ja kasutusjuhend**

Meie programmi eesmärk on pakkuda kasutajale kerget aktsiaturu simulatsiooni. Kasutaja saab kasutajaliideses sisestada oma nime, algakpitali ja soovitud eesmärgi (tootluse), valida nimekirjast soovitud aktsia ning osta soovi korral mitu aktsiat. Seejärel saab kasutaja valida, kas ta soovib viie või kolmekümne päevajooksul simuleerida aktsiahinna muutmist. Programm näitab iga päeva kohta aktsia hinda, kasutaja portfelli väärtust, muutust alates investeerimise algusest ja tootlust protsentides ning lõpus annab teada, kas soovitud eesmärk sai täidetud.
Aktsiate andmed loetakse failist "aktsiad.txt". Mängu käiku on võimalik salvestada logifaili "mangu_logi.txt" ning hiljem uuesti laadida.

1. Käivita programm peaklassis.
2. Sisesta oma nimi, algkapital ja soovitud tootlus.
3. Vali rippmenüü nimekirjast endale sobiva hinna ja riskiastmega aktsia.
4. Vali, mitu aktsiat soovid osta ja soorita ost nupuga 'Osta' või klaviatuurilt 'Enter' klahviga.
5. Vali, kas simulatsioon kestab viis või kolmkümmend päeva.
6. Paremal mängu käigu alal saad vaadata päevade tulemusi ja lõpptulemust.
7. Soovi korral saab logi salvestada nupuga 'Salvesta logi' või klahvikombinatsiooniga 'Ctrl + S'.
8. Soovi korral saab salvestatud logi laadida nupuga 'Laadi logi' või klahvikombinatsiooniga 'Ctrl + L'.


**Klasside eesmärgid ja olulisemad meetodid**

Meil on kokku põhiliselt neli klassi: Aktsia, Peaklass, Portfell ja Turu.

### Aktsia
Aktsia klass hoiab ühe väärtpaberi andmeid (nimi, hind ja volatiilsust). 
Meetod 'uuendaHinda(double muutusProtsent)' arvutab aktsiale uue hinna. Meetod tagab, et turuhind ei langeks alla ühe sendi.

### Peaklass TODO
Peaklass loob JavaFX graafilise kasutajaliidese ja seob ülejäänud klassid tervikuks. Selles klassis toimub kasutaja sisendi lugemine, nuppudele reageerimine, simultasiooni käivitamine, logi kuvamine ja failidega töötamine. Programm loeb aktsiate andmed failist 'aktsiad.txt' ja salvestab mängu käigu faili 'mangu_logi.txt'
Meetod 'start(Stage lava)' loob programmi akna ja kasutajaliidese.
**LISADA MEETODEID VEEL**

### Portfell
Portfell klass haldab mängija raha ja ostetud aktsiate arvu. 
Meetod 'osta(int kogus, double hind)' kontrollib, kas kasutajal on piisavalt raha, et osta sisestatud kogus aktsiaid, kui raha on piisavalt vähendab vaba raha ja suurendab aktsiate kogust.
Meetod 'arvutaVäärtus(double hind)' arvutab portfelli koguväärtuse ehk vaba raha ja aktsiaväärtuste hetkesummat.

### Turu
Turu klass simuleerib aktsiaturu liikumist. Iga simulatsioonipäeva jaoks tekib juhuslik muutus, sest aktsia hinnad võivad nii tõusta kui ka langeda. 
Meetod 'randomMuutus(double volatiilsus)' loob juhusliku protsentuaalse muutuse aktsia hinnale. Volatiilsus näitab, mis riskiastmega mingi aktsia on. Väikse volatiilsuse korral hind muutub vähe, aga suure volatiilsusega hind võib rohkem tõusta või langeda. Meetod tagastab arvu vahemikus -risk kuni +risk.

### Launcher
Launcher klassi eesmärk on programmi käivitamine. See käivitab JavaFX rakenduse.
