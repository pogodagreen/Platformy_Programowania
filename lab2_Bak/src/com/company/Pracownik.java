package com.company;

public class Pracownik extends Osoba {
    Stanowisko stanowisko;
    int pensja;

    public Pracownik(String getImie,String getNazwisko, Stanowisko getStanowisko, int getPensja){
        super(getImie,getNazwisko);
        stanowisko=getStanowisko;
        pensja=getPensja;
    }

    @Override
    public String toString() {
        return super.toString()+" "+stanowisko+" "+pensja;
    }
}
