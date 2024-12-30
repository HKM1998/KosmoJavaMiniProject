package consolegame.console;

import java.io.IOException;
import java.util.Scanner;

import consolegame.Main;
import consolegame.character.Character;
import consolegame.item.Item;
import consolegame.thread.LoadingThread;

public class ConsolePrint {
	// 화면 클리어
	public static void clear() {
		for (int i = 0; i < 40; i++) {
			System.out.println("");
		}
	}

	public static void printTitle(StringBuilder pSb) {
		// 타이틀 출력
		for (int i = 0; i < pSb.toString().length(); i++) {
			System.out.print(pSb.charAt(i));
			try {
				if (i % 15 == 0)
					Thread.sleep(70);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n");
	}

	public static void printConsole(StringBuilder pSb) {
		// 일반 출력
		for (int i = 0; i < pSb.toString().length(); i++) {
			System.out.print(pSb.charAt(i));
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}

	public static void printScript(StringBuilder pSb) {
		// 스크립트 출력
		System.out.println("=".repeat(100));
		printCharater(); // 캐릭터 현재 상태 출력
		for (int i = 0; i < pSb.toString().length(); i++) {
			System.out.print(pSb.charAt(i));
//			try {
//				Thread.sleep(20);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		System.out.println("=".repeat(100) + "\n");
	}

	public static void printSelection(StringBuilder pSb) {
		// 선택지 출력
		String[] selection = pSb.toString().split("\n");
		System.out.println();
		for (String str : selection) {
			System.out.println("-".repeat(100));

			for (int i = 0; i < str.toString().length(); i++) {
				System.out.print(str.charAt(i));
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println();
			System.out.println("-".repeat(100));
		}
	}

	public static void printResult(StringBuilder pSb) {
		// 선택지에 따른 결과 출력
		clear();
		System.out.println("=".repeat(100));
		printCharater(); // 캐릭터 현재 상태 출력
		printConsole(pSb);
		System.out.println("=".repeat(100));
	}

	public static void printWrongInputMessage() {
		System.out.println("<잘못 입력하셨습니다. 다시 입력해주세요.>");
		System.out.println("");
	}

	public static void printWrongInputMessage(int pCount) {
		if (pCount == 1)
			System.out.println("<잘못 입력하셨습니다. 다시 입력해주세요.>");
		else {
			System.out.print("<잘못 입력하셨습니다. 1~" + pCount);
			System.out.println("사이의 값을 입력해주세요.>");
		}
		System.out.println();
	}

	// 게임종료화면
	public static void finishGame(Scanner scan) {

		while (true) {
			for (int i = 0; i < 60; i++) {
				System.out.println("");
			}
			System.out.println("게임을 종료하시겠습니까?");
			System.out.println("1. 네        2. 아니오");
			System.out.println("");
			System.out.print("입력:");
			String inputStr = scan.next();
			if (inputStr.equals("1")) {
				ConsolePrint.clear();

				Thread finishGame = new Thread(new LoadingThread("finishGame"));
				finishGame.start();
				try {
					finishGame.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				scan.close();
				System.exit(0);
			} else if (inputStr.equals("2")) {
				break;
			} else {
				printWrongInputMessage();
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}
	
	public static void printCharater() {
		// 현재 캐릭터의 상태를 출력하는 메서드
		Character c = Main.character;
		System.out.print("체력 : ");
		for(int i = 0; i < c.getHealth(); i++) {
			System.out.print("♥");
		}
		System.out.print("\t");
		System.out.print("정신력 : ");
		for(int i = 0; i < c.getHealth(); i++) {
			System.out.print("■");
		}
		System.out.print("\t");
		System.out.print("소지금 : " + c.getMoney()+"\n");
		System.out.println("=".repeat(100));
	}
	
	public static void printItemList() {
		// 캐릭터가 소지중인 아이템 리스트 출력
		Character c = Main.character;
		clear();
		System.out.println("=".repeat(100));
		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(c.getItem().size() <= 0) {
			sb.append("소지중인 아이템이 없습니다.\n");
		}
		else {
			for(Item i : c.getItem()) {
				sb.append(i.getName());
				sb.append("\t");
				if(count > 5) {
					sb.append("\n");
					count++;
				}
			}
		}
		sb.append("[E] : 돌아가기\n");
		printConsole(sb);
	}
}
