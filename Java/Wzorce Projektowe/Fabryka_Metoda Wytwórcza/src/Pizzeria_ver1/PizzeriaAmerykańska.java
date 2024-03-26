package Pizzeria_ver1;

public class PizzeriaAmerykańska extends Pizzeria{
    @Override
    protected Pizza utwórzPizze(String type) {
        if (type.equals("serowa")) {
            return new PizzaAmerykańskaSerowa();
        }

        return null;
    }
}
