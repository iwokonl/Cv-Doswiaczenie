package FabrykaAbstrakcyjna.Pizzae.Składniki.Ser;

public class SerMozzarella implements Ser{
    public SerMozzarella() {
    }

    @Override
    public Ser zróbSer() {
        return new SerMozzarella();
    }

    @Override
    public String getNazwa() {
        return "Ser mozzarella";
    }
}
