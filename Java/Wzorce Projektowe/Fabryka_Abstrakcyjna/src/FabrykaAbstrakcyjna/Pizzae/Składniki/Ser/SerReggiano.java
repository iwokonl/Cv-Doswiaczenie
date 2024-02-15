package FabrykaAbstrakcyjna.Pizzae.Składniki.Ser;

public class SerReggiano implements Ser{
    @Override
    public Ser zróbSer() {
        return new SerReggiano();
    }

    public SerReggiano() {
    }

    @Override
    public String getNazwa() {
        return "Ser reggiano";
    }
}
