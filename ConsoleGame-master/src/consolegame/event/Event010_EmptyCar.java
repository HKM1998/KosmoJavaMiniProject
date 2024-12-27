package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item001_Passport;

public class Event010_EmptyCar extends Event {
	public Event010_EmptyCar() {
		setEventId(010);
		setName("빈차");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice(Character c) {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("칼.");
		

		selection.addSelection(" 어느 모르는 사람의 여권.");
		
		
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
		script.append("으슥한 곳에 숨겨져 있는 자동차를 발견한다.\n");
		script.append("안에 사람이 있는 지 확인 해 보고 주위에 사람이 없는지 확인한 뒤 창문을 깬다.\n");
		script.append("차량에 열쇠는 없어서 운전은 불가하다.\n");
		script.append("앞좌석 대신 앞좌석 서랍을 여니 칼1개와 여권이 있다.\n");

		ConsolePrint.printScript(script);
	}

	@Override
	public void getResult(Character c, String pChoice) {
		
		if (pChoice.equals("1")) {

			// 무기가 있는경우 실행
			if (Item.hasItemType(c, "Knife")) {
			}
		}
		else if (pChoice.equals("2")) {

			// 0번 아이템ID 가 있는 경우 실행
			if (!Item.hasItem(c, 001)) {
				c.getItem().add(new Item001_Passport());
			}
		}

		
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("\n");
		script.append("\n");
	}
}
