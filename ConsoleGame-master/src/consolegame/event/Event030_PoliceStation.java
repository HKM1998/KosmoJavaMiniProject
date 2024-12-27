package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event030_PoliceStation extends Event {
	public Event030_PoliceStation() {
		setEventId(030);
		setName("경찰서");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice(Character c) {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection(" 어쩌다가 혼자 이렇게 남게 됐나요?.");
		
		selection.addSelection("그냥 무시하고 무기만 탈취 하려 한다");
		
//		// 특정 아이템 조회 후 사용
//		if (Item.hasItem(c, 000))
//			// 아이템 id 가 000인 아이템이 있는지
//			selection.addSelection("");
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
		script.append("경찰서를 들어 갔는데 스산하다.\n");
		script.append("아무도 없는 줄 알고 물건을 뒤지려 하자 갑자기 누구냐며 소리친다.\n");
		script.append("그 사람은 자신이 이 지역의 자치 경찰이라 한다.\n");	
		script.append("나는 그 사람의 장단을 맞춰주며 우선 정보를 캐낼까 아니면 무기를 우선 탈취할까?\n");

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
