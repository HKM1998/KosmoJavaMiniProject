package consolegame;

import java.util.Scanner;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.console.MainConsole;
import consolegame.console.TitleConsole;
import consolegame.event.EventMap;

public class Main {
	public static boolean hasSaveFile = false;
	public static Character character;
	public static EventMap eMap;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ConsolePrint.clear();

		// 세이브 파일 확인
		if (SaveFileUtil.isExistSaveFile()) {
			hasSaveFile = true;
		}

		// 메인화면 출력

		TitleConsole.start(scan);
		eMap = new EventMap();

		if (!hasSaveFile) {
			// 세이브 파일 없을때
			character = new Character();
		} else {

		}
		
		MainConsole.start(scan); // 메인 이벤트 시작
		
		
	}

}
