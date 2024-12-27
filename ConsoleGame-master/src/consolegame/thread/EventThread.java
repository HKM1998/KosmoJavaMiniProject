package consolegame.thread;

import java.util.InputMismatchException;
import java.util.Scanner;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.event.Event;

public class EventThread implements Runnable {
	Event event;
	public Scanner scan;
	
	public EventThread(Event event) {
		this.event = event;
	}
	
	@Override
	public void run() {
		// 
		event.print(Main.character);
		while(true) {
			String input;
			try {
				input = scan.next();
				if(Integer.parseInt(input) > event.getsCount() || Integer.parseInt(input) < 0) {
					ConsolePrint.printWrongInputMessage(event.getsCount());
					continue;
				}else {
					event.getResult(Main.character, input);
				}
			}
			catch(InputMismatchException e){ continue;}
		}
	}

}
