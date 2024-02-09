package Pol;

public class Rejestracja {
    private volatile int id = 0;
    public void zarejestrowanieUżytkowinka(){
        id++;
        System.out.println(id);

    }
    public int getId(){
        return id;
    }
}
