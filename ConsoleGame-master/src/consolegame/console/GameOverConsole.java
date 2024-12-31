package consolegame.console;

import java.util.Scanner;

import consolegame.Main;

public class GameOverConsole {
	public static void start(Scanner scan) {
		if(isLowHealth()) {
			// 체력이 낮아서 죽은 경우 출력
			StringBuilder script = new StringBuilder();
			printGameOver();
			ConsolePrint.printConsole(script);
		}
		else if(isLowMental()) {
			// 정신력이 낮아서 죽은 경우 출력
			StringBuilder script = new StringBuilder();
			printGameOver();
			ConsolePrint.printConsole(script);
		}
		else // 그외에 출력 (ex, 바로 게임오버만)
			printGameOver();
	}
	
	static void printGameOver() {
		// TitleConsole 출력부 와 동일한 구조로 게임오버 출력하게
	}

	static boolean isLowHealth() {
		if (Main.character.getHealth() < 1)
			return true;
		else
			return false;
	}
	static boolean isLowMental() {
		if (Main.character.getMental() < 1)
			return true;
		else
			return false;
	}
}
