package ver1;

public abstract class Napój {
    private String opis = "Napój nie znany.";
    public String pobierzOpis()
    {
        return this.opis;
    }
    public void ustawOpis(String o){
        this.opis = o;
    }
    public abstract double koszt();

}
