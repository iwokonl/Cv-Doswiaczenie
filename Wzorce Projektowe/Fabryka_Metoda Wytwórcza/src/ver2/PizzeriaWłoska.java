package ver2;

public class PizzeriaWłoska extends Pizzeria {
    @Override
    protected Pizza utwórzPizze() {
        return new PizzaWłoskaSerowa();
    }
}
