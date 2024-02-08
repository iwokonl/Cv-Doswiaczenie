package Strategia;

public class Motor extends Pojazd{
    public Motor(){
        kołaZachowanie = new Koła20Cali();
    }
    @Override
    public void jakiPojazd() {
        System.out.println("Motor");
        jakieKoła();
    }
}
