package Strategia;

public abstract class Pojazd {
    KołaZachowanie kołaZachowanie;

    public void zmieńKoła(KołaZachowanie kołaZachowanie){
        this.kołaZachowanie = kołaZachowanie;
    }
    public abstract void jakiPojazd();

    public void jakieKoła(){
        kołaZachowanie.jakieKoła();
    }


}
