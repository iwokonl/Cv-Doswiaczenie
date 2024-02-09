package adapt;

public class BinAdapter implements Hex{
    Bin bin;
    public BinAdapter(Bin bin){
        this.bin = bin;
    }
    @Override
    public void wyświetlHex() {
        int temp = Integer.parseInt(bin.getBin());
        System.out.println(Integer.toHexString(temp));
    }

    @Override
    public void ustawHex(String bin) {

    }
    public Hex converted(){
        HexReal hexReal = new HexReal();
        hexReal.ustawHex(Integer.toHexString(Integer.parseInt(bin.getBin(),2)));
        return hexReal;
    }
    @Override
    public String getHex() {

        return Integer.toHexString(Integer.parseInt(bin.getBin(),2));
    }
}
