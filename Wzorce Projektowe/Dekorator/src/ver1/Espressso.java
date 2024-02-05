package ver1;

public class Espressso extends Napój{
    public Espressso(){
        ustawOpis("Kawa Espresso");
    }
    @Override
    public double koszt() {
        return 6.49;
    }
}
