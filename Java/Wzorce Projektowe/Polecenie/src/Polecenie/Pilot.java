package Polecenie;

import Polecenie.Polecenie.Poleceniee;

public class Pilot {
    Poleceniee gniazdo;
    Poleceniee gniazdo1;
    Poleceniee gniazdo2;
    Poleceniee gniazdo3;
    Poleceniee gniazdo4;
    Poleceniee gniazdo5;
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
