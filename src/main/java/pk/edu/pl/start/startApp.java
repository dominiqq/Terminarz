package pk.edu.pl.start;

import pk.edu.pl.presenter.terminal;
import pk.edu.pl.view.*;

public class startApp {

	public static void main(String[] args) {
		terminalMain term;
		
		if (args.length == 1 && args[0].equals("-version")) 
			term = new terminalMain();
		else
			term = new terminal();

		term.launch();
	}

}
