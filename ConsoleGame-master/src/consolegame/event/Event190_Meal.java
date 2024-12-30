package consolegame.event;

import consolegame.Main;
import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event190_Meal extends Event {
	public Event190_Meal() {
		setEventId(190);
		setName("식사");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printChoice() {
		Selection selection = new Selection();
		selection.addSelection("  고기를 구워먹자. ");
		selection.addSelection("  간단한 보존식량이라도 꺼내 먹고 잠시라도 허기를 달래자.");
		selection.addSelection("  가진게 아무것도 없다.. 굶는다..");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append(" 무작정 걷다보니 배가 너무 고프다.. 뭐라도 꺼내 먹자. \n");
		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		if (pChoice.equals("1")) {
			script.append("오랜만에 먹는 고기라 환상적인 맛이다.");
			script.append("중독될 것 같다.");

			Main.character.removeItem(10);
			Main.character.setHealth(Main.character.getHealth() + 2);
			Main.character.setMental(Main.character.getMental() + 2);
		} else if (pChoice.equals("2"))
			;
		script.append("딱딱하고 맛이 없지만");
		script.append("그래도 먹고 살아남아야 한다.");
		Main.character.removeItem(11);
		Main.character.setMental(Main.character.getMental() + 1);

		if (pChoice.equals("3"))
			;
		{
			script.append("꼬르르르륵... ");
			script.append("너무 배가 고프다.. ");
			script.append("서럽다. ");
			Main.character.setHealth(Main.character.getHealth() - 1);
			Main.character.setMental(Main.character.getMental() - 1);
		}
		ConsolePrint.printResult(script, getIsLoaded());

	}
}
