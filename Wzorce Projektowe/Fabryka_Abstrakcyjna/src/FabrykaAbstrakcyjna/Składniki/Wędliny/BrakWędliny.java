package FabrykaAbstrakcyjna.Składniki.Wędliny;

public class BrakWędliny implements Wędliny{
    @Override
    public Wędliny zróbWędliny() {
        return new BrakWędliny();
    }

    @Override
    public String getNazwa() {
        return "";
    }
}
