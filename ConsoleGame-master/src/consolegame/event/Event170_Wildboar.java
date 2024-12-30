package consolegame.event;

import consolegame.Main;
import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event170_Wildboar extends Event {
	public Event170_Wildboar() {
		setEventId(170);
		setName("맷돼지 조우");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printChoice() {

		Selection selection = new Selection();

		selection.addSelection("세상에 너무 무서워 보인다. 도망갈까? ");

		selection.addSelection("아 너무 배가 고프다 고기다 우히힣히히 잡아먹자.");
		this.setsCount(selection.count);
		selection.print();

	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append(" 전방에 최소 2톤은 나가보이는 커다란 맷돼지가 나타났다. 어떻할까? ");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		if (pChoice.equals("1")) {
			script.append("무사히 도망쳤지만 너무 급하게 뛰느라 다쳣습니다.(체력 -1)");
			Main.character.setHealth(Main.character.getHealth()-1); // 체력 -1
		} else if (pChoice.equals("2")) {
			script.append("맷돼지에게 공격을 해봤지만");
			script.append("맷돼지가 너무 강하다 \n");
			script.append("져버렸다 \n");
			script.append("아프다..\n");
			script.append("눈 앞이 깜깜해진다...(게임오버)");
			Main.character.setHealth(-1);
		}
		

		ConsolePrint.printResult(script, getIsLoaded());
	}
}
