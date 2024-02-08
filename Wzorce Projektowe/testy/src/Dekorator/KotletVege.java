package Dekorator;

public class KotletVege implements BurgerInterfejs{
    BurgerInterfejs burgerInterfejs;

    public KotletVege(BurgerInterfejs burgerInterfejs) {
        this.burgerInterfejs = burgerInterfejs;
    }

    @Override
    public String opis() {
        return burgerInterfejs.opis() + ", Kotlet vege";
    }

    @Override
    public double cena() {
        return burgerInterfejs.cena() +  7.00;
    }
}
