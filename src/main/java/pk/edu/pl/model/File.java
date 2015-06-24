package pk.edu.pl.model;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class File extends FileAbstract{
    static String fileName = "db.csv";

    //zwraca liste itemow przeczytana z pliku bazy tekstowej
    public  List<Item> read() {
        List<Item> ret = new ArrayList<Item>(); //tworzy pusty obviekt listy
        String line = new String(); //bufor przechowywujacy jedna linie tekstu

        //jezeli w nawiasch po try wsadzimy taka konstrukcje to nie trzbea potem zamykac pliku, java sama to zrobi
        //wrapujemy tutaj obiekt filereadera zapewniajac mu buforowanie
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            while((line = in.readLine()) != null) {
                Item item = Adapter.stringToItem(line);
                ret.add(item);
            }

            //bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.err.println("Blad otwarcia pliku z danymi");
        }
        catch(IOException ex) {
            System.err.println("Blad czytania pliku z danymi");
        }

        return ret;
    }


    //zapisuje item w bazie tekstowej
    public  void writeItem(Item item) {
        String string = Adapter.itemToString(item); //konwersja itemu do stringu

        //instrukcje w nawiasach try, nie trzeba zamykac pliku
        //Filewriter to proste narzedzie do pisania do pliku, wrapujemy je zapewniajac mu bnuforowanie,
        //dodatkowe owrapowanie w printwriter daje nam dostep do funkcji println czyli pisania calej lini
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(File.fileName, true)))) {
            out.println(string);
        }
        catch (IOException e) {
            System.err.println("Blad zapisu, sprobuj ponownie");
            return;
        }

        System.out.println("Zadanie zostalo zapisane");
    }


}
