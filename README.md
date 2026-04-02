# OOP-1.ryhmatoo
Objektorienteeritud programmeerimine LTAT.03.003 1.rühmatöö 
Autorid: Adele Tasa, Annabel Jürjenson

**Projekti kirjeldus ja kasutusjuhend**
Meie programmi eesmärk on pakkuda kasutajale interaktiivset ja lihtsat aktsiaturu simulatsiooni. Kasutaja saab proovida investeerimist virtuaalsetesse väärtpaberitesse, mille andmed loetakse sisse välisest tekstifailist. Kasutaja näeb, kuidas juhuslikud turumuutused mõjutavad portfelli väärtust ajas.

1. Käivita programm ja vajuta tervitusaknas nuppu "Hakkame pihta".
2. Sisesta oma nimi ja algkapital, mida soovid investeerida.
3. Vali nimekirjast endale sobiv aktsia sisestades vastava rea number.
4. Sisesta soovitud aktsiate kogus ning programm kontrollib, kas vaba jääk on selleks tehinguks piisav.
5. Vali simulatsiooni periood, kas lühiajaline (5 päeva) või pikaajaline (30 päaeva).
6. Programm genereerib iga päeva kohta uue hinna ja esitab lõppraporti. Vaata enda tulemust ja vali, kas soovid proovida uuesti või lõpetada.


**Klasside eesmärgid ja olulisemad meetodid**
Meil on neli klassi: Aktsia, Portfell, Turu ja Peaklass.

Akstia klass hoiab konkreetse väärtpaberi andmeid (nimi, hind, volatiilsus).
uuendaHinda(double muutusProtsent) arvutab aktsiale uue turuhinna, samal ajal tagades, et aktsia hind ei langeks alla 0,01 euro. 

Portfell klass haldab kasutaja varalist seisu.
osta(int kogus, double hind) kontrollib, kas kulu vastab vaba raha jäägile ja sooritab tehingu, kui raha on piisavalt.
arvutaVäärtus(double hind) arvutab kogu vara väärtuse (vaba raha + aktsiate turuväärtus).

Turu klass tegeleb turuliikumiste simuleerimisega.
randomMuutus(double volatiilsus) kasutab Random väärtust, et luua juhuslik protsentuaalne muutus negatiivsete ja positiivsete riskide vahel.

Peaklass tegeleb sisendi/väljundi ja ka kasutajaliidesega (JOptionPane)
laeAktsiad(String fail) loeb andmed tekstifailist aktsiad.txt ja loob Aktsia objektidele listi.
küsiNumbrit(...) kasutame numbriliste sisendi küsimiseks, sest see sisaldab juba veatöötlust, et kui kasutaja sisestab vale sisendi, siis programm ei läheks katki/kinni.


**Protsessi tegemise kirjeldus**
Projekti alguses arutasime läbi, mis ideed meil on tekkinud ja valisime nende seast välja aktsia simulaatori. Seejärel arutasime, milliseid klasse on meil vaja ja, mis ülesehitus võiks programmil olla.
Mõlemad kirjutasime oma versiooni programmist ning lõpuks panime need omavahel kokku parimaks tervikuks võttes mõlema algversioonist ideid. Annabeli algversioonist saime idee lugeda andmeid failist ja Adele algversioonist idee teha mitu erinevat investeerimisperioodide valikut.


**Rühmaliikmete panused**
Algfaasis planeerisime baasloogikat koos ja arutasime läbi klasside vahelised seosed. 
Annabel panustas lõppfaasis koodi lihvimisele ja meetodite optimeerimisele.
Adele tegeles projekti dokumentatsiooniga ja kasutajaliidese dialoogakende (JOptionPane) viimistlemisele.

**Tegemise mured**
Peamine mure ei olnud koodi kirjutamine vaid meie kogemused koostöös. Me ei teadnud, et IntelliJ "Code With Me" funktsioon on olemas, millega on võimalus samaaegselt koodi kirjutada. Raiskasime aega failide käsitsi ZIP-arhiivina saatmisele.

**Hinnang oma töö lõpptulemusele**
Jäime lõpptulemusega rahule, sest programm täidab meie püstitatud eesmärgid ja on kasutaja jaoks lihtne kasutada. Saime hästi hakkama struktuuri loomisega, iga klass vastutab meie programmis kindla ülesande eest. Arenguruumi on veel palju, aga esimese rühmatöö jaoks tundub meile programm hea.


**Kuidas programmi osi eraldi ja tervikuna testisime**
Tegime vahepeal mitu erinevat testi.
Testisime Portfell klassi osta meetodit erinevate summadega, et näha kas see tagastab õigesti false, kui raha pole piisavalt.
Aktsiad.txt faili muutsime ka mitu korda, et veenduda,kas Peaklass suudab vigadeta andmeid sisse lugeda. 
Mängisime simulatsiooni läbi väga palju kordi, et veenduda, kas andmete laadimisel või kontrollides kalkulkaatoriga, kas on õige.


