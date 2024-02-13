package Pizzeria_ver1;

public class PizzeriaWłoska extends Pizzeria{
    @Override
    protected Pizza utwórzPizze(String type) {
        if (type.equals("serowa")){
            return new PizzaWłoskaSerowa();
        }
        return null;
    }
}
