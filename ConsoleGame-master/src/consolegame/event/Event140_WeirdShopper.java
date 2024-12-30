package consolegame.event;

import consolegame.Main;
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
	public void printChoice() {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("칼 (소지금 -200)");

		selection.addSelection("총 (소지금 -500)");
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
		script.append("인적이 드문 한 가운데 허름한 가판대가 있다.\n");
		script.append("해당 가판대는 주인이 없는 것 처럼 보였지만\n");
		script.append("실제로는 주인이 있었다. 할배는 무엇이 필요하냐고 얘기 했다.\n");
		script.append("그는 껌이나 오래된 신문은\n");
		script.append("필요 없다. 좀 유용한게 필요하다며 은밀히 얘기한다.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		if (pChoice.equals("1")) { // 1번은 금액 200원을 쓰고 칼 획득
			if (Main.character.getMoney() > 200) {
				Main.character.setMoney(Main.character.getMoney() - 200);
				Main.character.getItem().add(new Item000_Knife());
				script.append("소지금 200을 사용하여 칼을 구매하였습니다.(+ 칼)\n");
			} else {
				script.append("당신은 소지금이 부족하여 칼을 구매할 수 없었습니다.\n");
			}

		} else if (pChoice.equals("2")) { // 2번은 금액 500원을 쓰고 총 획득
			if (Main.character.getMoney() > 500) {
				Main.character.setMoney(Main.character.getMoney() - 500);
				Main.character.getItem().add(new Item008_Gun()); // 아이템 008 총
				script.append("소지금 500을 사용하여 총을 구매하였습니다.(+ 총)\n");
			} else {
				script.append("당신은 소지금이 부족하여 총을 구매할 수 없었습니다.\n");
			}
		}

		ConsolePrint.printResult(script, getIsLoaded()); // 결과 출력부
	}
}
