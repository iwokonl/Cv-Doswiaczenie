package Pol;

import Obs.Kolejka;

import java.util.concurrent.TimeUnit;

public class PolecenieRejestracji implements Polecenie {
    Rejestracja rejestracja;
    public PolecenieRejestracji(){
        rejestracja= new Rejestracja();
    }
    @Override
    public void zarejestrujUżytkownika() {
        synchronized (PolecenieRejestracji.class) {
            rejestracja.zarejestrowanieUżytkowinka();
            //System.out.println("Rejestracja użytkownika przebiegła pomyślnie");
            //System.out.println("Użytkownik został przypisany do id: " + rejestracja.getId());


        }

    }


}
