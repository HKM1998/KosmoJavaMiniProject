package consolegame.event;

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
	public void printChoice(Character c) {
	
		Selection selection = new Selection();

		selection.addSelection(" 1. 세상에 너무 무서워 보인다. 도망갈까? ");
		
		selection.addSelection(" 2. 아 너무 배가 고프다 고기다 우히힣히히 잡아먹자.");

		selection.print();
	}


	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append(".\n");
		script.append(" 전방에 최소 2톤은 나가보이는 커다란 맷돼지가 나타났다. 어떻할까? \n");
		script.append("\n");
		script.append("\n");

		ConsolePrint.printScript(script);
	}

	@Override
	public void getResult(Character c, String pChoice) {
		StringBuilder script = new StringBuilder();
		if (pChoice.equals("1") ) {
			script.append("무사히 도망쳤지만 너무 급하게 뛰느라 다쳤다");
			c.getHealth(); // 체력 -1
		}else {pChoice.equals("2");
		script.append("맷돼지에게 공격을 해봤지만");
		script.append("맷돼지가 너무 강하다");
		script.append("져버렸다");
		script.append("아프다..");
		script.append("눈 앞이 깜깜해진다...");
		c.getHealth();
		// 2번 선택지 선택 -> 패배 시 게임 오버 
		
		}
		
	}
}
