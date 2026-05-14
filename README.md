# OOP-2.ryhmatoo
Objektorienteeritud programmeerimine LTAT.03.003 2.rühmatöö
Autorid: Adele Tasa, Annabel Jürjenson

**Projekti kirjeldus ja kasutusjuhend**

Meie programmi eesmärk on pakkuda kasutajale kerget aktsiaturu simulatsiooni. Kasutaja saab kasutajaliideses sisestada oma nime, algakpitali ja soovitud eesmärgi (tootluse), valida nimekirjast soovitud aktsia ning osta soovi korral mitu aktsiat. Seejärel saab kasutaja valida, kas ta soovib viie või kolmekümne päevajooksul simuleerida aktsiahinna muutmist. Programm näitab iga päeva kohta aktsia hinda, kasutaja portfelli väärtust, muutust alates investeerimise algusest ja tootlust protsentides ning lõpus annab teada, kas soovitud eesmärk sai täidetud.
Aktsiate andmed loetakse failist `aktsiad.txt`. Mängu käiku on võimalik salvestada logifaili `mangu_logi.txt` ning hiljem uuesti laadida.

1. Käivita programm peaklassis.
2. Sisesta oma nimi, algkapital ja soovitud tootlus.
3. Vali rippmenüü nimekirjast endale sobiva hinna ja riskiastmega aktsia.
4. Vali, mitu aktsiat soovid osta ja soorita ost nupuga `Osta` või klaviatuurilt `Enter` klahviga.
5. Vali, kas simulatsioon kestab viis või kolmkümmend päeva.
6. Paremal mängu käigu alal saad vaadata päevade tulemusi ja lõpptulemust.
7. Soovi korral saab logi salvestada nupuga `Salvesta logi` või klahvikombinatsiooniga `Ctrl + S`.
8. Soovi korral saab salvestatud logi laadida nupuga `Laadi logi` või klahvikombinatsiooniga `Ctrl + L`.


**Klasside eesmärgid ja olulisemad meetodid**

Meil on kokku põhiliselt neli klassi: Aktsia, Peaklass, Portfell ja Turu.

### Aktsia
Aktsia klass hoiab ühe väärtpaberi andmeid (nimi, hind ja volatiilsust). 
Meetod `uuendaHinda(double muutusProtsent)` arvutab aktsiale uue hinna. Meetod tagab, et turuhind ei langeks alla ühe sendi.

### Peaklass

Peaklass on programmi põhiline klass, kus luuakse JavaFX kasutajaliides ja pannakse ülejäänud klassid koos tööle. Siin toimub kasutaja sisendi lugemine, aktsiate ostmine, simulatsiooni käivitamine, logi kuvamine ning faili lugemine ja kirjutamine. Aktsiate andmed loetakse failist `aktsiad.txt` ja mängu logi salvestatakse faili `logi.txt`.

Meetod `start(Stage lava)` loob programmi akna, kasutajaliidese elemendid ja määrab nuppude tegevused.
Meetod `laeAktsiad(String f)`loeb aktsiate andmed failist ja loob nende põhjal Aktsia objektid.
Meetod `alustaSimulatsiooni(...)` kontrollib, kas kasutaja on aktsiaid ostnud, ning käivitab simulatsiooni.
Meetod `Simuleeri(...)` muudab aktsia hinda valitud päevade jooksul ja lisab tulemused logisse.
Meetod `salvestaFaili()`salvestab mängu logi faili `logi.txt`.
Meetod `loeFailist()`loeb varem salvestatud logi failist `logi.txt`.

### Portfell
Portfell klass haldab mängija raha ja ostetud aktsiate arvu. 
Meetod `osta(int kogus, double hind)` kontrollib, kas kasutajal on piisavalt raha, et osta sisestatud kogus aktsiaid, kui raha on piisavalt vähendab vaba raha ja suurendab aktsiate kogust.
Meetod `arvutaVäärtus(double hind)` arvutab portfelli koguväärtuse ehk vaba raha ja aktsiaväärtuste hetkesummat.

### Turu
Turu klass simuleerib aktsiaturu liikumist. Iga simulatsioonipäeva jaoks tekib juhuslik muutus, sest aktsia hinnad võivad nii tõusta kui ka langeda. 
Meetod `randomMuutus(double volatiilsus)` loob juhusliku protsentuaalse muutuse aktsia hinnale. Volatiilsus näitab, mis riskiastmega mingi aktsia on. Väikse volatiilsuse korral hind muutub vähe, aga suure volatiilsusega hind võib rohkem tõusta või langeda. Meetod tagastab arvu vahemikus -risk kuni +risk.

### Launcher
Launcher klassi eesmärk on programmi käivitamine. See käivitab JavaFX rakenduse.


**Projekti tegemise protsessi kirjeldus**

