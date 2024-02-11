import Wzorzec.Fasada.Fasadaa;
import Wzorzec.MetodaSzablonowa.Kawa;

public class main {
    public static void main(String[] args) {
        import Wzorzec.Fasada.Fasadaa;
import Wzorzec.MetodaSzablonowa.Kawa;
import Wzorzec.MetodaSzablonowa.NapójZKofeinąCośOgólnego;

        public class Main {
            public static void main(String[] args) {
                // Prezentacja metody szablonowej
                Kawa kawa = new Kawa();
                kawa.recepturaPrzygotowania();
                System.out.println();
                System.out.println();
                System.out.println();
                // Prezentacja Fasady
                Fasadaa fasadaa = new Fasadaa(kawa);
                fasadaa.zróbPicie();

            }
        }
    }
}
