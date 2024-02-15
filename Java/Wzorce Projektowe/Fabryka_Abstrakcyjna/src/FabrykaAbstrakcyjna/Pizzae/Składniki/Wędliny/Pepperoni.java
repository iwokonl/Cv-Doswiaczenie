package FabrykaAbstrakcyjna.Pizzae.Składniki.Wędliny;

public class Pepperoni implements Wędliny{
    public Pepperoni() {

    }

    @Override
    public Wędliny zróbWędliny() {
        return new Pepperoni();
    }

    @Override
    public String getNazwa() {
        return "Pepperoni";
    }
}
