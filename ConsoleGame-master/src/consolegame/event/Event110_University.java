package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event110_University extends Event {
	public Event110_University() {
		setEventId(110);
		setName("성균관대학교");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice(Character c) {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("쫓기고 있는 본인의 상황에 대한 설명과 자유민주주의에 대한 본인의 신념을 설파하고 떠난다.");
		
		selection.addSelection("그 어떤 신념도 현실적인 무력을 일정 정도 갖추지 않으면 무위라는걸 알리며\n");
		selection.addSelection("본인의 상황을 예로 들고, 현실적인 힘도 갖추기를 강력하게 제안하고 떠난다.\n");
		
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
		script.append("큰 대학을 마주쳤다. 이 대학의 중심 연단에는 수많은 학생들이 모여");
		script.append("난립하는 세상을 어떻게 운영 해야 하는지에 대한 토론이 이루어지고 있다.\n");
		script.append("주인공은 무엇인가에 홀린 듯 연단에 갑자기 올라 가더니 마이크를 잡는다.\n");

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
