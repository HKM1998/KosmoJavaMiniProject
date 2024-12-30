package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item000_Knife;
import consolegame.item.Item005_PainKiller;

public class Event150__Filling_Station extends Event {
	public Event150__Filling_Station() {
		setEventId(150);
		setName("주유소");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice(Character c) {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("칼200");
		
		selection.addSelection("진통제200");
		this.setsCount(selection.count);
		selection.print();
	}

	// 이벤트 스크립트 바로 화면에 출력
	@Override
	public void printScript() {
		// 화면 출력 스크립트 작성 형식은 추후 지정할 예정
		// 아래는 예시
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("무인주유소에 있는 편의점에 잠시 들르려 하는데 ");
		script.append("뭔가 수상쩍은 물건을 백에 담고 있는 듯한\r\n");
		script.append( "자가 마스크와 선글라스를 쓴 상태로 접근한다.\n");
		script.append("혹시 이런게 필요하지 않나요?\n");
		script.append("그 안에는 칼과 진통제가 있다.\n");

		ConsolePrint.printScript(script);
	}

	@Override
	public void getResult(Character c, String pChoice) {
		// 0번 아이템ID 가 있는 경우 실행
		if (pChoice.equals("1")) {                                // 1번은 금액 200원을 쓰고 칼 획득
			c.setMoney(c.getMoney() - 200);
			if (!Item.hasItem(c, 000)) {
				c.getItem().add(new Item000_Knife());
		   }
		}

		// 무기가 있는경우 실행
		if (pChoice.equals("2")) {                                // 2번은 금액 200원을 쓰고 진통제 획득
			c.setMoney(c.getMoney() - 200);
			if (!Item.hasItem(c, 005)) {
				c.getItem().add(new Item005_PainKiller());        // 아이템 005 진통제 임포트
		   }
		}
	}
}
