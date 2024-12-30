package consolegame.console;

import java.util.Scanner;

import consolegame.Main;
import consolegame.event.Event;

public class EventConsole {
	Event event;
	public Scanner scan;
	
	public EventConsole(Event event, Scanner scan) {
		this.event = event;
		this.scan = scan;
	}
	
	
	public void start() {
		event.print(Main.character);
		while(true) {
			String input;
			try {
				input = scan.next();
				if(Integer.parseInt(input) > event.getsCount() || Integer.parseInt(input) <= 0) {
					ConsolePrint.printWrongInputMessage(event.getsCount());
					continue;
				}else {
					event.getResult(Main.character, input);
					break;
				}
			}
			catch(Exception e){ continue;}
		}
	}
}
