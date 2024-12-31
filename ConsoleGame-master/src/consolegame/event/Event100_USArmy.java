package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item009_Can;

public class Event100_USArmy extends Event {
	public Event100_USArmy() {
		setEventId(100);
		setName("USArmy");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("당신은 폐허를 지나던 중 미군을 마주쳤습니다.");
		script.append("아직까지 미군은 정상적으로 유지되고 있는 것으로 보입니다!\n");
		script.append("그들의 체계적인 모습에 오히려 여지껏 만난 사람들에 비해 믿음이 갑니다.\n");
		script.append("당신은 홀린 듯이 미군에게 도움을 청하고 맙니다.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void printChoice() {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("\"이 근방에 도움이 될 만한 정보가 있을까요?\"");
		
		selection.addSelection("\"너무 배가 고파서 그런데. 혹시 먹을 것을 얻을 수 있을까요?\"");
		this.setsCount(selection.count);
		selection.print();
	}
	
	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		if (pChoice.equals("1")) { 
			script.append("그들은 당신을 쳐다보며 말합니다.\n");
			script.append("\"안타깝지만 민간인과 공유할 수 있는 정보는 없다.\n");
			script.append("잠시 쉬었다 왔던 길로 돌아가라.\"\n");
			script.append("얻어낸 정보는 없지만 믿음직한 그들의 모습에 잠시나마 마음이 편안해집니다.\n");
			script.append("(정신력 +1)\n");
			Main.character.setMental(Main.character.getMental() + 1);
		}else if (pChoice.equals("2")) {
			script.append("\"안타깝지만 우리도 많은걸 줄 순 없다. 이거라도 가져가도록.\"\n");
			script.append("그들은 당신에게 통조림 하나를 건냅니다.\n");
			script.append("(+ 통조림)\n");
			if (!Item.hasItem(Main.character, 9)) {
				Main.character.getItem().add(new Item009_Can());
		}
	}
		ConsolePrint.printResult(script, getIsLoaded());
  }
}
