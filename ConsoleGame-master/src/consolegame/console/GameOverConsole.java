package consolegame.console;

import java.util.Scanner;

import consolegame.Main;

public class GameOverConsole {
	public static void start(Scanner scan) {
		if (Main.character.getHealth() < 1) {
			// 체력이 낮아서 죽은 경우 출력
			StringBuilder script = new StringBuilder();
			printGameOver();
			ConsolePrint.printConsole(script);
		} else if (Main.character.getMental() < 1) {
			// 정신력이 낮아서 죽은 경우 출력
			StringBuilder script = new StringBuilder();
			printGameOver();
			ConsolePrint.printConsole(script);
		} else // 그외에 출력 (ex, 바로 게임오버만)
			printGameOver();
			title: while (true) {
				switch (scan.next().toUpperCase()) {
				case "S":
					break title;
				case "E":
					ConsolePrint.finishGame(scan);
					break;
			}
		}
		return;
	}
	static void printGameOver() {
		// TitleConsole 출력부 와 동일한 구조로 게임오버 출력하게
		StringBuilder script = new StringBuilder();
		ConsolePrint.clear();
		script.append("   ####     ##     #    #   ######     ###    #    #   ######   #####   \r\n"
				+ "  ##  ##   #  #    ##  ##   #         ## ##   #    #   #        #    #  \r\n"
				+ " ##       #    #   # ## #   #        ##   ##  #    #   #        #    #  \r\n"
				+ " ##  ###  ######   # ## #   ####     ##   ##   #  #    ####     #####   \r\n"
				+ " ##   ##  #    #   #    #   #        ##   ##   #  #    #        #  #    \r\n"
				+ "  ## ###  #    #   #    #   #         ## ##     ##     #        #   #   \r\n"
				+ "   ### #  #    #   #    #   ######     ###      ##     ######   #    #  \r\n"
				+ "                                                                         ");
		ConsolePrint.printTitle(script);

		if (!Main.hasSaveFile) {
			System.out.println("[S] : 타이틀로 돌아가기\t [E] : 게임종료\n");
		}
	}
}
