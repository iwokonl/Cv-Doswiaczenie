package FabrykaAbstrakcyjna.Pizza;


import FabrykaAbstrakcyjna.Składniki.Ciasto.Ciasto;
import FabrykaAbstrakcyjna.Składniki.Małże.Małże;
import FabrykaAbstrakcyjna.Składniki.Ser.Ser;
import FabrykaAbstrakcyjna.Składniki.Sos.Sos;
import FabrykaAbstrakcyjna.Składniki.Warzywa.Warzywa;
import FabrykaAbstrakcyjna.Składniki.Wędliny.Wędliny;

import java.util.Arrays;

public abstract class Pizza {
    String nazwa;
    Ciasto ciasto;
    Sos sos;
    Warzywa warzywa[];
    Ser ser;
    Wędliny pepperoni;
    Małże małże;
    public abstract void przygotowanie();
    public void krojenie(){
        System.out.println("Krojenie pizzy");
    }
    public void Pieczenie(){
        System.out.println("Pieczenie pizzy");
    }
    public void pakowanie(){
        System.out.println("Pakowanie pizzy");
    }

    public void setNazwa(String nazwa){
        this.nazwa = nazwa;
    }
    String getNazwa(){
        return this.nazwa;
    }


    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder(warzywa[0].getNazwa() + ", ");
        for(int i = 1;i< warzywa.length;i++){
            if (i != warzywa.length -1) {
                temp.append(warzywa[i].getNazwa() + ", ");
            }
            else {
                temp.append(warzywa[i].getNazwa());
            }
        }
        return "Pizza{" +
                "nazwa='" + nazwa + '\'' +



                ", warzywa=" + temp +
                ", ser=" + ser.getNazwa() +
                ", sos=" + sos.getNazwa() +
                ", ciasto=" + ciasto.getNazwa() +
                ", pepperoni=" + pepperoni.getNazwa() +
                ", małże=" + małże.getNazwa() +
                '}';
    }
}
