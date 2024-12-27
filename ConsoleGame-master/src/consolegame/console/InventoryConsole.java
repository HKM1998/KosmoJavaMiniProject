package consolegame.console;

import java.util.Scanner;

import consolegame.item.Item;

public class InventoryConsole {
	public void print(Item item) {
        ConsolePrint.clear();
//        if (item instanceof Weapon || item instanceof Armor) {
//            System.out.println("-----------------------------------------------------------");
//            System.out.println(item.getName() + "을(를) 장착하셨습니다!");
//            System.out.println("-----------------------------------------------------------");
//            try {
//                Thread.sleep(1500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }


    public String input(Scanner scan, int scene) {
        if (scene == 0) {//아이템 선택 화면
            ConsolePrint.clear();
            System.out.println("===========================================================");
            System.out.println("1. 무기        2. 방어구        3. 포션");
            System.out.println("===========================================================");
            System.out.println("0. 뒤로");
            System.out.println("");
            System.out.print("아이템을 선택해주세요:");
        } else if (scene == 1) {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("0. 뒤로");
            System.out.println("");
            System.out.print("장착할 무기를 선택해주세요:");
        } else if (scene == 2) {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("0. 뒤로");
            System.out.println("");
            System.out.print("장착할 방어구를 선택해주세요:");
        } else if (scene == 3) {
            System.out.println("1. 하급hp포션 사용        2. 중급hp포션 사용        3. 상급hp포션 사용");
            System.out.println("4. 하급mp포션 사용        5. 중급mp포션 사용        6. 상급mp포션 사용");
            System.out.println("-----------------------------------------------------------");
            System.out.println("0. 뒤로");
            System.out.println("");
            System.out.print("사용할 포션을 선택해주세요:");
        }
        return scan.next();
    }
}
