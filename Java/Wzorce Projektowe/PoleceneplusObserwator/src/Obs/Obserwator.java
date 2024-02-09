package Obs;

import Pol.Polecenie;
import Pol.UżytkownikRejestracja;

public interface Obserwator {
    void zarejestrójObserwator(Polecenie użytkownikRejestracja);
    void usuńObserwator(Obserwator o);
    void powiadomObserwator();

}
