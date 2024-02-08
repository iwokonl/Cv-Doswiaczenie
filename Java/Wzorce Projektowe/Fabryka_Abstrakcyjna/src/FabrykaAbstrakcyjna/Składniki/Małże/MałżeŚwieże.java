package FabrykaAbstrakcyjna.Składniki.Małże;

public class MałżeŚwieże implements Małże{
    @Override
    public Małże zróbMałże() {
        return new MałżeŚwieże();
    }

    public MałżeŚwieże() {
    }

    @Override
    public String getNazwa() {
        return "Małże Świeże";
    }
}
