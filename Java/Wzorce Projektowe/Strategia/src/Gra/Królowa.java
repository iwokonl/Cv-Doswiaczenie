package Gra;

public class Królowa extends Postać{
    public Królowa(){
        brońZachowanie = new MieczZachowanie();
    }
    @Override
    public void walcz() {
        System.out.println("królowa");
    }
}
