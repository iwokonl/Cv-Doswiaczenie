package FabrykaAbstrakcyjna.Składniki.Sos;

import FabrykaAbstrakcyjna.Składniki.Ser.Ser;

public class BrakSosu implements Sos {
    @Override
    public Sos zróbSos() {
        return new BrakSosu();
    }

    @Override
    public String getNazwa() {
        return "";
    }
}
