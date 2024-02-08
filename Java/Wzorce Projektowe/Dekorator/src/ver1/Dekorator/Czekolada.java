package ver1.Dekorator;

import ver1.Napój;
import ver1.SkładnikDekorator;

public class Czekolada extends SkładnikDekorator {
    public Czekolada(Napój napój) {
        this.napój = napój;
    }

    public String pobierzOpis(){
        return napój.pobierzOpis() + ", czekolada";
    }
    @Override
    public double koszt() {
        return napój.koszt() + 1.10;
    }
}
