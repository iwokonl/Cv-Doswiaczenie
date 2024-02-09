package Wzorzec;

import Wzorzec.Poleceniee.Polecenie;

public class Pilot {
    Polecenie socket;
    public Pilot(Polecenie polecenie){
        socket = polecenie;
    }

    public void uruchomieniePolecenie(){
        socket.uruchomPolecenie();
    }
}
