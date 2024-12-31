package consolegame.console;

import java.util.Scanner;

import consolegame.Main;
import consolegame.Ending.Ending;
import consolegame.Ending.Ending001_GoodEnding;
import consolegame.Ending.Ending002_BadEnding;
import consolegame.Ending.Ending003_NormalEnding_01;
import consolegame.Ending.Ending004_NormalEnding_02;
import consolegame.Ending.Ending005_Philosophy;
import consolegame.Ending.Ending006_NormalEnding_04;
import consolegame.item.Item;

public class EndingConsole {

	public static void start(Scanner scan) {
		int endingId = getEndingId();
		Ending ending = null;
		if (endingId == 1) {
			ending = new Ending001_GoodEnding();
		} else if (endingId == 2) {
			ending = new Ending002_BadEnding();
		} else if (Item.hasItem(Main.character, 17)) {
			ending = new Ending005_Philosophy();
		} else {

			// 1~4 사이의 랜덤값
			switch ((int) (Math.random() * 100) % 2 + 1) {
			case 1:
				ending = new Ending003_NormalEnding_01();
				break;
			case 2:
				ending = new Ending004_NormalEnding_02();
				break;
			case 3:
				ending = new Ending006_NormalEnding_04();
				break;
			}
		}
		ending.printScript();

		// 입력 키에 따라 시작 종료
		System.out.println("[R] : 재시작\t [E] : 게임종료\n");

		title: while (true) {
			switch (scan.next().toUpperCase()) {
			case "R":
				break title;
			case "E":
				ConsolePrint.finishGame(scan);
				break;
			}
		}
	}

	static int getEndingId() {

		return 0;
	}
}
