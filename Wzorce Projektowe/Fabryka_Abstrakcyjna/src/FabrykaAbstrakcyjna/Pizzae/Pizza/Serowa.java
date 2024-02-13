package FabrykaAbstrakcyjna.Pizzae.Pizza;

import FabrykaAbstrakcyjna.Pizzae.Fabryki.FabrykaSkładnikówPizzy;

public class Serowa extends Pizza{
    FabrykaSkładnikówPizzy fabrykaSkładnikówPizzy;

    public Serowa(FabrykaSkładnikówPizzy fabrykaSkładnikówPizzy){
        this.fabrykaSkładnikówPizzy = fabrykaSkładnikówPizzy;

        przygotowanie();
    }
    @Override
    public void przygotowanie() {
        ciasto = fabrykaSkładnikówPizzy.utwórzCiasto("grube");
        sos = fabrykaSkładnikówPizzy.utwórzSos("sospomidorowy");
        ser = fabrykaSkładnikówPizzy.utwórzSer("mozzarella");
        this.pepperoni = fabrykaSkładnikówPizzy.utwórzPepperoni("pepperoni");
        this.małże = fabrykaSkładnikówPizzy.utwórzMałże("");
        String[] warzywa = {"papryka","pomidor","papryka"};
        this.warzywa= fabrykaSkładnikówPizzy.utwórzWarzywa(warzywa);
        this.nazwa = "Serowa";

    }
}
