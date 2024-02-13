package ver2.ObiektDekorowany;

import ver2.NapójInterfejs;

public class Espresso implements NapójInterfejs {
    @Override
    public String opis() {
        return "Kawa Espresso";
    }

    @Override
    public double cena() {
        return 11.0;
    }
}
