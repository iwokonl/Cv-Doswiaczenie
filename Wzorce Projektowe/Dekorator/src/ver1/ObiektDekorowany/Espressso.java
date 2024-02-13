package ver1.ObiektDekorowany;

import ver1.Napój;

public class Espressso extends Napój {
    public Espressso(){
        ustawOpis("Kawa Espresso");
    }
    @Override
    public double koszt() {
        return 6.49;
    }
}
