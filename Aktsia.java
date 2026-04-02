public class Aktsia {
    private String nimi;
    private double hind;
    private double volatiilsus;

    public Aktsia(String nimi, double hind, double volatiilsus) {
        this.nimi = nimi;
        this.hind = hind;
        this.volatiilsus = volatiilsus; // volatiilsus - aktsia väärtuse kõikumine
    }

    public void uuendaHinda(double muutusProtsent) {
        // arvutame uue hinna
        this.hind = this.hind * (1 + muutusProtsent);
        // aktsia ei saa maksta vähem kui 1 sent
        if (this.hind < 0.01) this.hind = 0.01;
    }

    public String getNimi() {
        return nimi;
    }

    public double getHind() {
        return hind;
    }

    public double getVolatiilsus() {
        return volatiilsus;
    }
}