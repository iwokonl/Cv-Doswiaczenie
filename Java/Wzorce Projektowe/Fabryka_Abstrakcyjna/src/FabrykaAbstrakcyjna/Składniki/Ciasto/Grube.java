package FabrykaAbstrakcyjna.Składniki.Ciasto;

public class Grube implements Ciasto{
    @Override
    public Ciasto zróbCiasto() {
        return new Grube();
    }

    public Grube() {
    }

    @Override
    public String getNazwa() {
        return "Ciasto cienkie";
    }
}
