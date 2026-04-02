public class Portfell {
    private String omanik;
    private double vabaRaha;
    private int aktsiateArv;

    public Portfell(String omanik, double vabaRaha) {
        this.omanik = omanik;
        this.vabaRaha = vabaRaha;
        this.aktsiateArv = 0;
    }

    public double arvutaVäärtus(double hind) {
        // liidab kokku sularaha ja aktsiate väärtuse turul
        return vabaRaha + (aktsiateArv * hind);
    }

    public boolean osta(int kogus, double hind) {
        double kulu = kogus * hind;
        if (kulu <= vabaRaha && kogus > 0) {
            vabaRaha -= kulu;
            aktsiateArv += kogus;
            return true;
        }
        return false;
    }

    public double getVabaRaha() {
        return vabaRaha;
    }
}