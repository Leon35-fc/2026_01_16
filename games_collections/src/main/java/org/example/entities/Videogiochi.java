package org.example.entities;

import

public class Videogiochi extends Gioco implements Genere {;
    super{id, title, published, price};
    private String piattaforma;
    private int durata; //in ore
    private Genere genere;

    public Videogiochi(String piattaforma, int durata){
        this.piattaforma=piattaforma;
        this.durata=durata;
    }

    public Videogiochi(String piattaforma, int durata, Genere genere){
        this.piattaforma=piattaforma;
        this.durata=durata;
        this.genere=genere;
    }
}
