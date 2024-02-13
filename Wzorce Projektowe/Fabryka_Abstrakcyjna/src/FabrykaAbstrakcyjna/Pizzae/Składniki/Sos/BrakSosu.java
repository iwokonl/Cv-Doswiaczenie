package FabrykaAbstrakcyjna.Pizzae.Składniki.Sos;

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
