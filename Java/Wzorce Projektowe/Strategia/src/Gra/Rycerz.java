package Gra;

public class Rycerz extends Postać{
    public Rycerz(){
        brońZachowanie = new MieczZachowanie();
    }
    @Override
    public void walcz() {
        System.out.println("Rycerz");
    }
}
