package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event181_Suddenpoop_1 extends Event {
	public Event181_Suddenpoop_1() {
		setEventId(170);
		setName("급똥");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice(Character c) {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection(" 당장 바지를 내리고 똥을 싼다(정신력-1). ");
		
		selection.addSelection(" 안된다.. 최소한의 인간으로서의 존엄성을 지키자 저앞 공터의 풀밭이 코앞이다..그렇지만.. 무언가 축축하고 불길한 기분이 든다. 저질러버린것 같다.(정신력 -2)");
		
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
		script.append(" 끄아아악... 안되겠다.. 지금 당장이라도 끄으윽;;?\n");
		script.append("\n");
		script.append("\n");

		ConsolePrint.printScript(script);
	}

	@Override
	public void getResult(Character c, String pChoice) {
		// 0번 아이템ID 가 있는 경우 실행
		if (Item.hasItem(c, 000)) {
			c.removeItem(000);
		}

		// 생필품이 있는경우 실행
		if (Item.hasItemType(c, "휴지")) {
		}
	}
}
