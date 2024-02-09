package Pol;

import Obs.Kolejka;

public class UżytkownikRejestracja {
    Polecenie polecenie;
    Kolejka kolejka;
    public UżytkownikRejestracja(Polecenie polecenie){
        this.polecenie = polecenie;
        kolejka =new Kolejka();
    }

    public void wykonajRejestracje(){
        kolejka.zarejestrójObserwator(polecenie);
        polecenie.zarejestrujUżytkownika();

    }
}
