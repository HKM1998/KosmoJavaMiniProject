package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

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

		selection.addSelection("그냥 들어본다.");
		
		selection.addSelection("그냥 간다.");
		
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
		// 0번 아이템ID 가 있는 경우 실행
		if (Item.hasItem(c, 000)) {
			c.removeItem(000);
		}

		// 무기가 있는경우 실행
		if (Item.hasItemType(c, "무기")) {
		}
	}
}
