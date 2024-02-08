package Strategia;

public class Rower extends Pojazd{
    public Rower(){
        kołaZachowanie = new Koła17Cali();
    }
    @Override
    public void jakiPojazd() {
        System.out.println("Rower");
        jakieKoła();
    }
}
