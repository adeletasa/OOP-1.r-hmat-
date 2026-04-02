import java.util.Random;

public class Turu {
    private Random random = new Random();

    public double randomMuutus(double volatiilsus) {
        // valem teeb muutuse vahemikus [-risk, +risk]
        return (random.nextDouble() * 2 * volatiilsus) - volatiilsus;
    }
}