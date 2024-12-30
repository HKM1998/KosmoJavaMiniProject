package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item000_Knife;
import consolegame.item.Item005_PainKiller;

public class Event150_FillingStation extends Event {
	public Event150_FillingStation() {
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

		selection.addSelection("칼 (소지금 -200)");

		selection.addSelection("진통제 (소지금 -200)");
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
		script.append("자가 마스크와 선글라스를 쓴 상태로 접근한다.\n");
		script.append("혹시 이런게 필요하지 않나요?\n");
		script.append("그 안에는 칼과 진통제가 있다.\n");

		ConsolePrint.printScript(script);
	}

	@Override
	public void getResult(Character c, String pChoice) {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		if (pChoice.equals("1")) { // 1번은 금액 200원을 쓰고 칼 획득
			if (c.getMoney() > 200) {
				c.setMoney(c.getMoney() - 200);
				c.getItem().add(new Item000_Knife());
				script.append("소지금 200을 사용하여 칼을 구매하였습니다.(+ 칼)\n");
			} else {
				script.append("당신은 소지금이 부족하여 칼을 구매할 수 없었습니다.\n");
			}

		} else if (pChoice.equals("2")) { // 2번은 금액 200원을 쓰고 진통제 획득
			if (c.getMoney() > 200) {
				c.setMoney(c.getMoney() - 200);
				c.getItem().add(new Item005_PainKiller()); // 아이템 005 진통제 임포트
				script.append("소지금 200을 사용하여 진통제를 구매하였습니다.(+ 진통제)\n");
			} else {
				script.append("당신은 소지금이 부족하여 진통제를 구매할 수 없었습니다.\n");
			}
		}
		ConsolePrint.printResult(script); // 결과 출력부
	}
}
