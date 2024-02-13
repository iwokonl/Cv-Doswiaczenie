package FabrykaAbstrakcyjna.Pizzae.Składniki.Ser;

public class BrakSera implements Ser{
    @Override
    public Ser zróbSer() {
        return new BrakSera();
    }

    @Override
    public String getNazwa() {
        return "";
    }
}
