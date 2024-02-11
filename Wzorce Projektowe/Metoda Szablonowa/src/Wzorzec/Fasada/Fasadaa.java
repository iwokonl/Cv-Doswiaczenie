package Wzorzec.Fasada;

import Wzorzec.MetodaSzablonowa.NapójZKofeinąCośOgólnego;

public class Fasadaa {
    NapójZKofeinąCośOgólnego napójZKofeinąCośOgólnego;


    public Fasadaa(NapójZKofeinąCośOgólnego napójZKofeinąCośOgólnego){
        this.napójZKofeinąCośOgólnego = napójZKofeinąCośOgólnego;
    }

    public void zróbPicie(){
        napójZKofeinąCośOgólnego.recepturaPrzygotowania();
    }
}
