package Polecenie.Polecenie;
import Polecenie.Światło;

public class PolecenieWywołajŚwiatło implements Poleceniee {
    Światło światło;
    public PolecenieWywołajŚwiatło(Światło światło){
        this.światło = światło;
    }
    @Override
    public void wykonajPolecenie() {
        światło.switchLight();

    }
    public boolean getState(){
        return światło.getState();
    }
}
