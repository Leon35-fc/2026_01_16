package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class Collezione {
    // LISTA CHE CONTIENE TUTTI I GIOCHI
    private List<Gioco> giochiList = new ArrayList<>();

    public void Collezione() {
        this.giochiList = new ArrayList<>();
    }

    public void rimuoviGioco(Gioco gioco) {
        giochiList.remove(gioco);
    }

    public List<Gioco> getGiochi() {
        return giochiList;
    }


    // AGGIUNGI GIOCO (NO ID DUPLICATI)
    public void aggiungiGioco(Gioco nuovoGioco) {
        boolean presente = giochiList.stream()
                .anyMatch( g -> g.getId()
                        .equals(nuovoGioco.getId()));
        if (presente) {
            throw new RuntimeException("Errore: il gioco con ID " + nuovoGioco.getId() + "è già presente.");
        }
        giochiList.add(nuovoGioco);
    }

    // RICERCA PER ID
    public Gioco ricercaId(Long id) {
        return giochiList.stream()
                .filter(g -> g.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Il gioco non è presente nella collezione. ID: " + id));
    }

    // LISTA DI GIOCHI CON PREZZO INFERIORE A NPREZZO
    public List<Gioco> prezzoInferiore(double prezzo){
        return giochiList.stream().filter(g -> g.getPrezzo() < prezzo).toList();
    }

    // RICERCA PER NUMERO DI GIOCATORI
    public List<GiocoDaTavolo> numPlayers(int nPlayers){
        return giochiList.stream()
                .filter(gioco -> gioco instanceof GiocoDaTavolo)
                .map(g -> (GiocoDaTavolo) g).filter( g -> g.getNumPlayers() == nPlayers)
                .toList();
    }

    // RIMOZIONE DI UN GIOCO DATO UN ID
    public void rimuoviGioco(Long id){
        giochiList.removeIf( g -> g.getId().equals(id));
    }

    // AGGIORNARE UN ELEMENTO ESISTENTE DATO UN ID
    public void aggiornaGioco(Gioco gAggiornato){
        giochiList = giochiList.stream()
                .map(gioco -> gioco.getId().equals(gAggiornato.getId()) ? gAggiornato : gioco)
                .toList();

        System.out.println("Gioco Aggiornato!");
    }

    //STATISTICHE GIOCHI (GIOCHI E VIDEOGIOCHI TOT.; GIOCO PREZZO PIù ALTO; MEDIA PREZZI)
    //TOTALE GIOCHI
    public void nTotaleGiochi(){
        System.out.println("I giochi nella collezione sono: " + giochiList.size());
    }

    //GIOCO CON IL PREZZO PIù ALTO
    public void giocoCostoso(){
     giochiList.stream().max((gioco1, gioco2) -> Double.compare(gioco1.getPrezzo()));
    }
}
