package consolegame.console;

import java.io.IOException;
import java.util.Scanner;

import consolegame.thread.LoadingThread;

public class ConsolePrint {
	// 화면 클리어
	@SuppressWarnings("deprecation")
	public static void clear() {
		try {
			Runtime.getRuntime().exec("cls");
		} catch (IOException e) {

		}

		for (int i = 0; i < 40; i++) {
			System.out.println("");
		}
	}

	// 타이틀 출력
	public static void printTitle(StringBuilder pSb) {
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

	// 일반 출력
	public static void printConsole(StringBuilder pSb) {
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
		System.out.println("=".repeat(100));
		// System.out.println(pSb.toString());

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

	// 선택지 출력
	public static void printSelection(StringBuilder pSb) {
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
			System.out.println("-".repeat(100) + "\n");
		}
	}

	// 선택지에 따른 결과 출력
	public static void printResult(StringBuilder pSb) {
		clear();

	}

	public static void printWrongInputMessage() {
		System.out.println("<잘못 입력하셨습니다. 다시 입력해주세요.>");
		System.out.println("");
	}

	public static void printWrongInputMessage(int count) {
		if (count == 1)
			System.out.println("<잘못 입력하셨습니다. 다시 입력해주세요.>");
		else {
			System.out.print("<잘못 입력하셨습니다. 1~" + count);
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
}
