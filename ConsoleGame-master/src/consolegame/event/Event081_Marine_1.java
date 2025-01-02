package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item008_Gun;

public class Event081_Marine_1 extends Event {
	public Event081_Marine_1() {
		setEventId(81);
		setName("해병대 전우회");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("잠시 그들에게 둘러쌓여 걷다보니 무너진 빌딩 사이 멀쩡한 건물이 나타납니다.\n");
		script.append("사무실 안의 의자에 강제로 앉혀집니다.\n\n");
		script.append("털썩 !\n\n");
		script.append("그들 중 리더로 보이는 사람이 당신에게 말을 겁니다.\n\n");
		script.append("\"그래. 1511기라고? 어디서 근무했지?\"\n\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void printChoice() {
		Selection selection = new Selection();

		selection.addSelection("당신은 식은땀을 흘리며 거짓말에 대해 사과합니다.");
		selection.addSelection("당신은 당당하게 당장 생각나는 지역을 말합니다.");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void getResult(String pChoice) {
		if(getIsLoaded()) {
			ConsolePrint.printResult(script, getIsLoaded());
			return;
		}		
		script.append(getEventId() + ". " + getName() + "\n");		
		script = new StringBuilder();
		if (pChoice.equals("1")) {
			script.append("리더로 보이는 사람이 웃으며 말합니다.\n");
			script.append("\"하하하! 거짓말인것 알고 있었네 사실대로 말해서 다행이야.\"\n");
			script.append("뒤에서 총을 내리는 소리가 들립니다.\n");
			script.append("\"무작정 대려온 것에 대해 사과하지 편하게 쉬다 가게\"\n");
			script.append("당신은 눈치가 보였으나 강제로 쉬다가 떠납니다.\n");
			script.append("(체력 +1, 정신력 -1)\n");
			Main.character.setHealth(Main.character.getHealth() + 1);
			Main.character.setMental(Main.character.getMental() - 1);
		} else if (pChoice.equals("2")) {
			script.append("\"백령도! 백령도에서 근무했습니다.\"\n");
			script.append("당당하게 말하는 모습에 리더로 보이는 사람은 흡족한 미소를 짓습니다.\n");
			script.append("\"내가 거기서 근무했었지! 자네 위험하게 다니지 말고 이거 하나 챙겨가게나\"\n");
			if (!Item.hasItem(Main.character, 8)) {
				script.append("탄약이 없는 총을 넘겨 받습니다.\n");
				Main.character.addItem(new Item008_Gun());
			} else {
				script.append("비타민을 넘겨 받습니다. 비타민을 먹자 정신이 맑아지는 것이 느껴집니다.\n");
				script.append("(정신력 +1)\n");
				Main.character.setMental(Main.character.getMental() + 1);
			}
		}
		ConsolePrint.printResult(script, getIsLoaded());
	}
}
