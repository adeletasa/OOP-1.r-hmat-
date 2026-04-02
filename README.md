# OOP-1.ryhmatoo
Objektorienteeritud programmeerimine LTAT.03.003 1.rühmatöö 
Autorid: Adele Tasa, Annabel Jürjenson


iga rühmaliikme panus (sh tehtud klassid/meetodid) ja ajakulu (orienteeruvalt);
tegemise mured (nt millistest teadmistest/oskustest tundsite projekti tegemisel puudust);
hinnang oma töö lõpptulemusele (millega saite hästi hakkama ja mis vajab arendamist);
selgitus ja/või näited, kuidas programmi osi eraldi ja programmi tervikuna testisite ehk kuidas veendusite, et programm töötab korrektselt.


**Projekti kirjeldus ja kasutusjuhend**
Meie programmi eesmärk on pakkuda kasutajale arusaadavat ja lihtsat aktsiaturu simulatsiooni. Kasutaja saab proovida investeerimist, mis loetakse sisse välisest failist. Kasutaja näeb, kuidas juhuslikud turumuutused mõjutavad portfelli väärtust ajas.

Programm tervitab kasutajat ja loeb failis aktsiad.txt sisse nimekirja aktsiatest koos nende hindade ja riskitasemetega. Kasutaja sisestab oma nime ja algkapitali suuruse. Seejärel kuvatakse kasutajale nimekiri saadaval olevatest aktsiates, millest ta saab valida ühe aktsia numbri abil. Pärast soovitud koguse ostmist valib kasutaja simulatsiooni pikkuse, kas 5 päeva või 30 päeva. Programm genereerib iga päeva kohta uue aktsia hinna ning esitab lõpuks kokkuvõtte kasumist või kahjumist.

1. Käivita programm ja vajuta tervitusaknas nuppu "Hakkame pihta".
2. Sisesta oma nimi ja algkapital, mida soovid investeerida.
3. Vali nimekirjast endale sobiv aktsia ja sisesta rea number.
4. Sisesta kogus, kui palju soovid osta ning programm kontrollib, kas sul on selleks piisavalt raha.
5. Vali simulatsiooni periood, kas lühiajaline (5 päeva) või pikaajaline (30 päaeva).
6. Vaata enda tulemust ja vali, kas soovid proovida uuesti või lõpetada.


**Klasside eesmärgid ja olulisemad meetodid**
Meil on neli klassi: Aktsia, Portfell, Turu ja Peaklass.

Akstia klass hoiab konkreetse aktsia andmeid.
meetod uuendaHinda(double muutusProtsent) arvutab aktsiale uue turuhinna, samal ajal tagades, et aktsia hind ei langeks alla 0,01 euro. 

Portfell klass haldab kasutaja varalist seisu.
meetod osta(int kogus, double hind) kontrollib, kas kulu vastab vaba raha jäägile ja sooritab tehingu.
meetod arvutaVäärtus(double hind) arvutab kogu vara väärtuse ehk vaba raha + aktsiate turuväärtus.

Turu klass tegeleb turuliikumiste simuleerimisega.
meetod genereeriMuutus(double volatiilsus) kasutab klassi Random, et luua juhuslik protsentuaalne muutus negatiivsete ja positiivsete riskide vahel.

Peaklass on programmi käivitamiseks
meetod laeAktsiad(String fail) loeb andmed tekstifailist aktsiad.txt ja loob Aktsia objektidele listi.
meetod küsiNumbrit(...) kasutame sisendi küsimiseks, sest see sisaldab juba veatöötlust, et kui kasutaja sisestab vale sisendi, siis programm ei läheks katki/kinni.


**Protsessi tegemise kirjeldus**
Meie kõigepealt koos rääkisime ideedest, mis meil olid tekkinud ning valisime välja sobiva, Aktsia simulaator. Seejärel me arutasime kuidas täpsemalt peaks meie programm töötama, et see ei oleks meie jaoks liiga keeruline ja mõtlesime, milliseid klasse meil oleks vaja. Mõlemad kirjutasime oma versiooni programmist ning lõpuks panime need omavahel kokku võttes mõlema algversioonist ideid. Nüüd, kui meil oli üks programm, hakkasime seda täiustama.


**Rühmaliikmete panused**

**Tegemise mured**
**Hinnang oma töö lõpptulemusele**
Jäime lõpptulemusega rahule, sest programm täidab meie püstitatud eesmärgid ja on kasutaja jaoks lihtne kasutada. Saime hästi hakkama struktuuri loomisega, iga klass vastutab meie programmis kindla ülesande eest. Arenguruumi on veel palju, aga esimese rühmatöö jaoks tundub meile programm hea.


**Kuidas programmi osi eraldi ja tervikuna testisime**
Tegime vahepeal mitu erinevat testi.
Testisime Portfell klassi osta meetodit erinevate summadega, et näha kas see tagastab õigesti false, kui raha pole piisavalt.
Aktsiad.txt faili muutsime ka mitu korda, et veenduda,kas Peaklass suudab vigadeta andmeid sisse lugeda. 
Mängisime simulatsiooni läbi väga palju kordi, et veenduda, kas andmete laadimisel või kontrollides kalkulkaatoriga, kas on õige.


