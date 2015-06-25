package pk.edu.pl.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class Item implements InterfaceForItem , Comparator<Item>, Comparable<Item>{
    LocalTime start;
    LocalTime end;
    LocalDate date;
    String owner;
    String job;
    static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy"); //obiekt definujacy formatowanie daty
    static DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm"); //obiekt definujacy formatowanie czasu

    //metody ustawiajace wartosci pol prywatnych
	public void setStart(String start) {
        this.start = LocalTime.parse(start, this.extracted());
    }

	private DateTimeFormatter extracted() {
		return timeFormat;
	}

    public void setEnd(String end) {
        this.end = LocalTime.parse(end, this.extracted());
    }

    public void setDate(String date) {
        this.date = LocalDate.parse(date, this.extracted2());
    }

	private DateTimeFormatter extracted2() {
		return dateFormat;
	}

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getJob() {
        return this.job;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public LocalTime getStart() {
        return this.start;
    }

    public LocalTime getEnd() {
        return this.end;
    }

    //przeciazenie metod definujacych wynik operacji porownania (tzn czy obiekt klasy na ktorej wywowalismy funkcje jest mniejszy/rowny/wiekszy od Itemu B))
    public int compareTo(Item item){
        int comp = this.date.compareTo(item.getDate());
        if (comp == 0) {
            return this.start.compareTo(item.getStart());
        }
        return comp;
    }

    //przeciazenie metod definujacych wynik operacji porownania (tzn czy Item A jest mniejszy/rowny/wiekszy od Itemu B))
    public int compare(Item first, Item second){
        int comp = first.getDate().compareTo(second.getDate());
        if (comp == 0) {
            return first.getStart().compareTo(second.getStart());
        }
        return comp;
    }
}
