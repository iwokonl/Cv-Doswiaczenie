package FabrykaAbstrakcyjna.Pizzae.Fabryki;

import FabrykaAbstrakcyjna.Pizzae.Składniki.Ciasto.BrakCiasta;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Ciasto.Ciasto;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Ciasto.Cienkie;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Ciasto.Grube;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Małże.BrakMałży;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Małże.Małże;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Małże.MałżeMrożone;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Małże.MałżeŚwieże;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Ser.BrakSera;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Ser.Ser;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Ser.SerMozzarella;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Ser.SerReggiano;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Sos.BrakSosu;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Sos.Sos;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Sos.SosMarinara;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Sos.SosPomidorowy;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Warzywa.BrakWarzyw;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Warzywa.Papryka;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Warzywa.Pomidor;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Warzywa.Warzywa;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Wędliny.BrakWędliny;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Wędliny.Pepperoni;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Wędliny.Wędliny;

public class WłoskaFabrykaSkładnikówPizzy implements FabrykaSkładnikówPizzy{

    @Override
    public Ciasto utwórzCiasto(String typ) {
        if ("cienkie".equals(typ.toLowerCase())){
            return new Cienkie();
        } else if ("grube".equals(typ.toLowerCase())) {
            return new Grube();
        }
        return new BrakCiasta();
    }

    @Override
    public Sos utwórzSos(String typ) {
        if ("sosmarinara".equals(typ.toLowerCase())){
            return new SosMarinara();
        } else if ("sospomidorowy".equals(typ.toLowerCase())) {
            return new SosPomidorowy();
        }
        return new BrakSosu();
    }

    @Override
    public Ser utwórzSer(String typ) {
        if ("mozzarella".equals(typ.toLowerCase())){
            return new SerMozzarella();
        } else if ("reggiano".equals(typ.toLowerCase())) {
            return new SerReggiano();
        }
        return new BrakSera();
    }

    @Override
    public Warzywa[] utwórzWarzywa(String[] typ) {
        Warzywa[] warzywas = new Warzywa[typ.length];
        if(typ.length == 0){
            Warzywa[] temp = {new BrakWarzyw()};
            return temp;
        }
        for(int i = 0;i<typ.length;i++){
            if(typ[i].toLowerCase().equals("papryka")){
                warzywas[i]=new Papryka();
            } else if (typ[i].toLowerCase().equals("pomidor")) {
                warzywas[i]=new Pomidor();
            }
            else {
                warzywas[i]=new BrakWarzyw();
            }
        }
        return warzywas;
    }

    @Override
    public Wędliny utwórzPepperoni(String typ) {
        if (typ.toLowerCase().equals("pepperoni"))
            return new Pepperoni();
        return new BrakWędliny();
    }

    @Override
    public Małże utwórzMałże(String typ) {
        if ("mrożone".equals(typ.toLowerCase())){
            return new MałżeMrożone();
        } else if ("świeże".equals(typ.toLowerCase())) {
            return new MałżeŚwieże();
        }
        return new BrakMałży();
    }
}
