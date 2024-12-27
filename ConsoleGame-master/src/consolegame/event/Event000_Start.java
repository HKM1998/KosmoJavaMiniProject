package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event000_Start extends Event {
	public Event000_Start() {
		setEventId(000);
		setName("시작");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice(Character c) {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection(" 굶는다.");
		
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

		this.setsCount(selection.count); // 추가된 선택지 수만큼 선택지 수 설정
		selection.print();
	}

	// 이벤트 스크립트 바로 화면에 출력
	@Override
	public void printScript() {
		// 화면 출력 스크립트 작성 형식은 추후 지정할 예정
		// 아래는 예시
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("\"세계 3차대전 핵전쟁 이후 인류는 황폐화된 문명 위에 다시 시작하고 있다.\n");
		script.append("거대하고 강력했던 단일한 정부는 없어지고 마치 그리스 시대의 폴리스 처럼 군소\n ");
		script.append("난립하는 자치단체들이 이끌어 가는 시대다. 그 중 3차 세계 대전 이후에 태어난\n");
		script.append("주인공은 서울의 도봉동에서 태어나 자랐으며 크게 해당 지역을 벗어나지 않으며 자라온 인물이다.\n");
		script.append("전쟁 전 역사 선생님이었던 아버지의 영향을 받아 자유민주주의라는 이념에 의해 번성하던\n");
		script.append("세상에 대한 교육을 받고 자라났다. 그에겐 자유민주주의를 통한 국민에 의한 통치야 말로\n");
		script.append("번성하는 세계로 가는 당연한 선택이었다.\n");
		script.append("그러나 그 이전까지는 투표로 선출 됐지만 임기제한을 무시하며 재선을 시도 하려는 촌장에게\n");
		script.append("항의를 하며 그의 횡포에 제동을 걸려 한다.\n");
		script.append("그러다 밤에 몰래 주인공을 죽이기 위해 자객을 보낸 촌장을 피해 급하게 도망 나온다.\"\n");

		ConsolePrint.printScript(script);
	}

	@Override
	public void getResult(Character c, String pChoice) {
		// 0번 아이템ID 가 있는 경우 실행
		if (Item.hasItem(c, 000)) {
			//c.removeItem(000);
		}

		// 무기가 있는경우 실행
		if (Item.hasItemType(c, "무기")) {
		}
	}
}
