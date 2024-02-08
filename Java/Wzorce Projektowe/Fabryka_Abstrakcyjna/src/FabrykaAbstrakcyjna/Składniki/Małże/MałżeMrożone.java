package FabrykaAbstrakcyjna.Składniki.Małże;

import FabrykaAbstrakcyjna.Składniki.Ciasto.Ciasto;

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
