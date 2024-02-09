import adapt.BinAdapter;
import adapt.BinReal;
import adapt.HexReal;

public class Main {
    public static void main(String[] args) {
        BinReal binReal = new BinReal();
        binReal.ustawBin("00110011");
        binReal.wyświetlBin();
        BinAdapter binAdapter = new BinAdapter(binReal);
        System.out.println(binAdapter.getHex());
    }
}