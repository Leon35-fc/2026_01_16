package org.example.entities;

import org.example.entities.Genere;

public class Videogioco extends Gioco {
    //ATTRIBUTI VIDEOGAMES
    private String platforms;
    private int playTimes;
    private Genere genere;

    //COSTRUTTORE
    public Videogioco(Long id, String titolo, int annoPubblicazione, double price, String platforms, int playTimes, Genere genere) {
        super(id, titolo, annoPubblicazione, price);
        //costruiamo la nostra Class
        this.platforms = platforms;
        this.playTimes = playTimes;
        this.genere = genere;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public int getPlayTimes() {
        return playTimes;
    }

    public void setPlayTimes(int playTimes) {
        this.playTimes = playTimes;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Videogames{" +
                "platforms='" + platforms + '\'' +
        ", playTimes=" + playTimes +
                ", genere=" + genere +
                '}';
    }
}