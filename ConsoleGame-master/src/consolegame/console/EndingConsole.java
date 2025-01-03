package consolegame.console;

import java.util.Random;
import java.util.Scanner;

import consolegame.Main;
import consolegame.ending.Ending;
import consolegame.ending.Ending001_Annihilate;
import consolegame.ending.Ending002_Guilt;
import consolegame.ending.Ending003_GoodDay;
import consolegame.ending.Ending004_UndergroundShelter;
import consolegame.ending.Ending005_Philosophy;
import consolegame.ending.Ending006_Outcast;
import consolegame.item.Item;

public class EndingConsole {

	public static void start(Scanner scan) {
		int endingId = getEndingId();
		Ending ending = getEndingObject(endingId);

		ending.printScript();

		// 입력 키에 따라 시작 종료
		System.out.println("[R] : 재시작\t [E] : 게임종료\n");

		title: while (true) {
			switch (scan.next().toUpperCase()) {
			case "R":
				break title;
			case "E":
				ConsolePrint.finishGame(scan);
				break title;
			}
		}
	}

	static int getEndingId() {
		int resultId = 0;
		if (Item.hasItem(Main.character, 1) 
				&& Item.hasItem(Main.character, 18) 
				&& !Item.hasItem(Main.character, 12)) {
			// 알수 없는 지도, 경찰의 친구 이고, 쓰레기짓 안 한 경우 굿엔딩
			resultId = 1;
		} else if (Item.hasItem(Main.character, 7) && Item.hasItem(Main.character, 12)) {
			// 사이코의사의 차트, 쓰레기짓 인경우 배드엔딩
			resultId = 2;
		} else if (Item.hasItem(Main.character, 17) && !Item.hasItem(Main.character, 12)) {
			// 철학2레벨, 쓰레기짓 안한 경우 철학엔딩
			resultId = 5;
		} else if (Item.hasItem(Main.character, 14)) {
			// 급똥 이벤트, 선택지 1로 인해 악취 아이템을 가지고 있을경우 노말엔딩2
			resultId = 4;
		}
		return resultId;
	}
	
	static Ending getEndingObject(int endingId) {
		switch(endingId) {
		case 1:return new Ending001_Annihilate();
		case 2:return new Ending002_Guilt();
		case 5:return new Ending005_Philosophy();
		case 4:return new Ending004_UndergroundShelter();
		default: // 특정 지정된 이벤트가 아닌 경우 노말 3개 이벤트 안에서 랜덤하게 출력
			switch (new Random().nextInt(2)) {
			case 0:
				return new Ending003_GoodDay();
			case 1:
				return new Ending006_Outcast();
			}
			return new Ending003_GoodDay(); // 디폴트 이벤트 변경 필요?
		}
	}
}
