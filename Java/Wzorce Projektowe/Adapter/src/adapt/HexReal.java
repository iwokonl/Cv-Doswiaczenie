package adapt;

public class HexReal implements Hex{
    String Hex;
    @Override
    public void wyświetlHex() {
        System.out.println(this.Hex);
    }

    @Override
    public void ustawHex(String Hex) {
        this.Hex = Hex;
    }

    @Override
    public String getHex() {
        return this.Hex;
    }
}
