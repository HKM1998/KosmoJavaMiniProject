package consolegame;

import java.util.Scanner;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.console.EndingConsole;
import consolegame.console.EventConsole;
import consolegame.console.TitleConsole;
import consolegame.event.Event;
import consolegame.event.Event000_Start;
import consolegame.event.EventMap;
import consolegame.thread.LoadingThread;

public class Main {
	static boolean hasSaveFile = false;
	static int eventCount = 0;
	public static Character character;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ConsolePrint.clear();

		// 세이브 파일 확인
		if (SaveFileUtil.isExistSaveFile()) {
			hasSaveFile = true;
		}

		// 메인화면 출력

		TitleConsole.consoleOut();
		// 입력 키에 따라 시작 종료
		if (!hasSaveFile) {
			System.out.println("[S] : 게임시작\t [E] : 게임종료\n");
		}
		title: while (true) {
			switch (scan.next().toUpperCase()) {
			case "S":
				break title;
			case "E":
				ConsolePrint.finishGame(scan);
				break;
			}
		}

		if (!hasSaveFile) {
			// 세이브 파일 없을때
			character = new Character();
		} else {

		}

		EventMap eMap = new EventMap();
		EventConsole eventConsole = new EventConsole(new Event000_Start(), scan);
		LoadingThread loading = new LoadingThread(); 
		eventConsole.start();

		while (true) {
			// 이벤트 (턴진행)
			try {
				Event nowEvent = eMap.getEvent();// 어떤 이벤트를 진행했는지 확인
				eMap.setEvent(nowEvent.getEventId()); 
				eMap.setEvent(eventCount);
				eventConsole = new EventConsole(nowEvent, scan);
				eventConsole.start();
				loading.setType("moveToNextEvent");
				Thread thread = new Thread(loading);
				thread.join();
			} catch (Exception e) {

			}

			// 게임 오버
			if (!isAlive()) {

			}
			eventCount++;
			if (eventCount > 10) {
				// 엔딩으로 넘어감
				break;
			}
		}

		while (true) {
			// 엔딩 (
			try {
				Event nowEvent = eMap.getEvent();
				character.addEvent(nowEvent); 
				EndingConsole ending = new EndingConsole(nowEvent, scan);
				ending.start();
				loading.setType("moveToNextEvent");
				Thread thread = new Thread(loading);
				thread.join();
			} catch (Exception e) {

			}
		}
		
		
	}

	static boolean isAlive() {
		if (character.getHealth() <= 0)
			return false;
		if (character.getMental() <= 0)
			return false;

		return true;
	}

}
