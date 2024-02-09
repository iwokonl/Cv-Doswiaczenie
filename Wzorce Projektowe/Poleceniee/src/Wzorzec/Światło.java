package Wzorzec;

public class Światło {
    boolean stan = true;

    public void switchLight(){
        stan = !stan;
        System.out.println(stan);
    }
    public boolean getStan(){
        return stan;
    }
}
