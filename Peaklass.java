import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Dimension;

public class Peaklass {

    public static void main(String[] args) {
        // nupud JOptionPane liideseks
        Object[] nupp1 = {"Hakkame pihta"};
        Object[] nupp2 = {"Mängi uuesti", "Kinni"};

        // algne tervitus
        JOptionPane.showOptionDialog(null, "Tere! See on börsimäng.\nAndmed tulevad failist akstsiad.txt. \nEnnustamine toimub juhusliku riski protsendiga. \nProovi mängida.",
                "Mäng", 0, 1, null, nupp1, nupp1[0]);

        boolean kestab = true;

        // peamine while-tsükkel programmi töötamiseks
        while (kestab) {
            ArrayList<Aktsia> aktsiad = laeAktsiad("src/aktsiad.txt"); // laeb aktsiad failist

            if (aktsiad.isEmpty()) {
                break;
            }

            String nimi = küsiTeksti("Nimi:", "Andmed"); // küsib kasutajalt nime abimeetodiga
            if (nimi == null) {
                break;
            }

            double raha = küsiNumbrit("Palju raha on?", "Kapital"); // küsib kasutajalt raha abimeetodiga
            if (raha == -1) {
                break;
            }

            Portfell portfell = new Portfell(nimi, raha);
            Turu turu = new Turu();

            Aktsia aktsia = valiAktsia(aktsiad);
            if (aktsia == null) {
                break;
            }

            // küsib kasutajalt numbrit: mitu aktsiat osta soovib
            int kogus = (int) küsiNumbrit("Hind: " + aktsia.getHind() + "\nSinu raha: " + portfell.getVabaRaha() + "\n\nMitu ostad?", "Ost");

            if (kogus > 0) {
                if (!portfell.osta(kogus, aktsia.getHind())) { // kui osta meetodi == false, siis küsib uuesti kuni on true
                    JOptionPane.showMessageDialog(null, "Raha pole piisavalt.");
                }
            }

            Object[] ajad = {"5 päeva", "30 päeva"}; // saab valida kas 5 või 30 päeva ennustuseks
            int valik = JOptionPane.showOptionDialog(null, "Vali aeg:", "Aeg", 0, 3, null, ajad, ajad[0]);
            if (valik == -1) {
                break;
            }

            int päevi = 5;
            if (valik == 1) { // kui listis [1] siis valitud on 30 paeva
                päevi = 30;
            }

            double algus = portfell.arvutaVäärtus(aktsia.getHind());
            String tekst = "";

            for (int indeks = 1; indeks <= päevi; indeks++) {
                aktsia.uuendaHinda(turu.randomMuutus(aktsia.getVolatiilsus()));
                if (päevi <= 5 || indeks % 5 == 0 || indeks == päevi) {
                    tekst += "Päev " + indeks + ": " + Math.round(aktsia.getHind() * 100.0) / 100.0 + " EUR\n";
                }
            }

            double lõpp = portfell.arvutaVäärtus(aktsia.getHind());
            double tulemus = lõpp - algus;

            // arvutab kasumi/kahjumi ning näitab lõppraportit
            String raport = "KOKKUVÕTE: " + aktsia.getNimi() + "\n\n" + tekst +
                    "\nAlgus: " + Math.round(algus * 100.0) / 100.0 +
                    "\nLõpp: " + Math.round(lõpp * 100.0) / 100.0 +    // summade ümardamine
                    "\nVahe: " + Math.round(tulemus * 100.0) / 100.0;

            int lõppvalik = JOptionPane.showOptionDialog(null, raport, "Valmis", 0, 1, null, nupp2, nupp2[0]);
            if (lõppvalik != 0) {
                kestab = false;
            }
        }
    }

    // JOptionPane teksti jaoks abimeetod
    // kui vajutad "OK" saadab teksti edasi
    // kui paned X-st kinni, siis tagastab nulli
    private static String küsiTeksti(String kysimus, String pealkiri) {
        JTextField tekstiVäli = new JTextField();
        Object[] tekstiSisu = {kysimus, tekstiVäli};
        int väärtus = JOptionPane.showOptionDialog(null, tekstiSisu, pealkiri, 0, -1, null, new Object[]{"OK"}, "OK");
        if (väärtus == 0) {
            return tekstiVäli.getText();
        }
        return null;
    }

    // küsib numbri, abimeetod JOptionPane kasutamiseks
    // asendab komad punktidega, et programm ei läheks katki, kui kasutaja kirjutab punkti asemel koma
    // kasutab while-tsüklit vigade tuvastamiseks
    private static double küsiNumbrit(String kysimus, String pealkiri) {
        JTextField tekstiVäli = new JTextField();
        Object[] tekstiSisu = {kysimus, tekstiVäli};
        while (true) {
            int väärtus = JOptionPane.showOptionDialog(null, tekstiSisu, pealkiri, 0, -1, null, new Object[]{"OK"}, "OK");
            if (väärtus != 0) {
                return -1;
            }
            try {
                return Double.parseDouble(tekstiVäli.getText().replace(",", "."));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Sisesta number!");
            }
        }
    }

    // saab valida aktsiat listi indeksi abil
    private static Aktsia valiAktsia(ArrayList<Aktsia> list) {
        String tekstiSisu = "Vali aktsia number:\n";
        for (int indeks = 0; indeks < list.size(); indeks++) {
            tekstiSisu += (indeks + 1) + ". " + list.get(indeks).getNimi() + " (" + list.get(indeks).getHind() + ")\n";
        }
        JTextField tekstiVäli = new JTextField();
        Object[] sisu = {new JScrollPane(new JTextArea(tekstiSisu)), "Number:", tekstiVäli};
        int väärtus = JOptionPane.showOptionDialog(null, sisu, "Valik", 0, -1, null, new Object[]{"Vali"}, "Vali");
        if (väärtus == 0) { // kui väärtus 0, siis kasutaja vajutas nuppu "Vali"
            try {
                return list.get(Integer.parseInt(tekstiVäli.getText()) - 1); // võtab tekstikastist kasutaja sisestatud numbri
            } catch (Exception e) {
                return valiAktsia(list);
            }
        }
        return null; // kui kasutaja pani X-st kinni, returnib nulli
    }

    // loeb "aktsiad.txt" failist aktsiad
    private static ArrayList<Aktsia> laeAktsiad(String fail) {
        ArrayList<Aktsia> aktsiad = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(fail))) {
            while (sc.hasNextLine()) {
                String[] osad = sc.nextLine().split(",");
                if (osad.length == 3) {
                    aktsiad.add(new Aktsia(osad[0].trim(), Double.parseDouble(osad[1].trim()), Double.parseDouble(osad[2].trim())));
                }
            }
        } catch (Exception e) {
            System.out.println("Faili ei leitud");
        }
        return aktsiad;
    }
}