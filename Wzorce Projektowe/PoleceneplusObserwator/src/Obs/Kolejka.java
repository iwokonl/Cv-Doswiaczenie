package Obs;

import Pol.Polecenie;
import Pol.UżytkownikRejestracja;

import java.util.ArrayList;
import java.util.List;

public class Kolejka implements Obserwator {

    public Kolejka(){
        polecenies = new ArrayList<>();


    }
    @Override
    public void zarejestrójObserwator(Polecenie użytkownikRejestracja) {
        polecenies.add(użytkownikRejestracja);
    }

    @Override
    public void usuńObserwator(Obserwator o) {
        polecenies.remove(o);
    }

    @Override
    public void powiadomObserwator() {
        for(Polecenie obserwator:polecenies){
            obserwator.zarejestrujUżytkownika();
            polecenies.remove(obserwator);
        }
    }

    private List<Polecenie> polecenies;
    private UżytkownikRejestracja użytkownikRejestracja;
}
