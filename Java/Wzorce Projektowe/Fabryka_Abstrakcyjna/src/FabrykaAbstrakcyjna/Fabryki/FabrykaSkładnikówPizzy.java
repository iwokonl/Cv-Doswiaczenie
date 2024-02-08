package FabrykaAbstrakcyjna.Fabryki;


import FabrykaAbstrakcyjna.Składniki.Ciasto.Ciasto;
import FabrykaAbstrakcyjna.Składniki.Małże.Małże;
import FabrykaAbstrakcyjna.Składniki.Ser.Ser;
import FabrykaAbstrakcyjna.Składniki.Sos.Sos;
import FabrykaAbstrakcyjna.Składniki.Warzywa.Warzywa;
import FabrykaAbstrakcyjna.Składniki.Wędliny.Wędliny;

public interface FabrykaSkładnikówPizzy {
    public Ciasto utwórzCiasto(String typ);
    public Sos utwórzSos(String typ);
    public Ser utwórzSer(String typ);
    public Warzywa[] utwórzWarzywa(String[] typ);



    public Wędliny utwórzPepperoni(String typ);
    public Małże utwórzMałże(String typ);

}
