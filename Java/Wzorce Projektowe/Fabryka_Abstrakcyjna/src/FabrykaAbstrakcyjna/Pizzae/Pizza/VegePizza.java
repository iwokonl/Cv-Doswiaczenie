package FabrykaAbstrakcyjna.Pizzae.Pizza;

import FabrykaAbstrakcyjna.Pizzae.Fabryki.FabrykaSkładnikówPizzy;

public class VegePizza extends Pizza{
    FabrykaSkładnikówPizzy fabrykaSkładnikówPizzy;

    public VegePizza(FabrykaSkładnikówPizzy fabrykaSkładnikówPizzy){
        this.fabrykaSkładnikówPizzy = fabrykaSkładnikówPizzy;
        this.nazwa = "VegePizza";
    }
    @Override
    public void przygotowanie() {
        ciasto = fabrykaSkładnikówPizzy.utwórzCiasto("grube");
        sos = fabrykaSkładnikówPizzy.utwórzSos("sospomidorowy");
        ser = fabrykaSkładnikówPizzy.utwórzSer("mozzarella");
        this.pepperoni = fabrykaSkładnikówPizzy.utwórzPepperoni("");
        this.małże = fabrykaSkładnikówPizzy.utwórzMałże("");
        String[] warzywa = {"papryka","pomidor","papryka"};
        this.warzywa= fabrykaSkładnikówPizzy.utwórzWarzywa(warzywa);

    }
}
