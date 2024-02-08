package Dekorator;

public class BurgerVege implements BurgerInterfejs{
    String opis = "Burger vege";

    @Override
    public String opis() {
        return this.opis;
    }

    @Override
    public double cena() {
        return 22.95;
    }
}
