package Dekorator;

public class KotletZMięsem implements BurgerInterfejs{
    BurgerInterfejs burgerInterfejs;

    public KotletZMięsem(BurgerInterfejs burgerInterfejs) {
        this.burgerInterfejs = burgerInterfejs;
    }

    @Override
    public String opis() {
        return burgerInterfejs.opis() + ", Kotlet z mięsem";
    }

    @Override
    public double cena() {
        return burgerInterfejs.cena() + 4.00;
    }
}
