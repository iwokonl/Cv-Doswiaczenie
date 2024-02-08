package Polecenie;

import Polecenie.Polecenie.Poleceniee;

public class Pilot {
    Poleceniee gniazdo;
    public Pilot(){}

    public void ustawPolecenie(Poleceniee poleceniee){
        gniazdo = poleceniee;
    }
    public void przyciskZostałNaciśnięty(){
        gniazdo.wykonajPolecenie();

    }
    public boolean getState(){
        return gniazdo.getState();
    }
}
