package Wzorzec.Poleceniee;

import Wzorzec.Światło;

public class PolecenieZapalŚwiatło implements Polecenie{
    Światło światło;
    public PolecenieZapalŚwiatło(){
        światło= new Światło();
    }
    @Override
    public void uruchomPolecenie() {
        światło.switchLight();
    }
}
