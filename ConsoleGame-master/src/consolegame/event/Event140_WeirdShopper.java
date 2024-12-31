package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item000_Knife;
import consolegame.item.Item008_Gun;

public class Event140_WeirdShopper extends Event {
	public Event140_WeirdShopper() {
		setEventId(140);
		setName("이상한가판대");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printScript() {
		// 화면 출력 스크립트 작성 형식은 추후 지정할 예정
		// 아래는 예시
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("인적이 드문 골목길 한 가운데 허름한 가판대가 있습니다.\n");
		script.append("가판대는 딱히 관리가 된것처럼 보이지는 않습니다.\n");
		script.append("뚜벅...뚜벅...\n");
		script.append("당신은 가판대를 걸어 지나던 중 갑자기 들리는 목소리에 깜짝 놀랍니다.\n");
		script.append("\"뭐 필요해\"\n");
		script.append("자세히 보니 가판대 안에 할아버지가 앉아있습니다.\n");
		script.append("당신은 껌이나 오래된 신문은\n");
		script.append("필요 없다며 좀 유용한게 필요하다며 얘기합니다.\n");
		script.append("\"이런거?\"\n");
		script.append("할아버지는 서랍에 손을 넣더니 두가지 물건을 꺼냅니다.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}
	@Override
	public void printChoice() {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("칼 (소지금 -200)");

		selection.addSelection("총 (소지금 -500)");
		this.setsCount(selection.count);
		selection.print();
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
