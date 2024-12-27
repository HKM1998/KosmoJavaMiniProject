package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event091_MerchantFamily_1 extends Event {
	public Event091_MerchantFamily_1() {
		setEventId(91);
		setName("상인가족_1");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice(Character c) {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection(" 배고픔에 굶주려 허겁지겁 먹는다");
		
		selection.addSelection(" 한번 스프의 냄새부터 음미한다");
		
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
		script.append("밥 한끼 드리는거야 무슨 문제겠습니까? 와서 몸 좀 녹이시지요. ");
		script.append("장작 앞에서 몸을 녹이는 동안 스프가\n");
		script.append("식탁에 준비되었다.\n");

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
