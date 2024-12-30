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

		selection.addSelection("싸웁니다.");
		
		selection.addSelection("도망칩니다.");
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
		script.append("당신은 오늘도 묵묵히 걷고 있습니다.\n");
		script.append("그러다 이제는 인적이 드문 넓은 4차선 왕복도로 를 걷는 중입니다.\n");
		script.append("그런데 저 멀리서 오토바이 무리가 뿌연 매연을 날리며 우리에게 다가옵니다.\n");
		script.append("제발 지나가라 지나가라..애원하지만 뭔가 나에게 다가올 수록 속도가 늦쳐집니다.\n");
		script.append("그러다 폭주족 무리는 이내 원을 그리며 주인공을 감쌉니다.\n");
		script.append("당신은 겁에 질려 있는 와중에 무리의 리더로 보이는 사람이 천천히 접근합니다.\n");

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
