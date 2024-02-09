import Wzorzec.Pilot;
import Wzorzec.Poleceniee.Polecenie;
import Wzorzec.Poleceniee.PolecenieZapalŚwiatło;

public class Main {
    public static void main(String[] args) {
        Polecenie zapal = new PolecenieZapalŚwiatło();
        Pilot pilot= new Pilot(zapal);
        pilot.uruchomieniePolecenie();
        pilot.uruchomieniePolecenie();
    }
}