package consolegame.console;

import java.util.Scanner;

import consolegame.Main;
import consolegame.event.Event;

public class EndingConsole {
	Event event;
	public Scanner scan;
	
	public EndingConsole(Event event, Scanner scan) {
		this.event = event;
		this.scan = scan;
	}
	
	public void start() {
		event.print(Main.character);
		String input;
		while(true) {
			try {
				input = scan.next();
				if(Integer.parseInt(input) > event.getsCount() || Integer.parseInt(input) <= 0) {
					ConsolePrint.printWrongInputMessage(event.getsCount());
					continue;
				}else {
					break;
				}
			}
			catch(Exception e){ continue;}
		}
		event.getResult(Main.character, input);
		while(true) {
			try {
				input = scan.next();
				break;
			}
			catch(Exception e){ continue;}
		}
		
	}
}
