package FabrykaAbstrakcyjna.Pizzae.Składniki.Małże;

public class BrakMałży implements Małże{
    @Override
    public Małże zróbMałże() {
        return new BrakMałży();
    }

    @Override
    public String getNazwa() {
        return "";
    }
}
