package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item006_Ammunition;
import consolegame.item.Item018_FriendOfPolice;

public class Event031_PoliceStation_1 extends Event {
	public Event031_PoliceStation_1() {
		setEventId(31);
		setName("경찰서내부");
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
		script.append("경찰서 내부로 이동해 자리에 앉자 경찰은 자신의 이야기를 하기 시작합니다.\n\n");
		script.append("\"모든 사람들이 자신의 살길을 찾기 위해 나갔지만 나는\n");
		script.append("남아 있는 몇사람이라도 지키고 싶었어. 돈키호테 같겠지만 진짜라구!\"\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void printChoice() {
		if(getIsLoaded()) {
			selection.print();
			return;
		}
		selection.addSelection("\"자신을 희생하면서 까지 남겠다니.. 그야말로 감동입니다.\"");
		selection.addSelection("\"저도 같이 지키고 싶습니다. 그래서 무기를 좀 얻을 수 있을까요?\"");
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
			script.append("\"너도 이런 험난한 곳에서 자기 한몸 정도는 잘 지킬수 있도록 하라고\n");
			script.append("혹시 위험한 일에 휘말리면 날 불러 이것도 인연인데 도와주도록 하지!\"\n");
			script.append("경찰은 당신에게 탄약을 건냅니다.\n");
			Main.character.addItem(new Item006_Ammunition());
			script.append("(+ 탄약)\n");
			script.append("(+ 경찰의 친구)\n");
			Main.character.addItem(new Item018_FriendOfPolice());
			Main.eMap.setEvent(getEventId()); // 경찰서 이벤트 무사히 마무리 된경우 10번 이벤트 가중치 증가
		} else if (pChoice.equals("2")) {
			script.append("당신의 말에 경찰은 표정이 딱닥해지며 말합니다.\n");
			script.append("\"아주 노골적으로 잿밥에만 관심이 있구만. 그냥 갈길 가쇼.\"\n");
			script.append("라고 말하고는 경찰서 밖으로 내쫓았습니다.\n");
		}
		ConsolePrint.printResult(script, getIsLoaded());
	}
}
