package ver2;

public class PizzeriaAmerykańska extends Pizzeria {
    @Override
    protected Pizza utwórzPizze() {
        return new PizzaAmerykańskaSerowa();
    }
}
