package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item002_Bible;

public class Event020_FakeReligion extends Event {
	public Event020_FakeReligion() {
		setEventId(020);
		setName("사이비종교");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice(Character c) {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("1.그냥 들어본다.");

		selection.addSelection("2.그냥 간다.");

		// 특정 아이템 조회 후 사용
//		if (Item.hasItem(c, 000))
//			// 아이템 id 가 000인 아이템이 있는지
//			selection.addSelection("");
//
//		// 무기류 전체 확인
//		for (Item i : Item.findItemType(c, "무기")) {
//			if(i.getItemId() == 000) {
//				
//			}else if(i.getItemId() == 000) {
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
		script.append("어느 아줌마가 웃으며 접근한다.\n");
		script.append("이 세상이 이렇게 된건 믿음이 부족해서라 한다.\n");
		script.append("한번 좋은 말씀 들어보지 않겠냐며 권유한다.\n");

		ConsolePrint.printScript(script);
	}

	@Override
	public void getResult(Character c, String pChoice) {
		StringBuilder script = new StringBuilder(); // 1번 선택시 Good 엔딩 루트의 Bad엔딩 선결조건 중 하나
		script.append(getEventId() + ". " + getName() + "\n");

		if (pChoice.equals("1")) { // 1번 선택 시 나오는 대사 추가
			script.append("일장연설을 듣고 나니 기가 다 빠진다.\n");
			script.append("그러나 아줌마는 이것도 인연이라며 성경을 선물한다\n");
			c.addItem(new Item002_Bible());
			script.append("\n아줌마에게서 성경을 얻었습니다.(+ 성경)\n");
		} else if (pChoice.equals("2")) {
			script.append("당신은 너무 지친 나머지 이야기를 듣지않고 지나쳤습니다.\n");
		}

	}
}
