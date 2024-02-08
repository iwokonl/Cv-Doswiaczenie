package FabrykaAbstrakcyjna.Składniki.Ciasto;

public class Cienkie implements Ciasto{
    public Cienkie() {
    }

    @Override
    public Ciasto zróbCiasto() {
        return new Cienkie();
    }

    @Override
    public String getNazwa() {
        return "Ciasto cienkie";
    }
}
