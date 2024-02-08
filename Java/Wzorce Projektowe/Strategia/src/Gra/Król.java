package Gra;

public class Król extends Postać {
    public Król(){
        brońZachowanie = new MieczZachowanie();
    }
    @Override
    public void walcz() {
        System.out.println("Król");
    }
}
