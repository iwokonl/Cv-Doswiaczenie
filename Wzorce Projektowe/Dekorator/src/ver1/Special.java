package ver1;

public class Special extends Napój{
    public Special(){
        ustawOpis("Specjalność firmy");
    }
    @Override
    public double koszt() {
        return 4.99;
    }
}
