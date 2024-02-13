package FabrykaAbstrakcyjna.Fabryki;

import FabrykaAbstrakcyjna.Składniki.Ciasto.BrakCiasta;
import FabrykaAbstrakcyjna.Składniki.Ciasto.Ciasto;
import FabrykaAbstrakcyjna.Składniki.Ciasto.Cienkie;
import FabrykaAbstrakcyjna.Składniki.Ciasto.Grube;
import FabrykaAbstrakcyjna.Składniki.Małże.BrakMałży;
import FabrykaAbstrakcyjna.Składniki.Małże.Małże;
import FabrykaAbstrakcyjna.Składniki.Małże.MałżeMrożone;
import FabrykaAbstrakcyjna.Składniki.Małże.MałżeŚwieże;
import FabrykaAbstrakcyjna.Składniki.Ser.BrakSera;
import FabrykaAbstrakcyjna.Składniki.Ser.Ser;
import FabrykaAbstrakcyjna.Składniki.Ser.SerMozzarella;
import FabrykaAbstrakcyjna.Składniki.Ser.SerReggiano;
import FabrykaAbstrakcyjna.Składniki.Sos.BrakSosu;
import FabrykaAbstrakcyjna.Składniki.Sos.Sos;
import FabrykaAbstrakcyjna.Składniki.Sos.SosMarinara;
import FabrykaAbstrakcyjna.Składniki.Sos.SosPomidorowy;
import FabrykaAbstrakcyjna.Składniki.Warzywa.BrakWarzyw;
import FabrykaAbstrakcyjna.Składniki.Warzywa.Papryka;
import FabrykaAbstrakcyjna.Składniki.Warzywa.Pomidor;
import FabrykaAbstrakcyjna.Składniki.Warzywa.Warzywa;
import FabrykaAbstrakcyjna.Składniki.Wędliny.BrakWędliny;
import FabrykaAbstrakcyjna.Składniki.Wędliny.Pepperoni;
import FabrykaAbstrakcyjna.Składniki.Wędliny.Wędliny;

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
