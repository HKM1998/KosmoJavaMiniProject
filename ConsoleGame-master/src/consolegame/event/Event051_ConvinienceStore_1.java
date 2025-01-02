package consolegame.event;

import java.util.Random;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item004_FirstAidKit;

public class Event051_ConvinienceStore_1 extends Event {
	public Event051_ConvinienceStore_1() {
		setEventId(51);
		setName("편의점 내부");
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
		script.append("당신은 편의점 안으로 이동해 내부를 둘러봅니다.\n");
		script.append("이미 선반은 헤집어지고 쓸만한 물건은 많이 없어보입니다.\n");
		script.append("\"에이씨 또 헛탕 쳤네! 아휴 왜이리 부지런히 다들 터는거야?\n");
		script.append("학교 다닐 때 공부를 그렇게 부지런히들 했어봐라!\"\n");
		script.append("혼잣말로 투덜거리며 내부를 뒤지기 시작합니다.\n");
		script.append("그런데 갑자기 뒤에서 소리가 들립니다.\n\n");
		script.append("\"꼼짝마! 너는 어디서 온 누구냐?\n");
		script.append("여기는 우리가 오랫동안 집으로 여기고 있던 곳이야. 어서 썩 나가!\"\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void printChoice() {
		if(getIsLoaded()) {
			selection.print();
			return;
		}
		selection.addSelection("거부하고 상대와 칼로 싸웁니다.");
		selection.addSelection("거부하고 상대와 총으로 싸웁니다.");
		selection.addSelection("그냥 나갑니다");
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
		Random random = new Random();
		if (pChoice.equals("1")) {
			if (Item.hasItem(Main.character, 000)) {
				script.append("\"아니 그쪽이 나가시지\"\n");
				script.append("당신은 칼을 꺼내들고는 편의점에 있는 인물에게 달려듭니다.\n");
				script.append(".     \n");
				script.append(".     \n");
				script.append(".     \n");
				if (random.nextInt(10) < 7) {
					script.append("당신은 용감하게 달려들었지만 오히려 상처입고 도망칩니다.\n");
					script.append("(체력 -2)\n");
					Main.character.setHealth(Main.character.getHealth() - 2);
				} else {
					script.append("당신은 용감하게 달려들어 상대를 제압하는데 성공합니다.\n");
					script.append("\"이걸 줄테니 목숨만은 살려주게\"\n");
					script.append("당신은 그의 손에 들린 물건을 받아들고 그를 놓아줍니다.\n");
					script.append("(+ 구급상자)\n");
					Main.character.addItem(new Item004_FirstAidKit());
				}
			} else {
				script.append("아뿔싸 당신은 칼이 없습니다!\n");
				script.append("다급하게 도망치려 하지만 몸에 상처가 남고 맙니다.\n");
				script.append("(체력 -2)\n");
				Main.character.setHealth(Main.character.getHealth() - 2);
			}
		} else if (pChoice.equals("2")) {
			if (Item.hasItem(Main.character, 8)) {
				script.append("\"아니 그쪽이 나가시지\"\n");
				script.append("당신은 주머니에 있던 총을 꺼내들고 그에게 겨눕니다.\n");
				script.append(".     \n");
				script.append(".     \n");
				script.append(".     \n");
				if (random.nextInt(10) < 1) {
					script.append("그는 당신이 총을 완벽하게 겨누기 전에 당신을 덮치고 맙니다.\n");
					script.append("당신은 오히려 상처입고 도망칩니다.\n");
					script.append("(체력 -2)\n");
					Main.character.setHealth(Main.character.getHealth() - 2);
				} else {
					script.append("당신이 총을 꺼내들자 그는 바닥에 넙죽 엎드리며 물건을 건냅니다.\n");
					script.append("\"이걸 줄테니 목숨만은 살려주게\"\n");
					script.append("당신은 그의 손에 들린 물건을 받아들고 그를 놓아줍니다.\n");
					script.append("(+ 구급상자)\n");
					Main.character.addItem(new Item004_FirstAidKit());
				}

			} else {
				script.append("아뿔싸 당신은 총이 없습니다!\n");
				script.append("다급하게 도망치려 하지만 몸에 상처가 남고 맙니다.\n");
				script.append("(체력 -2)\n");
				Main.character.setHealth(Main.character.getHealth() - 2);
			}
		} else if (pChoice.equals("3")) {
			script.append("\"아 침착해 침착해요~ 남의 집 들쑤실 생각 없습니다~\"\n");
			script.append("당신은 능청스럽게 얘기하며 자리를 유유히 나왔습니다.\n");
		}
		ConsolePrint.printResult(script, getIsLoaded());
	}
}
