package pk.edu.pl.presenter;

import pk.edu.pl.model.*;
import pk.edu.pl.view.terminalMain;

import java.util.*;

public class terminal extends terminalMain{

	FileAbstract fileMain = new File();
	FileAbstract file = new FileDekorator(fileMain);
	
	public void launch() {
		// TODO Auto-generated method stub
        System.out.println("TERMINARZ"); //naglowek
        int ret = 0; //ustawienie poczatkowej wartosci wyboru uzytkownika
        Scanner keyboard = new Scanner(System.in); //tworzy obiekt czytajacy z klawiatury

        while(ret != 3) { //powtarzaj az uzytkownik nie wybierze 3
            //String wyswietlajacy menu
            String intro = "Wybierz akcje:\n";
            intro += "1: Dodaj nowe zadanie\n";
            intro += "2: Wyswietl zadania na najblizszy tydzien\n";
            intro += "3: Zakoncz";

            keyboard = new Scanner(System.in); //tworzy obiekt czytajacy z klawiatury
            System.out.println(intro); //wyswietla menu
            try {
                ret = keyboard.nextInt(); //zczytuje pierwszego inta
            }
            catch (InputMismatchException e) { //na wypadek glupoty uzytkownika
                System.err.println("Blad. Wybierz ponownie akcje:");
                continue;
            }

            switch (ret) {
                case 1: //tworzenie nowego rekordu
                    Item item = Input.createItem();
                    if (item != null) { //jezeli wszystko poszlo ok
                        file.writeItem(item); //zapisz do bazy tekstowej
 ///------------- wyświetlenie przyjętego zadania 
                    }
                    break;
                case 2: //wyswietlanie zadan, sortowanie po dacie i starcie zadania
                    List<Item> itemList = file.read(); //zycztaj rekordy z bazy tekstowej
                    Collections.sort(itemList); //sortuj (wedlug regul opisanych w metodach 'comapare' w klasie Item)

                    String string = Adapter.getTimeTable(itemList); //Przygotowuje terminarz na 7 dni
                    System.out.println(string); //wyswietl go
                    break;
                case 3: //instrukcja wyjscia z programu
                    break;
                default: //na wypadek glupoty uzytkownika
                    System.err.println("Blad. Wybierz ponownie akcje:");
                    ret = 0;
                    break;
            }
            
        }
        keyboard.close();
		System.out.println("== end ==");
		
	}


	
}
