package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item001_Passport;

public class Event010_EmptyCar extends Event {
	public Event010_EmptyCar() {
		setEventId(10);
		setName("빈차");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printChoice() {
		Selection selection = new Selection();

		selection.addSelection("칼.");
		selection.addSelection("미스테리 지도");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("으슥한 곳에 숨겨져 있는 자동차를 발견했습니다.\n");
		script.append("아니 뭐 이런 곳에 자동차를 둬? 이건 훔쳐 달라는거 아냐? 하고 창문을 깹니다\n");
		script.append("쨍그랑! 아오.. 파편에 약간 긁히긴 했지만 어쨋든 성공적으로 열긴 했습니다\n");
		script.append("앞좌석 대신 앞좌석 서랍을 여니 칼1개와 여권이 있다.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		if (pChoice.equals("1")) {
			if (Item.hasItemType(Main.character, "Knife")) {
			}
			script.append("칼을 집어 들었다.\n");
			
		}
		else if (pChoice.equals("2")) {     
			if (!Item.hasItem(Main.character, 001)) {
				Main.character.addItem(new Item001_Passport());
				script.append("스스로도 이유는 모르겠지만 홀린듯 미스테리 지도를 집어 들었습니다.\n");
			}
		}

		ConsolePrint.printResult(script, getIsLoaded());
	}
}
