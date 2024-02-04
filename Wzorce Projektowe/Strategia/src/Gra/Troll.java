package Gra;

public class Troll extends Postać{
    public Troll(){
        brońZachowanie = new MaczugaZachowanie();
    }
    @Override
    public void walcz() {
        System.out.println("Troll");
    }
}
