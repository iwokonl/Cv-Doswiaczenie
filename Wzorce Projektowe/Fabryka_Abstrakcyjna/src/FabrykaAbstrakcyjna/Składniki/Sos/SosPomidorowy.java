package FabrykaAbstrakcyjna.Składniki.Sos;

import FabrykaAbstrakcyjna.Składniki.Ser.Ser;

public class SosPomidorowy implements Sos {
    @Override
    public Sos zróbSos() {
        return new SosPomidorowy();
    }

    public SosPomidorowy() {
    }

    @Override
    public String getNazwa() {
        return "Sos pomidorowy";
    }
}
