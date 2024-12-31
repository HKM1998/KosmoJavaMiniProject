package consolegame.console;

import java.util.Scanner;

import consolegame.Main;
import consolegame.event.Event;
import consolegame.event.Event000_Start;

public class MainConsole {
	public static void start(Scanner scan) {
		int eventCount = 0;

		EventConsole eventConsole = new EventConsole(new Event000_Start(), scan);
		eventConsole.start();

		while (true) {
			// 이벤트 (턴진행)
			try {
				Event nowEvent = Main.eMap.getEvent();// 어떤 이벤트를 진행했는지 확인
				eventConsole = new EventConsole(nowEvent, scan);
				eventConsole.start();
			} catch (Exception e) {

			}

			// 게임 오버
			if (!isAlive()) {
				GameOverConsole.start(scan);
				break;
			}
			eventCount++;
			if (eventCount > 15) {
				// 엔딩으로 넘어감
				EndingConsole.start(scan);
				break;
			}
		}
	}

	static boolean isAlive() {
		if (Main.character.getHealth() <= 0)
			return false;
		if (Main.character.getMental() <= 0)
			return false;

		return true;
	}
}
