package consolegame.event;

import java.util.Random;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item003_DogMeat;

public class Event040_WildDog extends Event {
	public Event040_WildDog() {
		setEventId(40);
		setName("들개");
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
		script.append("폐허가 된 도시에 어둠이 깔리자\n");
		script.append("어디선가 으르렁 거리는 소리가 들리기 시작합니다.\n");
		script.append("배고픔에 굶주린 들개 무리가 침을 질질 흘리며 당신을 포위하기 시작합니다.\n\n");
		script.append("\"내가 아무리 떠돌이 신세여도 그렇지 들개한테 잡아 먹히는 엔딩이 맞냐?\"\n\n");
		script.append("들개무리가 당신을 덥치기 직전입니다!\n");
		script.append("당신은 어떻게 할지 선택해야 합니다!\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void printChoice() {
		if(getIsLoaded()) {
			selection.print();
			return;
		}
		selection.addSelection("도망갑니다.");
		selection.addSelection("칼로 싸웁니다");
		selection.addSelection("총으로 싸웁니다");
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
			script.append("당신은 도망쳐야 겠다는 생각이 들자마자\n");
			script.append("부리나케 도망치기 시작했습니다.\n");
			script.append("아뿔싸!\n");
			script.append("인간이 달려서 들개에게서 무사히 달아나기에는 역부족했습니다.\n");
			script.append("들개에게 물려 상처가 나고 맙니다.\n");
			script.append("(체력 -1)\n");
			Main.character.setHealth(Main.character.getHealth() - 1);
		}else if (pChoice.equals("2")) {
			if (Item.hasItem(Main.character, 000)) {
				Random random = new Random();
				script.append("칼로 맞서 싸우기 시작합니다.\n");
				script.append(".     \n");
				script.append(".     \n");
				script.append(".     \n");
				if (random.nextInt(10) < 7) {
					script.append("당신은 최선을 다해 맞서 싸웟으나\n");
					script.append("이겨내기에는 역부족했습니다.\n");
					script.append("(체력 -2)\n");
					Main.character.setHealth(Main.character.getHealth() - 2);
				} else {
					script.append("당신은 무사히 들개를 물리쳤습니다.\n");
					script.append("들개를 죽여 고기를 얻습니다.\n");
					script.append("(+ 개고기)\n");
					Main.character.addItem(new Item003_DogMeat());
				} 

			}
		}else if (pChoice.equals("3")) {
			if (Item.hasItem(Main.character, 8)) {
				Random random1 = new Random();
				script.append("총로 맞서 싸우기 시작합니다.\n");
				script.append(".     \n");
				script.append(".     \n");
				script.append(".     \n");
				if (random1.nextInt(10) < 1) {
					script.append("당신은 최선을 다해 맞서 싸웟으나\n");
					script.append("이겨내기에는 역부족했습니다.\n");
					script.append("(체력 -2)\n");
					Main.character.setHealth(Main.character.getHealth() - 2);
				} else {
					script.append("당신은 무사히 들개를 물리쳤습니다.\n");
					script.append("들개를 죽여 고기를 얻습니다.\n");
					script.append("(+ 개고기)\n");
					Main.character.addItem(new Item003_DogMeat());
				} 

			}
		}
		ConsolePrint.printResult(script, getIsLoaded());
	}
}
