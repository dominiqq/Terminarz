package pk.edu.pl.presenter;

import pk.edu.pl.view.terminalMain;

public class terminalHelp extends terminalMain{
	public void launch() {
		System.out.println("POMOC PROGRAMU TERMINARZ");
		System.out.println("   Usage: termianrz [-options]");
		System.out.println("     where options include:");
		System.out.println("       -version");
		System.out.println("       -help");
	}
}
