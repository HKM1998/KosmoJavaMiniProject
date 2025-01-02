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
		Selection selection = new Selection();

		selection.addSelection("칼 (소지금 -200)");
		selection.addSelection("총 (소지금 -500)");
		selection.addSelection("필요한 것은 없다. 그냥 자리를 떠난다.");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void getResult(String pChoice) {
		if(getIsLoaded()) {
			ConsolePrint.printResult(script, getIsLoaded());
			return;
		}		
		script.append(getEventId() + ". " + getName() + "\n");		
		script = new StringBuilder();
		if (pChoice.equals("1")) { // 1번은 금액 200원을 쓰고 칼 획득
			if (Main.character.getMoney() > 200) {
				script.append("소지금 200을 사용하여 칼을 구매하였습니다.\n");
				script.append("(+ 칼)\n");
				Main.character.setMoney(Main.character.getMoney() - 200);
				Main.character.getItem().add(new Item000_Knife());
			} else {
				script.append("당신은 소지금이 부족하여 칼을 구매할 수 없었습니다.\n");
			}

		} else if (pChoice.equals("2")) { // 2번은 금액 500원을 쓰고 총 획득
			if (Main.character.getMoney() > 500) {
				Main.character.setMoney(Main.character.getMoney() - 500);
				Main.character.getItem().add(new Item008_Gun()); // 아이템 008 총
				script.append("소지금 500을 사용하여 총을 구매하였습니다.\n");
				script.append("(+ 총)\n");
			} else {
				script.append("당신은 소지금이 부족하여 총을 구매할 수 없었습니다.\n");
			}
		} else if (pChoice.equals("3")) { 
			script.append("가판대의 할아버지가 제시한 물건은 당신에게 필요없는 물건입니다.\n");
			script.append("\"저한테는 그런 것도 필요없습니다\"\n");
			script.append("라고 말하고는 자리를 떠납니다.\n");
		}
		ConsolePrint.printResult(script, getIsLoaded()); // 결과 출력부
	}
}
