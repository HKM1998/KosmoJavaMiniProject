package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item006_Ammunition;

public class Event031_PoliceStation_1 extends Event {
	public Event031_PoliceStation_1() {
		setEventId(31);
		setName("경찰서내부");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("경찰서 내부로 이동해 자리에 앉자 경찰은 자신의 이야기를 하기 시작합니다.\n\n");
		script.append("\"모든 사람들이 자신의 살길을 찾기 위해 나갔지만 나는\n");
		script.append("남아 있는 몇사람이라도 지키고 싶었어. 돈키호테 같겠지만 진짜라구!\"\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void printChoice() {
		Selection selection = new Selection();

		selection.addSelection("\"자신을 희생하면서 까지 남겠다니.. 그야말로 감동입니다.\"");
		selection.addSelection("\"저도 같이 지키고 싶습니다. 그래서 무기를 좀 얻을 수 있을까요?\"");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		if (pChoice.equals("1")) {
			script.append("\"너도 이런 험난한 곳에서 자기 한몸 정도는 잘 지킬수 있도록 하라고\"\n");
			script.append("경찰은 당신에게 탄약을 건냅니다.\n");
			if (!Item.hasItemType(Main.character, "Ammunition")) {
				Main.character.addItem(new Item006_Ammunition());
				script.append("(+ 탄약)\n");
			} else {
				try {
					script.append("(+ 탄약)\n");
					Item006_Ammunition ammunition = (Item006_Ammunition) (Item.findItem(Main.character, 6));
					ammunition.setAmAmount(ammunition.getAmAmount() + 1);
				} catch (ClassCastException e) {
					Main.character.removeItem(6);
					Main.character.addItem(new Item006_Ammunition());

				}
			}
		} else if (pChoice.equals("2")) {
			script.append("당신의 말에 경찰은 표정이 딱닥해지며 말합니다.\n");
			script.append("\"아주 노골적으로 잿밥에만 관심이 있구만. 그냥 갈길 가쇼.\"\n");
			script.append("라고 말하고는 경찰서 밖으로 내쫓았습니다.\n");
		}
		ConsolePrint.printResult(script, getIsLoaded());
	}
}
