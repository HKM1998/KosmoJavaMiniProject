package consolegame.console;

import java.util.Scanner;

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
		event.setLoaded(true);
		String input;
		while (true) {
			try {
				input = scan.next();
				if (input.toUpperCase().equals("I")) {
					InventoryConsole.print(scan);
					event.print();
					continue;
				} else if (Integer.parseInt(input) > event.getsCount() || Integer.parseInt(input) <= 0) {
					ConsolePrint.printWrongInputMessage(event.getsCount());
					continue;
				} else {
					break;
				}
			} catch (Exception e) {
				continue;
			}
		}
		event.setLoaded(false);
		event.printResult(input);
		event.setLoaded(true);
		while (true) {
			try {
				input = scan.next();
				if (input.toUpperCase().equals("I")) {
					InventoryConsole.print(scan);
					event.printResult(input);
					continue;
				} else {
					break;
				}

			} catch (Exception e) {
				continue;
			}			
		}
		event.setLoaded(false);
	}
}
