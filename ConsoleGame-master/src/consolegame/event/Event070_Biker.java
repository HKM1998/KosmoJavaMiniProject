package consolegame.event;

import java.util.Random;

import consolegame.Main;
import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item004_FirstAidKit;
import consolegame.item.Item006_Ammunition;

public class Event070_Biker extends Event {
	public Event070_Biker() {
		setEventId(070);
		setName("폭주족");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice() {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("싸운다");
		
		selection.addSelection("도망친다");
		this.setsCount(selection.count);
		selection.print();
	}

	// 이벤트 스크립트 바로 화면에 출력
	@Override
	public void printScript() {
		// 화면 출력 스크립트 작성 형식은 추후 지정할 예정
		// 아래는 예시
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("묵묵히 걷고 있던 중 멀리서 굉음을 내며 폭주족이 달려 온다.\n");
		script.append("주인공을 이내 감싸더니 무리의 리더가 접근하며 얘기한다.\n");
		script.append("조용히 가지고 있는걸 내 놓고 가라.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder sb = new StringBuilder();
		if (pChoice.equals("1")) { // 1번을 골랐을 경우 공격하기
			if (Item.hasItem(Main.character, 000)) { // 칼을 가지고 있을 경우 공격

				Random random = new Random();

				if (random.nextInt(10) < 1) {                     // 칼은 90% 확률로 패배 후 체력 -2
					Main.character.setHealth(Main.character.getHealth() - 2);
				} else if (!Item.hasItemType(Main.character, "Ammunition")) { // 아이템 Ammunition 클래스 임포트
					Main.character.getItem().add(new Item006_Ammunition());   // 10% 확률로 승리시 탄약이 없을때 추가
				} else {
					Main.character.getItem().add(new Item006_Ammunition());   // 10% 확률로 승리시 탄약이 있을 때도 추가
				}

			}
			if (Item.hasItem(Main.character, 8)) {                            // 총을 가지고 있을 경우 공격

				Random random1 = new Random();
				if (random1.nextInt(10) < 0) {                   // 총은 50% 확률로 패배 후 체력 -2, 50% 확률로 승리 후 구급상자 획득
					Main.character.setHealth(Main.character.getHealth() - 2);
				} else if (!Item.hasItemType(Main.character, "Ammunition")) { // 기존에 구급상자 없을 경우 추가
					Main.character.getItem().add(new Item006_Ammunition());
				} else { // 기존에 구급상자 있을 때도 추가
					Main.character.getItem().add(new Item006_Ammunition());
				}
			}
		if (pChoice.equals("2")) {
			Main.character.setHealth(Main.character.getHealth() - 1);                      // 2번 도망친다 선택시 체력 -1
		}

		}
		ConsolePrint.printResult(sb, getIsLoaded());
	}
}
