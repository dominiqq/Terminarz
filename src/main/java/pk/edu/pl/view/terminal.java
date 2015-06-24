package pk.edu.pl.view;

import java.util.*;

public class terminal extends terminalMain{

	@Override
	public void launch() {
		int x =1;

		Scanner keyboard = new Scanner(System.in); //tworzy obiekt czytajacy z klawiatury

           
		while(x == 1){
			System.out.println("Wybierz opcje : ......");
			// wczytanie z klawiatury
			 x = keyboard.nextInt(); //zczytuje pierwszego inta
			// uruchomienie odpowiedniej opcji
			 if(x == 0)
				 break;
		}
		keyboard.close();
	}


	
}
