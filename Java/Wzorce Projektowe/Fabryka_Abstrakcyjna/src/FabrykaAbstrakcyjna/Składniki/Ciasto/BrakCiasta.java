package FabrykaAbstrakcyjna.Składniki.Ciasto;

public class BrakCiasta implements Ciasto{
    @Override
    public Ciasto zróbCiasto() {
        return new BrakCiasta();
    }

    @Override
    public String getNazwa() {
        return "";
    }
}
