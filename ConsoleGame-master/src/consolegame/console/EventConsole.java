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
		event.print();
		String input;
		while(true) {
			try {
				input = scan.next();
				if(input.toUpperCase() == "I") {
					ConsolePrint.printItemList();
					event.print();
				}
				else if(Integer.parseInt(input) > event.getsCount() || Integer.parseInt(input) <= 0) {
					ConsolePrint.printWrongInputMessage(event.getsCount());
					continue;
				}else {
					break;
				}
			}
			catch(Exception e){ continue;}
		}
		event.getResult(input);
		while(true) {
			try {
				input = scan.next();
				break;
			}
			catch(Exception e){ continue;}
		}
		
	}
}
