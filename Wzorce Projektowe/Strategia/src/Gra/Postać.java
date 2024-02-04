package Gra;

public abstract class Postać {
    BrońZachowanie brońZachowanie;

    public abstract void walcz();

    public void użyjBroni() {
        brońZachowanie.uzyjBroni();
    }

    public void ustawBroń(BrońZachowanie b) {
        this.brońZachowanie = b;
    }
}