Alguses arutasime, kas jätkame sama teemaga nagu esimeses rühmatöös või valime täiesti uue teema. Lõpuks otsustasime jätkata aktsiaturu simulatsiooni ideega.
Tegime IntelliJ-s uue projekti ning kopeerisime vajalikud klassid sinna üle. Seejärel muutsime klasside alguses olevad package read nii, et need asuksid paketis `com.example.ryhmatoo2`. Esimesena keskendusime sellele, et programmi põhiloogika töötaks uues projektis korrektselt.
Seejärel hakkasime Peaklassis looma JavaFX kasutajaliidest. Alguses lisasime kõige olulisemad osad (tekstiväljad, aktsia valiku, nupud ja logiala). Esialgu tegime kujunduse väga lihtsana otse Peaklassis, et oleks lihtsam kontrollida, kas programm töötab. Hiljem otsustasime välimuse osa eraldi läbi mõelda ja tõsta kujunduse CSS-faili, et programmi loogika ja kasutajaliidese kujundus oleksid üksteisest paremini eraldatud.
Lõpus lisasime ja kontrollisime veateateid, klaviatuurisündmusi, logi salvestamist ja laadimist. Kõige viimases etapis tegelesime vigade parandamisega, kujunduse lõpliku viimistlemisega ning kontrollisime üle, et failist lugemine ja faili kirjutamine töötaksid korrektselt.

**Tehisintellekti kasutamise kirjeldus**
Tehisintellekti kasutasime abivahendina peamiselt JavaFX kasutajaliidese ülesehituse parandamiseks, koodivigade leidmiseks ja meetodite ülesehituseks. Kõige lõpus viimistlesime peaklassi Gemini abil.

**Rühmaliikmete panused ja ajakulu**

Alguses me planeerisime üldist ideed koos. Mõlemad katsetasime erinevaid lahendusi ning lõpliku versiooni panime kokku mõlema ideedest.

Annabel panustas peaklassi meetodite kirjutamisesse, kasutajaliidese viimistlemisse ja programmi loogika arendamisesse ning et erinevad programmi osad omavahel töötaksid.
Adele panustas peaklassi meetodite kirjutamisesse, dokumentatsiooni koostamisse ja programmi testimisse, kontrollimisse, et nupud, sisendväljad, veateated ning logide salvestamine ja laadimine töötaksid. 

Mõlemad rühmaliikmed panustasid projekti tegemisse ligikaudu võrdselt. Iseseisvalt kulus kummalgi umbes kaks kuni kolm tundi ning koos kulus meil arutamisele, parandamisele ja lõplikule viimistlusele umbes viis tundi.

**Tegemise mured**

Alguses tahtsime aktsiate andmeid võtta otse internetist web scraping’u abil, aga me ei osanud seda veel piisavalt hästi teha. See tundus meie jaoks üsna keeruline, eriti kuna samal ajal oli vaja tööle saada ka JavaFX kasutajaliides ja kogu programmi põhiloogika. Sellepärast otsustasime lõpuks teha kindlama lahenduse ja lugeda aktsiate andmed failist `aktsiad.txt`.

Teine keerulisem osa oli JavaFX kasutajaliidese sidumine programmi loogikaga. Aega võttis see, et nupud, tekstiväljad, simulatsioon, veateated ning logi salvestamine ja laadimine töötaksid kõik omavahel õigesti.

**Hinnang oma töö lõpptulemusele**

Jäime lõpptulemusega rahule, sest saime programmi tööle ning kõik nõuded tunduvad täidetud. Programmil on JavaFX graafiline kasutajaliides, see reageerib nii hiire kui ka klaviatuuri sündmustele, loeb andmeid failist, kirjutab logi faili ning koosneb mitmest klassist.

Hästi õnnestus programmi üldine ülesehitus ja see, et iga klass vastutab kindla osa eest. Arendamist vajaks tulevikus see, et kasutaja saaks ühe mängu jooksul müüa aktsiaid ja näha täpsemat statistikat.

**Testimine**

Testisime programmi nii osade kaupa kui ka tervikuna. Alamklasse me ei testinud, sest me ei muutnud neid välja arvatud Aktsia klass, sest meil oli seal hardcode'tud viga sees esimesest rühmatööst.

Testisime järgmisi olukordi:
1. kasutaja sisestab nime, algkapitali, tootluse ja koguse ning ostab aktsiaid.
2. kasutaja proovib osta rohkem aktsiaid, kui raha võimaldab.
3. kasutaja jätab nime sisestamata.
4. kasutaja sisestab raha või tootluse asemele teksti.
5. kasutaja proovib simuleerida enne aktsiate ostmist.
6. kasutaja käivitab viie päeva simulatsiooni.
7. kasutaja käivitab kolmekümne päeva simulatsiooni.
8. logi salvestamine töötab nupuga `Salvesta logi`.
9. logi salvestamine töötab klahvikombinatsiooniga `Ctrl+S`.
10. logi laadimine töötab nupuga `Laadi logi`.
11. logi laadimine töötab klahvikombinatsiooniga `Ctrl+L`.
12. kontrollisime, et `aktsiad.txt` puudumisel annab programm kasutajale arusaadava teate.

Veendusime, et programm töötab tavakasutuse korral korrektselt ja reageerib ka mitmele valele sisestusele mõistlikult.
