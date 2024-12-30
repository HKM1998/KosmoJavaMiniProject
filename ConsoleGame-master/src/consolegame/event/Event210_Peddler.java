package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item000_Knife;

public class Event210_Peddler extends Event {
	public Event210_Peddler() {
		setEventId(210);
		setName("행상인");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printChoice(Character c) {
		Selection selection = new Selection();
		selection.addSelection(" 칼을 판다. ");
		selection.addSelection(" 모르는 사람의 여권을 판다. ");
		selection.addSelection(" 성경을 판다.");
		selection.addSelection(" 개고기를 판다.");
		selection.addSelection(" 구급상자를 판다.");
		selection.addSelection(" 진통제를 판다.");
		selection.addSelection(" 탄약을 판다.");
		selection.addSelection(" 총을 판다.");
		selection.addSelection(" 통조림을 판다.");
		selection.addSelection(" 고기를 판다.");
		selection.addSelection(" 보존식량을 판다.");
		selection.addSelection(" 아무것도 팔지않고 간다");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append(" 길을 가다보니 보따리 상인을 발견했다. \n");
		script.append(" (가지고있는 물건을 판매할수 있을것 같다.) \n");
		script.append(" 안녕하세요? \n");
		script.append(" 물건 좀 팔려고 합니다. \n");
		ConsolePrint.printScript(script);
	}

	@Override
	public void getResult(Character c, String pChoice) {
		StringBuilder script = new StringBuilder();
		if (pChoice.equals("1")) {
			script.append("감사합니다");
			

		
			c.setHealth(c.getHealth() + 2);
			c.setMental(c.getMental() + 2);
		} else if (pChoice.equals("2"))
			;
		script.append("");
		script.append("");
		c.removeItem(11);
		

		if (pChoice.equals("3"))
			;
		{
			script.append("");
			script.append(" ");
			script.append("");
			
		}
		ConsolePrint.printResult(script);

	}
}
