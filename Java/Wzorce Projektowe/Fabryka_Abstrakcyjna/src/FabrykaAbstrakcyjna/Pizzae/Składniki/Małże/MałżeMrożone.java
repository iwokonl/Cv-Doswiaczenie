package FabrykaAbstrakcyjna.Pizzae.Składniki.Małże;

public class MałżeMrożone implements Małże{
    @Override
    public Małże zróbMałże() {
        return new MałżeMrożone();
    }

    public MałżeMrożone() {
    }

    @Override
    public String getNazwa() {
        return "Małże mrożone";
    }
}
