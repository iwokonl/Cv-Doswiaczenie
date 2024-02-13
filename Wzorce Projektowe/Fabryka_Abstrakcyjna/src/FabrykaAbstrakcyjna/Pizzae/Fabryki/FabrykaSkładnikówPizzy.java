package FabrykaAbstrakcyjna.Pizzae.Fabryki;


import FabrykaAbstrakcyjna.Pizzae.Składniki.Ciasto.Ciasto;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Małże.Małże;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Ser.Ser;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Sos.Sos;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Warzywa.Warzywa;
import FabrykaAbstrakcyjna.Pizzae.Składniki.Wędliny.Wędliny;

public interface FabrykaSkładnikówPizzy {
    public Ciasto utwórzCiasto(String typ);
    public Sos utwórzSos(String typ);
    public Ser utwórzSer(String typ);
    public Warzywa[] utwórzWarzywa(String[] typ);



    public Wędliny utwórzPepperoni(String typ);
    public Małże utwórzMałże(String typ);

}
