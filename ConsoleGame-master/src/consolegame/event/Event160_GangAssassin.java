package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

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

		selection.addSelection(" 칼 200");
		
		selection.addSelection(" 탄약 1개 ");
		
//		// 특정 아이템 조회 후 사용
//		if (Item.hasItem(c, 000))
//			// 아이템 id 가 000인 아이템이 있는지
//			selection.addSelection("아이템 0번을 먹는다. 체력 +2");
//
//		// 무기류 전체 확인
//		for (Item i : Item.findItemType(c, "무기")) {
//			if(i.getItemId() == 000) {
//				
//			}else if(i.getItemId() == 001) {
//				
//			}
//		}


		selection.print();
	}

	// 이벤트 스크립트 바로 화면에 출력
	@Override
	public void printScript() {
		// 화면 출력 스크립트 작성 형식은 추후 지정할 예정
		// 아래는 예시
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append(".\n");
		script.append("이 건물 저 건물 들어가며 물건을 뒤지던 주인공은 어느날 자전거를 타고 있던 아이를 조우한다.");
		script.append("그런데 이 아이는 뭔가 뒤에서 미행을 하는 듯한 느낌이 든다. \n");
		script.append("아이이기에 애써 무시하고 가지만 이내 총성이 뒤에서 들린다.\n");
		script.append("그 구역을 장악하고 있던 갱단이 뒤에서 조종하고 있던 아이였다.\r\n");
		script.append("먼 곳 주차된 곳에서 몰래 보며 그 아이에게 시킨것이다. 구역 침범에 대한 보복이다.\n");
		script.append("그는 분노하며 반응한다.\n");

		ConsolePrint.printScript(script);
	}

	@Override
	public void getResult(Character c, String pChoice) {
		// 0번 아이템ID 가 있는 경우 실행
		if (Item.hasItem(c, 000)) {
			c.removeItem(000);
		}

		// 무기가 있는경우 실행
		if (Item.hasItemType(c, "무기")) {
		}
	}
}
