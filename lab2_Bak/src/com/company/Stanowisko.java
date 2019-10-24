package com.company;

public enum Stanowisko{
    Dyrektor (1, "gowno"),
    Kierownik(2, "chuj");


private final int poziom;
private final String opis;

Stanowisko(int poziom, String opis)
{
    this.poziom=poziom;
    this.opis=opis;
}

private int getPoziom(){return poziom;}
private String getOpis(){return opis;}

}
