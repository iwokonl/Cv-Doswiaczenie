package Dekorator;

public class BrugerNormalny implements BurgerInterfejs{

    @Override
    public String opis() {
        return "Burger normalny";
    }

    @Override
    public double cena() {
        return 20.95;
    }
}
