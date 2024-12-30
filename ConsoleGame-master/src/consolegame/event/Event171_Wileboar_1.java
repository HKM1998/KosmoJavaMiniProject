package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event171_Wileboar_1 extends Event {
	public Event171_Wileboar_1() {
		setEventId(171);
		setName("맷돼지 조우_1");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice(Character c) {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection(" 나이프 소지 시 : 맷돼지의 목덜미를 찌른다");
		
		selection.addSelection(" 돌맹이를 던진다. ");
		
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
		script.append("안되 이런 맷돼지의 가죽이 너무 질기다 , 상대가 너무 강하다. 으아악!!!!!\n");
		script.append(" 뀌에에에에에에엑!!!!!!!! 뿌직!! 콱!!! \n");
		script.append("끄아아아아아악!!!!! 내 팔이!!!! 끄아아아 아파!!! 퍽!!!!! ㄴ어흑.. 눈앞이 깜깜해진다..\n");

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
