package FabrykaAbstrakcyjna.Pizzae.Składniki.Warzywa;

public class Papryka implements Warzywa{
    public Papryka() {

    }

    @Override
    public Warzywa zróbWarzywa() {
        return new Papryka();
    }

    @Override
    public String getNazwa() {
        return "Papryka";
    }
}
