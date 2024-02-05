package ver2;

public class PosypkaDeluxe implements NapójInterfejs{
    private NapójInterfejs napójInterfejs;
    public PosypkaDeluxe(NapójInterfejs napójInterfejs){
        this.napójInterfejs = napójInterfejs;

    }
    @Override
    public String opis() {
        return napójInterfejs.opis() + ", cudowna posypka";
    }

    @Override
    public double cena() {
        return napójInterfejs.cena() + 21.37;
    }
}
