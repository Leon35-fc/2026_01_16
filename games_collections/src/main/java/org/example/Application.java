package org.example;

import org.example.entities.*;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    Collezione collezione = new Collezione();

    try{
        collezione.aggiungiGioco(new Videogioco(1, "Resident Evil Requiem", 2026, 0.0, "PC, console", 0, Genere.HORROR));

    }catch{}

}

//        (1, "Resident Evil Requiem", 2026, 0.0, "PC, console", 0, "survival horror"),
//        (2, "Tides of Tomorrow", 2026, 0.0, "PS5", 0, "non specificato"),
//        (3, "007 First Light", 2026, 0.0, "XBOX", 0, "non specificato"),
//        (4, "Grand Theft Auto VI", 2026, 0.0, "PC", 0, "azione-avventura"),
//        (5, "ARC Raiders", 2026, 12.69, "PC", 0, "non specificato"),
//        (6, "Quarantine Zone: The Last Check", 2026, 0.0, "PC", 0, "non specificato")
//
//        (1, "Nome in Codice", 2015, 24.98, 4-8, 30),
//        (2, "7 Wonders Duel", 2015, 27.90, 2, 30),
//        (3, "Scrabble", 1938, 19.90, 2-4, 60),
//        (4, "Monopoly", 1935, 29.90, 2-8, 60-180),
//        (5, "Risiko", 1957, 39.90, 2-5, 120-240),
//        (6, "Cluedo", 1949, 24.90, 3-6, 30-60)