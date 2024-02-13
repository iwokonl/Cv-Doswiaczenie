package FabrykaAbstrakcyjna.Składniki.Warzywa;

public class Pomidor implements Warzywa{
    public Pomidor() {
    }

    @Override
    public Warzywa zróbWarzywa() {
        return new Pomidor();
    }

    @Override
    public String getNazwa() {
        return "Pomidor";
    }
}
