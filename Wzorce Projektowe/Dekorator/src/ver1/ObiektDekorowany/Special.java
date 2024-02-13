package ver1.ObiektDekorowany;

import ver1.Napój;

public class Special extends Napój {
    public Special(){
        ustawOpis("Specjalność firmy");
    }
    @Override
    public double koszt() {
        return 4.99;
    }
}
