package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item001_Passport;
import consolegame.item.Item007_Chart;

public class Event060_AbandonedHospital extends Event {
	public Event060_AbandonedHospital() {
		setEventId(060);
		setName("폐병원");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice(Character c) {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("몰래 우회한다");
		
		selection.addSelection("들어가본다");
		
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
		script.append("병원을 발견했다. 병원은 스산하고 어둡다. 얼른 필요한것만 챙기고 나가자.\n");
		script.append("문이 끼익 열린다. 필요한 물품을 찾기 위해 여기 저기 찾아다닌다.\n");
		script.append("그러다 불이 켜진 방을 발견한다.\n");
		ConsolePrint.printScript(script);
	}

	@Override
	public void getResult(Character c, String pChoice) {		
		if (pChoice.equals("1")) {                            //1번 선택시 Good 엔딩 루트가 Bad 엔딩되는 조건 중 하나                                                                                                                                                                                                                                                                                                                                                                                                                // 1번 우회한다 선택했을 경우 차트를 획득
			if (!Item.hasItem(c, 007)) {
				c.getItem().add(new Item007_Chart());         // 아이템 차트 클래스 임포트
			}
		}	
		// 무기가 있는경우 실행
//		if (pChoice.equals("2")) {                            // 2번 들어갈 경우 061로 이동하는 것 보류
//					
//		}
	
     }

}
