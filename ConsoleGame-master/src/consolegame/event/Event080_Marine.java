package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event080_Marine extends Event {
	public Event080_Marine() {
		setEventId(80);
		setName("해병대");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice(Character c) {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("충성! 해병 1511기 입니다!(거짓말)");
		
		selection.addSelection("아 저는 그냥 별 뜻 없이 지나가고 있습니다.");
		
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
		script.append("저 멀리서 각진 걸음으로 걸어오던 해병 전투복의 무리들이 별안간 주인공 앞에 서서");
		script.append("한번 해병은 영원한 해병! 우리 해병은 불순한 일당이\n");
		script.append("마을을 어지럽히는걸 용서치 않는다! 넌 누구냐\n");
		ConsolePrint.printScript(script);
	}

	@Override
	public void getResult(Character c, String pChoice) {
		// 0번 아이템ID 가 있는 경우 실행
//		if (pChoice.equals("1")) {                        //1번 선택 시 Event 081로 넘어가는거 보류
//			
//		}

		// 무기가 있는경우 실행
		if (pChoice.equals("2")) {
			StringBuilder script = new StringBuilder();
			script.append(getEventId() + ". " + getName() + "\n");
			script.append("그 말을 우리더러 믿으라는거야? 딱봐도 거동이 수상한 불순분자로 보이는구만!\n");
			script.append("주인공은 막무가내로 포박하려는 해병전우회를 죽이고 달아난다\n");
		}
	}
}