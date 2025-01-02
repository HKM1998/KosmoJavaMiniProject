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
		sb.append("[인벤토리]\n");
		if (Main.character.getItem().size() <= 0) {
			sb.append("소지중인 아이템이 없습니다.");
		} else {
			for (Item i : Main.character.getItem()) {
				sb.append(i.getItemId() + ". " + i.getName());
				sb.append("    ");
				count++;
				if (count > 5) {
					sb.append("\n");
					count = 0;
				}
			}
		}
		ConsolePrint.printConsole(sb);
        System.out.println("=".repeat(100));
        System.out.println("[E] : 돌아가기");

        while (!scan.next().toUpperCase().equals("E")) {}
    }
}
