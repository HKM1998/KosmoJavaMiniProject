package consolegame.console;

import java.util.Scanner;

import consolegame.Main;
import consolegame.item.Item;

public class InventoryConsole {
	public static void print(Scanner scan) {
        ConsolePrint.clear();
		StringBuilder sb = new StringBuilder();
        System.out.println("=".repeat(100));
		int count = 0;
		if (Main.character.getItem().size() <= 0) {
			sb.append("소지중인 아이템이 없습니다.\n");
		} else {
			for (Item i : Main.character.getItem()) {
				sb.append(i.getName());
				sb.append("\t");
				if (count > 5) {
					sb.append("\n");
					count++;
				}
			}
		}
		ConsolePrint.printConsole(sb);
        System.out.println("=".repeat(100));
        System.out.println("[E] : 돌아가기");

        while (!scan.next().toUpperCase().equals("E")) {}
    }
}
