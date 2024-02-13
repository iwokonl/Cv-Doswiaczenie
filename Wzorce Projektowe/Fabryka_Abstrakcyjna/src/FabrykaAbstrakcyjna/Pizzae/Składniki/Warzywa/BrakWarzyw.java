package FabrykaAbstrakcyjna.Pizzae.Składniki.Warzywa;

public class BrakWarzyw implements Warzywa{
    @Override
    public Warzywa zróbWarzywa() {
        return new BrakWarzyw();
    }

    @Override
    public String getNazwa() {
        return "";
    }
}
