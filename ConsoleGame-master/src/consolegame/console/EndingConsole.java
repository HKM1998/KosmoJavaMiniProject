package consolegame.console;

import java.util.Scanner;

import consolegame.Ending.Ending;
import consolegame.Ending.Ending001_GoodEnding;
import consolegame.Ending.Ending002_BadEnding;
import consolegame.Ending.Ending003_NormalEnding_01;
import consolegame.Ending.Ending004_NormalEnding_02;
import consolegame.Ending.Ending005_NormalEnding_03;
import consolegame.Ending.Ending006_NormalEnding_04;

public class EndingConsole {

	public static void start(Scanner scan) {
		int endingId = getEndingId();
		Ending ending = null; 
		if (endingId == 1) {
			ending = new Ending001_GoodEnding();
		} else if (endingId == 2) {
			ending = new Ending002_BadEnding();
		} else {
			// 1~4 사이의 랜덤값
			switch ((int) (Math.random() * 100) % 3 + 1) {
			case 1:
				ending = new Ending003_NormalEnding_01();
				break;
			case 2:
				ending = new Ending004_NormalEnding_02();
				break;
			case 3:
				ending = new Ending005_NormalEnding_03();
				break;
			case 4:
				ending = new Ending006_NormalEnding_04();
				break;
			}
		}
		ending.printScript();
	}

	static int getEndingId() {

		return 0;
	}
}
