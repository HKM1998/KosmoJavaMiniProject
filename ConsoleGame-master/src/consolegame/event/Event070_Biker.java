package consolegame.event;

import java.util.Random;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item006_Ammunition;

public class Event070_Biker extends Event {
	public Event070_Biker() {
		setEventId(70);
		setName("폭주족");
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
		script.append("당신은 오늘도 묵묵히 걷고 있습니다.\n");
		script.append("그러다 이제는 인적이 드문 넓은 4차선 왕복도로 를 걷는 중입니다.\n");
		script.append("그런데 저 멀리서 오토바이 무리가 뿌연 매연을 날리며 우리에게 다가옵니다.\n");
		script.append("제발 지나가라 지나가라..애원하지만 뭔가 나에게 다가올 수록 속도가 늦쳐집니다.\n");
		script.append("그러다 폭주족 무리는 이내 원을 그리며 주인공을 감쌉니다.\n");
		script.append("당신은 겁에 질려 있는 와중에 무리의 리더로 보이는 사람이 천천히 접근합니다.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void printChoice() {
		if(getIsLoaded()) {
			selection.print();
			return;
		}
		selection.addSelection("칼로 싸웁니다.");
		selection.addSelection("총으로 싸웁니다.");
		selection.addSelection("도망칩니다.");
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
			if (Item.hasItem(Main.character, 000)) {
				script.append("당신은 다급하게 칼을 꺼내 폭주족에게 맞서기 시작합니다.\n");
				script.append(".     \n");
				script.append(".     \n");
				script.append(".     \n");
				Random random = new Random();
				if (random.nextInt(10) < 3) {
					script.append("하지만 칼로는 폭주족과 싸워서 이길 수 없었습니다.\n");
					script.append("당신은 상처를 입고 도망칩니다....\n");
					script.append("(체력 -2)\n");
					Main.character.setHealth(Main.character.getHealth() - 2);
				} else {
					script.append("놀라운 피지컬로 당신은 폭주족을 쫒아내는 것에 성공합니다.\n");
					script.append("그들은 무언가를 떨어뜨리며 도망칩니다.\n");
					script.append("떨어뜨리고 간 물건을 자세히 보니 탄약입니다!\n");
					script.append("(+ 탄약)\n");
					Main.character.addItem(new Item006_Ammunition());
				} 
			} else {
				script.append("아뿔싸 당신은 칼이 없습니다!\n");
				script.append("다급하게 도망치려 하지만 몸에 상처가 남고 맙니다.\n");
				script.append("(체력 -2)\n");
				Main.character.setHealth(Main.character.getHealth() - 2);
			}

		} else if (pChoice.equals("2")) {
			if (Item.hasItem(Main.character, 8)) {
				script.append("당신은 다급하게 총을 꺼내 폭주족에게 맞서기 시작합니다.\n");
				script.append(".     \n");
				script.append(".     \n");
				script.append(".     \n");
				Random random1 = new Random();
				if (random1.nextInt(10) < 1) {
					script.append("하지만 총 한자루로는 폭주족을 전부 물리치기에는 부족했습니다.\n");
					script.append("당신은 상처를 입고 도망칩니다....\n");
					script.append("(체력 -2)\n");
					Main.character.setHealth(Main.character.getHealth() - 2);
				} else {
					script.append("놀라운 피지컬로 당신은 폭주족을 쫒아내는 것에 성공합니다.\n");
					script.append("그들은 무언가를 떨어뜨리며 도망칩니다.\n");
					script.append("떨어뜨리고 간 물건을 자세히 보니 탄약입니다!\n");
					script.append("(+ 탄약)\n");
					Main.character.addItem(new Item006_Ammunition());
				} 
			} else {
				script.append("아뿔싸 당신은 총이 없습니다!\n");
				script.append("다급하게 도망치려 하지만 몸에 상처가 남고 맙니다.\n");
				script.append("(체력 -2)\n");
				Main.character.setHealth(Main.character.getHealth() - 2);
			}
		} else if (pChoice.equals("3")) {
			script.append("당신은 발바닥에 불이나게 도망쳤지만 약간의 상처를 입고 말았습니다.\n");
			script.append("(체력 -1)\n");
			Main.character.setHealth(Main.character.getHealth() - 1);
		}
		ConsolePrint.printResult(script, getIsLoaded());
	}
}
