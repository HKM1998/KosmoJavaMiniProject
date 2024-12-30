package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item000_Knife;
import consolegame.item.Item001_Passport;
import consolegame.item.Item008_Gun;

public class Event140_WeirdShopper extends Event {
	public Event140_WeirdShopper() {
		setEventId(140);
		setName("이상한가판대");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice(Character c) {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("칼 200");
		
		selection.addSelection("총 500 ");
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
		script.append(".\n");
		script.append("인적이 드문 한 가운데 허름한 가판대가 있다. ");
		script.append("해당 가판대는 주인이 없는 것 처럼 보였지만\n");
		script.append("실제로는 주인이 있었다. 할배는 무엇이 필요하냐고 얘기 했다.\n");
		script.append("그는 껌이나 오래된 신문은\n");
		script.append("필요 없다. 좀 유용한게 필요하다며 은밀히 얘기한다.\n");

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
		if (pChoice.equals("2")) {                                // 2번은 금액 500원을 쓰고 총 획득
			c.setMoney(c.getMoney() - 500);
			if (!Item.hasItem(c, 8)) {
				c.getItem().add(new Item008_Gun());               //아이템 008 총 임포트
	    	}
		}	
	}
}
