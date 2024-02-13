package FabrykaAbstrakcyjna.Składniki.Sos;

public class SosMarinara implements Sos{
    @Override
    public Sos zróbSos() {
        return new SosMarinara();
    }

    @Override
    public String getNazwa() {
        return "Sos marinara";
    }
}
