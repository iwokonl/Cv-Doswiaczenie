package Polecenie;

public class Światło {
    boolean state = true;

    public void switchLight(){
        state = !state;
    }
    public boolean getState(){
        return state;
    }

}
