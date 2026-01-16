package org.example.entities;

public class GiocoDaTavolo extends Gioco {
    //ATTRIBUTI
    private int numPlayers;
    private int playedMin;

    //COSTRUTTORE
    public GiocoDaTavolo(Long id, String titolo, int annoPubblicazione, double price, int numPlayers, int playedMin) throws Exception {
        super(id, titolo, annoPubblicazione, price);
        if (numPlayers >= 2 && numPlayers <= 10) {
            this.numPlayers = numPlayers;
        } else {
            throw new Exception("possono partecipare da 2 a massimo 10 persone");
        }
        this.playedMin = playedMin;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public int getPlayedMin() {
        return playedMin;
    }

    public void setPlayedMin(int playedMin) {
        this.playedMin = playedMin;
    }

    @Override
    public String toString() {
        return "GiocoDaTavolo{" +
                "numPlayers=" + numPlayers +
                ", playedMin=" + playedMin +
                '}';
    }
}