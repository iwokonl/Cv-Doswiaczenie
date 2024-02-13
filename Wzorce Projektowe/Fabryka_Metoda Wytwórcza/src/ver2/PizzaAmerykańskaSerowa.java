package ver2;

public class PizzaAmerykańskaSerowa extends Pizza {
    public PizzaAmerykańskaSerowa(){
        nazwa= "Amerykańska";
        ciasto = "Grube";
        sos = "Grzybowy";
        dodatki.add("Tarty ser tłusty");
    }

    @Override
    void krojenie() {
        System.out.println("Krojenie pizzy na kwadratowe kawałki");
    }
}
