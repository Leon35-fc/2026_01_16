package org.example;

import org.example.entities.*;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Collezione collezione = new Collezione();

        //GIOCHI
        try {
            collezione.aggiungiGioco(new Videogioco
                    (1L, "Resident Evil Requiem", 2026, 0.0, "PC, console", 0, Genere.HORROR));
            collezione.aggiungiGioco(new Videogioco
                    (2L, "Tides of Tomorrow", 2026, 0.0, "PS5", 0, Genere.AVVENTURA));
            collezione.aggiungiGioco(new Videogioco
                    (3L, "007 First Light", 2026, 0.0, "XBOX", 0, Genere.STEALTH));
            collezione.aggiungiGioco(new Videogioco
                    (4L, "Grand Theft Auto VI", 2026, 0.0, "PC", 0, Genere.AZIONE));
            collezione.aggiungiGioco(new Videogioco
                    (5L, "ARC Raiders", 2026, 12.69, "PC", 0, Genere.SIMULAZIONE));
            collezione.aggiungiGioco(new Videogioco
                    (6L, "Quarantine Zone: The Last Check", 2026, 0.0, "PC", 0, Genere.HORROR));

            collezione.aggiungiGioco(new GiocoDaTavolo
                    (11L, "Nome in Codice", 2015, 24.98, 8, 30));
            collezione.aggiungiGioco(new GiocoDaTavolo
                    (12L, "7 Wonders Duel", 2015, 27.90, 2, 30));
            collezione.aggiungiGioco(new GiocoDaTavolo
                    (13L, "Scrabble", 1938, 19.90, 4, 60));
            collezione.aggiungiGioco(new GiocoDaTavolo
                    (14L, "Monopoly", 1935, 29.90, 8, 180));
            collezione.aggiungiGioco(new GiocoDaTavolo
                    (15L, "Risiko", 1957, 39.90, 5, 240));
            collezione.aggiungiGioco(new GiocoDaTavolo
                    (16L, "Cluedo", 1949, 24.90, 6, 60));

        } catch (Exception e) {
            System.out.println("Errore dati iniziali: " + e.getMessage());
        }

        int scelta = -1;

        do {
            System.out.println("COLLEZIONE GIOCHI");
            System.out.println("Giochi attuali:");
            collezione.stampaTutti();

            System.out.println("MENU:");
            System.out.println("1 - Aggiungi VIDEOGIOCO");
            System.out.println("2 - Aggiungi GIOCO DA TAVOLO");
            System.out.println("3 - Cerca per ID");
            System.out.println("4 - Cerca per prezzo (trova giochi con prezzo < valore)");
            System.out.println("5 - Cerca per numero giocatori (solo giochi da tavolo)");
            System.out.println("6 - Rimuovi per ID");
            System.out.println("8 - Statistiche");
            System.out.println("0 - Esci");
            System.out.print("Scelta: ");

            scelta = leggiIntero(scanner);

            switch (scelta) {

                case 1: // aggiungi videogioco
                    aggiungiVideogioco(scanner, collezione);
                    break;

                case 2: // aggiungi Gioco da tavola
                    aggiungiGiocoDaTavolo(scanner, collezione);
                    break;

                case 3: // cerca per id
                    System.out.print("Inserisci ID da cercare: ");
                    Long idCerca = leggiLong(scanner);

                    Gioco trovato = collezione.ricercaId(idCerca);
                    if (trovato != null) {
                        // stampa solo il titolo
                        System.out.println("Hai scelto il gioco: " + trovato.getTitolo());
                    } else {
                        System.out.println("Nessun ID " + idCerca);
                    }
                    break;

                case 4: // cerca per prezzo più basso
                    System.out.print("Inserisci prezzo massimo: ");
                    double prezzoMax = leggiDouble(scanner);

                    List<Gioco> risultatiPrezzo = collezione.prezzoInferiore(prezzoMax);
                    if (risultatiPrezzo.isEmpty()) {
                        System.out.println("Nessun gioco con prezzo minore di " + prezzoMax);
                    } else {
                        System.out.println("Risultati:");
                        // stampa SOLO i titoli
                        risultatiPrezzo.forEach(g -> System.out.println(g.getTitolo()));
                    }
                    break;

                case 5: // cerca per numero giocatori
                    System.out.print("Inserisci numero giocatori: ");
                    int numGiocatori = leggiIntero(scanner);

                    List<GiocoDaTavolo> risultatiGiocatori = collezione.numPlayers(numGiocatori);
                    if (risultatiGiocatori.isEmpty()) {
                        System.out.println("Nessun gioco da tavolo con " + numGiocatori + " giocatori");
                    } else {
                        System.out.println("Risultati:");
                        // stampa SOLO i titoli
                        risultatiGiocatori.forEach(g -> System.out.println(g.getTitolo()));
                    }
                    break;

                case 6: // rimuovi per id
                    System.out.print("Inserisci ID da rimuovere: ");
                    Long idRimuovi = leggiLong(scanner);

                    Gioco daRimuovere = collezione.ricercaId(idRimuovi);
                    if (daRimuovere == null) {
                        System.out.println("Impossibile rimuovere: ID non trovato");
                    } else {
                        collezione.rimuoviGioco(idRimuovi);
                        System.out.println("Rimosso gioco con ID " + idRimuovi);
                    }
                    break;

                case 8: // statistiche
                    collezione.statistiche();
                    break;

                case 0:
                    System.out.println("Uscita dal programma.");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 0);

        scanner.close();
    }

    private static void aggiungiVideogioco(Scanner scanner, Collezione collezione) {
        try {
            System.out.print("ID: ");
            Long id = leggiLong(scanner);
            Gioco gia = collezione.ricercaId(id);
            if (gia != null) {
                System.out.println("Errore: esiste già un gioco con questo ID.");
                return;
            }

            Gioco vg = creaVideogiocoDaInput(scanner, id);
            collezione.aggiungiGioco(vg);
            System.out.println("Videogioco aggiunto!");

        } catch (RuntimeException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    private static void aggiungiGiocoDaTavolo(Scanner scanner, Collezione collezione) {
        try {
            System.out.print("ID: ");
            Long id = leggiLong(scanner);
            Gioco gia = collezione.ricercaId(id);
            if (gia != null) {
                System.out.println("Errore: esiste già un gioco con questo ID.");
                return;
            }

            Gioco bg = creaGiocoDaTavoloDaInput(scanner, id);
            collezione.aggiungiGioco(bg);
            System.out.println("Gioco da tavolo aggiunto!");

        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    private static Videogioco creaVideogiocoDaInput(Scanner scanner, Long id) {
        System.out.print("Titolo: ");
        String titolo = scanner.nextLine();

        System.out.print("Anno pubblicazione: ");
        int anno = leggiIntero(scanner);

        System.out.print("Prezzo: ");
        double prezzo = leggiDouble(scanner);

        System.out.print("Piattaforma (PC/PS5/XBox): ");
        String piattaforma = scanner.nextLine();

        System.out.print("Durata di gioco (ore): ");
        int ore = leggiIntero(scanner);

        System.out.println("Genere disponibili: ");
        for (Genere t : Genere.values()) {
            System.out.print(t + " ");
        }
        System.out.println();

        System.out.print("Scrivi genere ESATTO (es. STRATEGIA): ");
        String genInput = scanner.nextLine();

        Genere genere;
        try {
            genere = Genere.valueOf(genInput.trim().toUpperCase());
        } catch (Exception e) {
            System.out.println("Genere non valido");
            genere = Genere.AZIONE;
        }

        return new Videogioco(id, titolo, anno, prezzo, piattaforma, ore, genere);
    }

    private static GiocoDaTavolo creaGiocoDaTavoloDaInput(Scanner scanner, Long id) throws Exception {
        System.out.print("Titolo: ");
        String titolo = scanner.nextLine();

        System.out.print("Anno pubblicazione: ");
        int anno = leggiIntero(scanner);

        System.out.print("Prezzo: ");
        double prezzo = leggiDouble(scanner);

        System.out.print("Numero giocatori (2-10): ");
        int numPlayers = leggiIntero(scanner);

        System.out.print("Durata media  minuti: ");
        int minuti = leggiIntero(scanner);

        return new GiocoDaTavolo(id, titolo, anno, prezzo, numPlayers, minuti);
    }

    private static int leggiIntero(Scanner scanner) {
        while (true) {
            String s = scanner.nextLine();
            try {
                return Integer.parseInt(s.trim());
            } catch (NumberFormatException e) {
                System.out.print("Errore, Inserisci un intero, esempio 4 ");
            }
        }
    }

    private static long leggiLong(Scanner scanner) {
        while (true) {
            String s = scanner.nextLine();
            try {
                return Long.parseLong(s.trim());
            } catch (NumberFormatException e) {
                System.out.print("Errore, Inserisci un numero intero (esempio 4): ");
            }
        }
    }

    private static double leggiDouble(Scanner scanner) {
        while (true) {
            String s = scanner.nextLine().replace(",", ".");
            try {
                return Double.parseDouble(s.trim());
            } catch (NumberFormatException e) {
                System.out.print("Valore non valido. Inserisci un numero (es. 20): ");
            }
        }
    }
}

//        (1L, "Resident Evil Requiem", 2026, 0.0, "PC, console", 0, Genere.HORROR),
//        (2L, "Tides of Tomorrow", 2026, 0.0, "PS5", 0, Genere.AVVENTURA),
//        (3L, "007 First Light", 2026, 0.0, "XBOX", 0, Genere.STEALTH),
//        (4L, "Grand Theft Auto VI", 2026, 0.0, "PC", 0, Genere.AZIONE),
//        (5L, "ARC Raiders", 2026, 12.69, "PC", 0, Genere.SIMULAZIONE),
//        (6L, "Quarantine Zone: The Last Check", 2026, 0.0, "PC", 0, Genere.HORROR)
//
//        (11, "Nome in Codice", 2015, 24.98, 4-8, 30),
//        (12, "7 Wonders Duel", 2015, 27.90, 2, 30),
//        (13, "Scrabble", 1938, 19.90, 2-4, 60),
//        (14, "Monopoly", 1935, 29.90, 2-8, 60-180),
//        (15, "Risiko", 1957, 39.90, 2-5, 120-240),
//        (16, "Cluedo", 1949, 24.90, 3-6, 30-60)