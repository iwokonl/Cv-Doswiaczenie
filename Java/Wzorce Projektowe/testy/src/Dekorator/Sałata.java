package Dekorator;

public class Sałata implements BurgerInterfejs{
    BurgerInterfejs burgerInterfejs;

    public Sałata(BurgerInterfejs burgerInterfejs) {
        this.burgerInterfejs = burgerInterfejs;
    }

    @Override
    public String opis() {
        return burgerInterfejs.opis() + ", Sałata";
    }

    @Override
    public double cena() {
        return burgerInterfejs.cena() + 3.00;
    }
}
