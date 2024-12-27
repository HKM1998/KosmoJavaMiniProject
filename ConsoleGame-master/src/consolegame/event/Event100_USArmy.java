package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event100_USArmy extends Event {
	public Event100_USArmy() {
		setEventId(100);
		setName("USArmy");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice(Character c) {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("이 근방에 도움이 될 만한 정보가 있을까요?");
		
		selection.addSelection("너무 배가 고픕니다. 먹을꺼를 얻을 수 있을까요?");
		
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
		script.append("용산 근처를 지나던 중 미군을 만난다. 유라시아대륙과 멀리 떨어진 초강대국 미국은");
		script.append("핵전쟁의 피해를 덜 받아 아직까지 미정부의 영향력이 제한적으로 유지되고 있다.\n");
		script.append("전혀 믿을 수 없는 가까운 한국인 보다 멀리 있는 미군이 훨씬\n");
		script.append("믿음직하다. 그는 마을에서 쫓겨나게 된 배경을 설명하고 미군에게 도움을 청한다.\n");

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
