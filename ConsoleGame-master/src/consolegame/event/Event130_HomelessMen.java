package consolegame.event;

import java.util.Random;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item004_FirstAidKit;

public class Event130_HomelessMen extends Event {
	public Event130_HomelessMen() {
		setEventId(130);
		setName("노숙자");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice(Character c) {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("싸운다");
		
		selection.addSelection("도망친다 ");
		
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
		script.append("지나가는데 이상한 냄새가 난다. ");
		script.append("배고픔에 굶주린 노숙자들이 뒤에서 몰래 미행을 한다. \n");
		script.append("걸음을 빠르게 옮기지만 막다른 골목에 몰리고 만다. 그들이 습격을 해 온다.\n");

		ConsolePrint.printScript(script);
	}

	@Override
	public void getResult(Character c, String pChoice) {
		// 0번 아이템ID 가 있는 경우 실행
		if (pChoice.equals("1")) {                                 // 1번을 골랐을 경우 공격하기
			if (Item.hasItem(c, 000)) {                            // 칼을 가지고 있을 경우 공격

				Random random = new Random();

				if (random.nextInt(10) < 7) {                      // 칼은 70% 확률로 패배 후 체력-1
					c.setHealth(c.getHealth() - 1);                // 전리품 없음
				}
			}
			if (Item.hasItem(c, 8)) {                              // 총을 가지고 있을 경우 공격

				Random random1 = new Random();
				if (random1.nextInt(10) < 0) {                     // 총은 0% 확률로 패배 후 체력 -1, 100% 확률로 승리 후 전리품 획득x
					c.setHealth(c.getHealth() - 1);
				}

			}
		}

		// 무기가 있는경우 실행
		if (Item.hasItemType(c, "무기")) {
		}
	}
}