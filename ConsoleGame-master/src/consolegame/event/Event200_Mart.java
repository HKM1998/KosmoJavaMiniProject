package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item000_Knife;
import consolegame.item.Item006_Ammunition;
import consolegame.item.Item008_Gun;
import consolegame.item.Item009_Can;
import consolegame.item.Item010_Meat;
import consolegame.item.Item011_Preservedfood;

public class Event200_Mart extends Event {
	public Event200_Mart() {
		setEventId(200);
		setName("마트");
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
		script.append("길을가다 마트를 발견했다. \n");
		script.append("뭐라도 좀 사러가자.\n");
		script.append("(하지만 가진 돈이 적으니 한가지밖에 살수없다 신중하게 고르도록 하자.)\n");
		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void printChoice() {
		if(getIsLoaded()) {
			selection.print();
			return;
		}
		selection.addSelection("칼을 산다. ");
		selection.addSelection("통조림을 산다. ");
		selection.addSelection("총을 산다. ");
		selection.addSelection("탄약을 산다. ");
		selection.addSelection("고기를 산다. ");
		selection.addSelection("보존식량을 산다. ");
		selection.addSelection("가진게 아무것도 없다.. 그냥 나가자.");
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
		if (pChoice.equals("1") && Main.character.getMoney() >= 100) {
			script.append("음 조금 녹슨것 같지만\n");
			script.append("뭐 괜찮겠지.\n");
			script.append("(+ 칼, 자금 -100)\n");
			Main.character.addItem(new Item000_Knife());
			Main.character.setMoney(Main.character.getMoney() - 100);
		} else if (pChoice.equals("2") && Main.character.getMoney() >= 50) {
			script.append("마음에 드는 맛은 아니지만..뭐..\n");
			script.append("이거라도 챙겨야겠지.\n");
			script.append("(+ 통조림, 자금 -50)\n");
			Main.character.addItem(new Item009_Can());
			Main.character.setMoney(Main.character.getMoney() - 50);
		} else if (pChoice.equals("3") && Main.character.getMoney() >= 200) {
			script.append("음 이거라면 누구든 \n");
			script.append("상대할수 있을것 같은 자신감이 솟는다.\n");
			script.append("난 강해졌다.\n");
			script.append("(+ 총, 자금 -200)\n");
			Main.character.addItem(new Item008_Gun());
			Main.character.setMoney(Main.character.getMoney() - 200);
		} else if (pChoice.equals("4") && Main.character.getMoney() >= 50) {
			script.append("아차 탄약도 챙겨야지.\n");
			script.append("(+ 탄약, 자금 -50\n)");
			Main.character.addItem(new Item006_Ammunition());
			Main.character.setMoney(Main.character.getMoney() - 50);
		} else if (pChoice.equals("5") && Main.character.getMoney() >= 200) {
			script.append("어떤 동물의 고기인지는\n");
			script.append("모르겠으나 어쨋든\n");
			script.append("맛있어 보이는 고기다.\n");
			script.append("(+ 고기, 자금 -200)\n");
			Main.character.addItem(new Item010_Meat());
			Main.character.setMoney(Main.character.getMoney() - 200);
		} else if (pChoice.equals("6") && Main.character.getMoney() >= 50) {
			script.append("이 제품의 표지만 봐도\n");
			script.append("굉장히 맛이 있을것\n");
			script.append("같아 보이진 않는다.\n");
			script.append("영어로 뭐라고 적혀있는거지..\n");
			script.append("p..rotin..?.\n ");
			script.append("(+ 보존식량, 자금 -50)\n");
			Main.character.addItem(new Item011_Preservedfood());
			Main.character.setMoney(Main.character.getMoney() - 50);
		} else if (pChoice.equals("7")) {
			script.append("배도 고프고..\n");
			script.append("돈도 없고... \n");
			script.append("서럽다.\n");
		} else {
			script.append("돈이 없어서 물건을 살수 없다.\n");
			script.append("씁슬하구만...\n");
		}
		ConsolePrint.printResult(script, getIsLoaded());
	}

}
