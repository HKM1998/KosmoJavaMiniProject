package consolegame.console;

import java.util.Scanner;

import consolegame.Main;
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

	public static void printConsole(StringBuilder pSb, boolean isLoaded) {
		// 일반 출력
		if (isLoaded) {
			System.out.print(pSb.toString());
		} else {
			for (int i = 0; i < pSb.toString().length(); i++) {
				System.out.print(pSb.charAt(i));
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("=".repeat(100) + "\n");
	}

	public static void printScript(StringBuilder pSb, boolean isLoaded) {
		// 스크립트 출력
		System.out.println("=".repeat(100));
		printCharater(); // 캐릭터 현재 상태 출력
		if(isLoaded) {
			System.out.print(pSb.toString());
		}
		else {
			for (int i = 0; i < pSb.toString().length(); i++) {
				System.out.print(pSb.charAt(i));
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
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
			System.out.println("[I] : 소지 아이템 확인");
			System.out.println();
			System.out.println("-".repeat(100));
		}
	}

	public static void printSelection(StringBuilder pSb, boolean isLoaded) {
		// 선택지 출력
		String[] selection = pSb.toString().split("\t");
		System.out.println();
		for (String str : selection) {
			System.out.println("-".repeat(100));
			if(isLoaded) {
				System.out.print(str);
			}else {
				for (int i = 0; i < str.toString().length(); i++) {
					System.out.print(str.charAt(i));
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println("-".repeat(100));
		}
		System.out.println("[I] : 소지 아이템 확인");
	}
	
	public static void printResult(StringBuilder pSb) {
		// 선택지에 따른 결과 출력
		clear();
		System.out.println("=".repeat(100));
		printCharater(); // 캐릭터 현재 상태 출력
		printConsole(pSb);
		System.out.println("=".repeat(100));
	}
	
	public static void printResult(StringBuilder pSb, boolean isLoaded) {
		// 선택지에 따른 결과 출력
		clear();
		System.out.println("=".repeat(100));
		printCharater(); // 캐릭터 현재 상태 출력
		printConsole(pSb, isLoaded);
		System.out.println("=".repeat(100));
		System.out.println("[아무 키나 입력하여 진행]");
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
			System.out.println("[1] 네        [2] 아니오");
			System.out.println("");
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
		System.out.print("체력 : ");
		for (int i = 0; i < Main.character.getHealth(); i++) {
			System.out.print("♥");
		}
		System.out.print("\t");
		System.out.print("정신력 : ");
		for (int i = 0; i < Main.character.getMental(); i++) {
			System.out.print("■");
		}
		System.out.print("\t");
		System.out.print("소지금 : " + Main.character.getMoney() + "\n");
		System.out.println("=".repeat(100));
	}
}
