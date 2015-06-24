package pk.edu.pl.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

public class Adapter implements InterfaceForItem {
    static public String itemToString(Item item) { //zamienia obiekt typu Item na string do bazy tekstowej
        String out = new String();
        out = String.format("%s;%s;%s;%s;%s", //format stringu to elementy obiektu Item oddzielone dolarami ';'
            item.getOwner(),
            item.getJob(),
            item.getDate().format(Item.dateFormat),
            item.getStart().format(Item.timeFormat),
            item.getEnd().format(Item.timeFormat)
        );

        return out;
    }

    static public Item stringToItem(String string) {
        Item item = new Item();
        //rozbija string na tablice stringow w miejscach wystepowania znaku dolara i konwertuje tablice na liste stringow
        //lista stringow jest bezpieczneijsza w uzytkowaniu od tablicy
        List<String> container = Arrays.asList(string.split(";"));

        //zapisywanie kolejnych elementow listy do odpowiadajacych pol obiektu Item
        item.setOwner(container.get(0));
        item.setJob(container.get(1));
        item.setDate(container.get(2));
        item.setStart(container.get(3));
        item.setEnd(container.get(4));

        return item;
    }

    //zamienia obiekt Item na string do wyswietlenia w konsoli
    static public String getPrintable(Item item) {
        String out = new String();

        out = String.format("  [%s-%s] Wykonawca: %s, zadanie: %s\n", //formatowanie stringu
                item.getStart().format(Item.timeFormat),
                item.getEnd().format(Item.timeFormat),
                item.getOwner(),
                item.getJob()
        );
        return out;
    }

    static public String getTimeTable(List<Item> itemList) { //na podstawie posortowanej listy itemow tworzy sformatowany string do wyswietlenia na konsoli
        ZoneId zone = ZoneId.of("Europe/Warsaw"); //tworzy obiekt strefy czasowej na podstawie stringu
        LocalDate today = LocalDate.now(zone); //pobiekra aktualna date na podstawie obiektu strwefy czasowej

        String ret = new String(); //koncowy string
        LocalDate day = today; //cos w stylu iteratora
        while (day.compareTo(today.plusDays(7)) <= 0) { //tak dlugo az nie odliczy 7 dni od dnia dzisiejszego
            String buf = new String();

            for (Item it : itemList) { //iteruje po kazdym elemencie listy
                LocalDate date = it.getDate(); //zapisuje date elementu listy
                if (date.compareTo(day) == 0) { //jezeli jest taka sama jak rozpatrywanego dnia
                    buf += getPrintable(it); //dodaj do bufora
                }
            }

            if (buf.isEmpty()) { //jezeli na liscie nie ma ani jednej pozycji na rozpatrywany w tej iteracji dzien
                buf = "  Brak zadan\n";
            }

            ret += String.format("%s\n%s", day.format(Item.dateFormat), buf); //formatowanie sekcji dop formy: dzien\nlista zadan
            day = day.plusDays(1); //zmiana rozpatrywanego dnia na nastepny
        }
        return ret;
    }
}
