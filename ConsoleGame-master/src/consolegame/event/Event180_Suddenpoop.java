package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event180_Suddenpoop extends Event {
	public Event180_Suddenpoop() {
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

		selection.addSelection(" 꾸르르르르르... 윽..힘들더라도 조금만 참고 얼른 버려진 건물을 찾아보자.. ");
		
		selection.addSelection(" 아흑... 참기 너무 힘든거 같다..근처 풀밭이라도 가서 해결하자. ");
		
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
		script.append(" 크흡.. 걷던 도중 대장의 움직임이 심상치 않다. 아무래도 당장이라도 지릴것 같다.\n");
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
