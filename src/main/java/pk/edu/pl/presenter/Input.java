package pk.edu.pl.presenter;

import pk.edu.pl.model.*;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Input implements presenter {
	//Scanner keyboard = new Scanner(System.in); //obiekt zycztujacy z klawiatury
    public static Item createItem() {
        Item item = new Item();

        //zczytanie wartosci Itemu
        String owner = printAndRead("Imie: ");
        String job = printAndRead("Zadanie: ");
        String date = printAndRead("Data (dd-mm-yyyy): ");
        String start = printAndRead("Godzina rozpoczecia zadania (hh:mm): ");
        String end = printAndRead("Godzina konca zadania: ");

        //kontrola poprawności
        if (owner.isEmpty() || job.isEmpty()) {
            System.err.println("Brakuje imienia lub zadania, sprobuj ponownie");
            return null;
        }


        try {
            item.setOwner(owner);
            item.setJob(job);
            item.setDate(date);
            item.setStart(start);
            item.setEnd(end);
        }
        catch (DateTimeParseException e) { //obsluga wyjatkow na wypadek podania nieprawidlowych danych
            System.err.println("Niepoprawny format daty lub czau, sprobuj ponownie");
            return null;
        }

        return item;
    }

    //wypisuje string i zczytuje wartosc z klawiatury
    private static Scanner keyboard = new Scanner(System.in);
    static String printAndRead(String str) {
        keyboard = new Scanner(System.in); //obiekt zycztujacy z klawiatury
        System.out.println(str); //wypisuje string dla uzytkownika
        String ret = keyboard.nextLine(); //czytanie az do napotkania znaku nowej lini
        return ret;
    }
    
    static void close(){
        keyboard.close();	
    }
}
