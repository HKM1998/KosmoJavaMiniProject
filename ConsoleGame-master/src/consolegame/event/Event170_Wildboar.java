package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.console.MainConsole;

public class Event170_Wildboar extends Event {
	public Event170_Wildboar() {
		setEventId(170);
		setName("맷돼지 조우");
		setScore(0);
	}

	@Override
	public void printScript() {
		if(getIsLoaded()) {
			ConsolePrint.printResult(script, getIsLoaded());
			return;
		}
		script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("쿵...\n");
		script.append("쿵...\n");
		script.append("쿵...\n");
		script.append("쿵...\n");
		script.append("당신의 전방에 최소 2톤은 나가보이는 커다란 맷돼지가 나타났다.\n");
		script.append("어떻할까?\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void printChoice() {
		if(getIsLoaded()) {
			selection.print();
			return;
		}
		selection.addSelection("세상에 너무 무서워 보인다. 도망갈까? ");
		selection.addSelection("아 너무 배가 고프다 고기다 우히힣히히 잡아먹자.");
		this.setsCount(selection.count);
		selection.print();

	}

	@Override
	public void printResult(String pChoice) {
		if(getIsLoaded()) {
			ConsolePrint.printResult(script, getIsLoaded());
			return;
		}			
		script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");	
		if (pChoice.equals("1")) {
			script.append("당신은 다급하게 도망치기 시작합니다.\n");
			script.append("무사히 도망쳤지만 너무 급하게 뛰느라 부상을 입고 말았습니다.\n");
			script.append("(체력 -1)\n");
			Main.character.setHealth(Main.character.getHealth()-1); // 체력 -1
		} else if (pChoice.equals("2")) {
			script.append("맷돼지에게 공격을 해봤지만\n");
			script.append("맷돼지가 너무 강하다......\n");
			script.append("져버렸다....\n");
			script.append("아프다......\n");
			script.append("눈 앞이 깜깜해진다.......\n");
			script.append("(게임오버)\n");
			MainConsole.setGameOver(true);
		}
		

		ConsolePrint.printResult(script, getIsLoaded());
	}
}
