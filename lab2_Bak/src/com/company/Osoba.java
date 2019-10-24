package com.company;

public class Osoba {
    private static String Imie;
    private static String Nazwisko;

    public Osoba(String getImie, String getNazwisko){
        Imie=getImie;
        Nazwisko=getNazwisko;
    }

    @Override
    public String toString() {
        return Imie+" "+Nazwisko;
    }
}
