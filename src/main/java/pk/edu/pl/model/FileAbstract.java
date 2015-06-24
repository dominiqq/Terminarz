package pk.edu.pl.model;

import java.util.List;

abstract public class FileAbstract {
	public List<Item> read() {
		return null;
	}
	public abstract void writeItem(Item item);
}
