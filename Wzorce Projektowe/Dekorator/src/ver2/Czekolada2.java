package ver2;

public class Czekolada2 implements NapójInterfejs{
    private NapójInterfejs napójInterfejs;
    public Czekolada2(NapójInterfejs napójInterfejs){
        this.napójInterfejs = napójInterfejs;
    }
    @Override
    public String opis() {
        return napójInterfejs.opis() + ", z czekoladą";
    }

    @Override
    public double cena() {
        return napójInterfejs.cena() + 5.005;
    }
}
