package adapt;

public class BinReal implements Bin{
    String bin;

    @Override
    public void wyświetlBin() {
        System.out.println(this.bin);
    }
@Override
    public String getBin() {
        return bin;
    }

    @Override
    public void ustawBin(String bin) {
        this.bin = bin;
    }
}
