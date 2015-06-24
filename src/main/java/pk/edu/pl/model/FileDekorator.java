package pk.edu.pl.model;

import java.util.List;


public class FileDekorator extends FileAbstract{
	FileAbstract file;

	public FileDekorator(FileAbstract f){
		this.addFile(f);
	}
	
	private void addFile(FileAbstract fIn){
		this.file = fIn;
	}

	//@Override
	public void writeItem(Item item) {
		// TODO Auto-generated method stub
		file.writeItem(item);
		String result = "\n" + item.getDate() + " " + Adapter.getPrintable(item) + "\n";
		System.out.println("w formacie :");
		System.out.println(result);
		
	}
	
	//@Override
	public List<Item> read() {
		return file.read();
	}
	

}
