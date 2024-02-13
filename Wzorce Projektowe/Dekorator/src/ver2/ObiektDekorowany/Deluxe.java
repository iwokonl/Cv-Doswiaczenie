package ver2.ObiektDekorowany;

import ver2.NapójInterfejs;

public class Deluxe implements NapójInterfejs {
    @Override
    public String opis() {
        return "Kawa deluxe";
    }

    @Override
    public double cena() {
        return 2137.0;
    }
}
