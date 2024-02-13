package FabrykaAbstrakcyjna.Pizzae.Składniki.Sos;

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
