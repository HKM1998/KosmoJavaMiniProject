package consolegame.console;

import java.util.Scanner;

import consolegame.item.Item;

public class InventoryConsole {
	public void print(Scanner scan) {
        ConsolePrint.clear();
        ConsolePrint.printItemList();

        title: while (true) {
			switch (scan.next().toUpperCase()) {
			case "E":
				break title;
			}
		}
    }
}
