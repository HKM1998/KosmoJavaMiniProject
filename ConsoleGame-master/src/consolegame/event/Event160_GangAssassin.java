package consolegame.event;

import java.util.Random;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item004_FirstAidKit;
import consolegame.item.Item006_Ammunition;

public class Event160_GangAssassin extends Event {
	public Event160_GangAssassin() {
		setEventId(160);
		setName("갱단암살");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice(Character c) {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("아이를 이용하는 그 갱단을 쫓아가 처치한다");

		selection.addSelection("그 아이를 죽이고 떠난다");
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
		script.append("이 건물 저 건물 들어가며 물건을 뒤지던 주인공은\n");
		script.append("어느날 자전거를 타고 있던 아이를 조우한다.\n");
		script.append("그런데 이 아이는 뭔가 뒤에서 미행을 하는 듯한 느낌이 든다. \n");
		script.append("아이이기에 애써 무시하고 가지만 이내 총성이 뒤에서 들린다.\n");
		script.append("그 구역을 장악하고 있던 갱단이 뒤에서 조종하고 있던 아이였다.\n");
		script.append("멀리 주차된 곳에서 몰래 보며 그 아이에게 시킨것이다. .\n");
		script.append("구역 침범에 대한 보복이다.\n");
		script.append("그는 분노하며 반응한다.\n");

		ConsolePrint.printScript(script);
	}

	@Override
	public void getResult(Character c, String pChoice) {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		if (pChoice.equals("1")) { // 1번을 골랐을 경우 공격하기
			if (Item.hasItem(c, 000)) { // 칼을 가지고 있을 경우 공격

				Random random = new Random();

				if (random.nextInt(10) < 8) { // 칼은 80% 확률로 패배 후 체력-1
					c.setHealth(c.getHealth() - 1);
				} else if (!Item.hasItemType(c, "Ammunition")) { // 아이템 Ammunition 클래스 임포트
					c.getItem().add(new Item006_Ammunition()); // 20% 확률로 승리시 탄약이 없을때 추가
				} else {
					c.getItem().add(new Item006_Ammunition()); // 20% 확률로 승리시 탄약이 있을 때도 추가
				}

			}
			if (Item.hasItem(c, 8)) { // 총을 가지고 있을 경우 공격

				Random random1 = new Random();
				if (random1.nextInt(10) < 2) { // 총은 20% 확률로 패배 후 체력 -1, 80% 확률로 승리 후 탄약 획득
					c.setHealth(c.getHealth() - 1);
				} else if (!Item.hasItemType(c, "Ammunition")) { // 기존에 탄약 없을 때 추가
					c.getItem().add(new Item006_Ammunition());
				} else {
					c.getItem().add(new Item006_Ammunition()); // 기존에 탄약 있을 때도 추가
				}
			}

		} else if (pChoice.equals("2")) { // Weird to Bad엔딩 루트로 가는 선결조건)
			script.append("그는 아이에게 사정없이 총을 난사했다.");
		}
		
		ConsolePrint.printResult(script); // 결과 출력부
	}
}
