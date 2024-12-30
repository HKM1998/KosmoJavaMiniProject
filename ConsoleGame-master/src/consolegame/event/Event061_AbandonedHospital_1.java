package consolegame.event;

import java.util.Random;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item004_FirstAidKit;
import consolegame.item.Item005_PainKiller;

public class Event061_AbandonedHospital_1 extends Event {
	public Event061_AbandonedHospital_1() {
		setEventId(061);
		setName("폐병원_1");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice() {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("뒷통수 습격");
		
		selection.addSelection("몰래 뒷 선반에 있는 진통제를 빼돌려 나온다");
		this.setsCount(selection.count);
		selection.print();
	}

	// 이벤트 스크립트 바로 화면에 출력
	@Override
	public void printScript() {

		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("어떤 눈이 퀭한 미친 의사가 마취도 없이 멀쩡해 보이는 인간의 장기를 꺼내고 있다.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder sb = new StringBuilder();
		if (pChoice.equals("1")) { // 1번을 골랐을 경우 공격하기
			if (Item.hasItem(Main.character, 000)) { // 칼을 가지고 있을 경우 공격

				Random random = new Random();

				if (random.nextInt(10) < 4) { // 칼은 40% 확률로 패배 후 체력-1
					Main.character.setHealth(Main.character.getHealth() - 1);
				} else if (!Item.hasItemType(Main.character, "FirstAidKit")) { // 아이템 FirstAidKit 클래스 임포트
					Main.character.getItem().add(new Item004_FirstAidKit()); // 10% 확률로 승리시 구급상자가 없을때 추가
				} else {
					Main.character.getItem().add(new Item004_FirstAidKit()); // 10% 확률로 승리시 구급상자가 있을 때도 추가
				}

			}
			if (Item.hasItem(Main.character, 8)) { // 총을 가지고 있을 경우 공격

				Random random1 = new Random();
				if (random1.nextInt(10) < 0) { // 총은 % 확률로 패배 후 체력 -1, 100% 확률로 승리 후 구급상자 획득
					Main.character.setHealth(Main.character.getHealth() - 1);
				} else if (!Item.hasItemType(Main.character, "FirstAidKit")) { // 기존에 구급상자 없을 경우 추가
					Main.character.getItem().add(new Item004_FirstAidKit());
				} else { // 기존에 구급상자 있을 때도 추가
					Main.character.getItem().add(new Item004_FirstAidKit());
				}
			}

		}
		if (pChoice.equals("2")) {
			if (!Item.hasItem(Main.character, 005)) {
				Main.character.getItem().add(new Item005_PainKiller()); // 2번 선택시 진통제만 가져간다
			}
		}
		ConsolePrint.printResult(sb, getIsLoaded());
	}
}
