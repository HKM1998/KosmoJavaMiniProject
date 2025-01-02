package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;
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
		if(getIsLoaded()) {
			ConsolePrint.printResult(script, getIsLoaded());
			return;
		}
		script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("당신은 폐허를 지나던 중 미군을 마주쳤습니다.\n");
		script.append("아직까지 미군은 정상적으로 유지되고 있는 것으로 보입니다!\n");
		script.append("그들의 체계적인 모습에 오히려 여지껏 만난 사람들에 비해 믿음이 갑니다.\n");
		script.append("당신은 홀린 듯이 미군에게 도움을 청하고 맙니다.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void printChoice() {
		if(getIsLoaded()) {
			selection.print();
			return;
		}
		selection.addSelection("\"Excuse me, may I ask something?\"");
		selection.addSelection("\"너무 배가 고파서 그런데. 혹시 먹을 것을 얻을 수 있을까요?\"");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void getResult(String pChoice) {
		if(getIsLoaded()) {
			ConsolePrint.printResult(script, getIsLoaded());
			return;
		}		
		script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");		
		if (pChoice.equals("1")) {
			script.append("그들은 당신을 쳐다보며 말합니다.\n");
			script.append("\"No information can be shared with civilians.\n");
			script.append("\"(안타깝지만 민간인과 공유할 수 있는 정보는 없다.)\n");
			script.append("Get out, We'll open fire..\"\n");
			script.append("(꺼져라 안그러면 발포한다.)\"\n");
			script.append("총구를 들이대는 모습에 당신은 무서워서 서둘러 도망쳐나오다가 발목을 접질럿습니다.\n");
			script.append("(체력-1)\n");
			Main.character.setHealth(Main.character.getHealth() - 1);
		} else if (pChoice.equals("2")) {
			script.append("\"What the poor, take this get out kkk\"\n");
			script.append("\"(그지새낀가. 이거나 받고 꺼져ㅋㅋㅋ)\"\n");
			script.append("그들은 당신에게 낡은 통조림 하나를 던집니다.\n");
			script.append("(+ 통조림)\n");
			Main.character.getItem().add(new Item009_Can());

		}
		ConsolePrint.printResult(script, getIsLoaded());
	}
}
