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

		selection.addSelection("배고픔에 굶주려 허겁지겁 먹는다");
		
		selection.addSelection("한번 스프의 냄새부터 음미한다");
		
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
	public void getResult(Character c, String pChoice) {                          //Even091의 b를 제외하고는 Weird to Bad 엔딩 조건
		// 0번 아이템ID 가 있는 경우 실행      
		if (pChoice.equals("1")) {                                                //1번 선택시 체력-2
			StringBuilder script = new StringBuilder();
			script.append(getEventId() + ". " + getName() + "\n");
			script.append("허겁지겁 스프를 먹다가 갑자기 졸음이 덮쳐오는 느낌이 든다.\n");
			script.append("뭔가 잘못됨을 직감하고 '이만하면 충분한 것 같군요' 하고 나가려 하자\n");
			script.append("누구 맘대로 장기는 놓고 가야지?\" 라며 주인공을 잡으려 한다.\n");
			script.append("그는 초인적인 집중력으로 따돌려 내고 떠나지만 부상을 입는다\n");
			c.setHealth(c.getHealth() - 2);
		}

		// 무기가 있는경우 실행
		if (pChoice.equals("2")) {                                                //2번 선택시 잃는 것은 아무것도 없고 Weird to Bad 엔딩도 피한다
			StringBuilder script = new StringBuilder();
			script.append(getEventId() + ". " + getName() + "\n");
			script.append("그는 먹기전에 스프의 냄새를 음미했다. 그러나 뭔가 냄새가 이상했다.\n");
			script.append("그러다 불현듯 마을 촌장이 집 뒤뜰에서 몰래 키우던 아편 냄새를 떠올리고\n");
			script.append("따뜻한 환대는 감사드립니다만 죄송하게도 급히 가야할 일이 생겼습니다.\n");
			script.append("라며 급하게 자리를 뜨려 하자 부부는 '누구 맘대로? 장기는 놓고 가야지'\n");
			script.append("라며 주인공을 잡으려 하지만 주인공은 총을 꺼내 위협사격을 하며 무사히 떠난다\n");
		}
	}
}
