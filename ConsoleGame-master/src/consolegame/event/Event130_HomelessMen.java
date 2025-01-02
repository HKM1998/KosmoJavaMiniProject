package consolegame.event;

import java.util.Random;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event130_HomelessMen extends Event {
	public Event130_HomelessMen() {
		setEventId(130);
		setName("노숙자");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("당신은 길거리를 지나던 중 이상한 냄새를 맡았습니다.\n");
		script.append("무언가 당신을 뒤에서 쫒아 오는 것이 느껴집니다.\n\n");
		script.append("............달그락 소리와 합께\n ");
		script.append("배고픔에 굶주린 노숙자들이 뒤에서 당신을 덮치려 합니다.\n");
		script.append("빠르게 달려 장소를 옮기지만 막다른 골목에 몰리고 말았습니다.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void printChoice() {
		Selection selection = new Selection();

		selection.addSelection("싸운다");
		selection.addSelection("도망친다 ");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		if (pChoice.equals("1")) {
			Random random = new Random();
			if (Item.hasItem(Main.character, 8)) {
				script.append("가지고 있던 총으로 위협하자 그들은 도망가기에 급급했습니다.\n");
				script.append("그들은 도망치는 길에 돈을 떨어뜨렸습니다!\n");
				script.append("(소지금 +200)\n");
				Main.character.setMoney(Main.character.getMoney() + 200);
			} else if (Item.hasItem(Main.character, 0)) {
				if (random.nextInt(10) < 7) {
					Main.character.setHealth(Main.character.getHealth() - 1);
					script.append("노숙자들과 싸웟으나 그들에게서 이길수 없었습니다.(체력 -1)\n");
				} else {
					script.append("노숙자들에게서 싸움에서 압도적으로 이겼습니다!\n");
					script.append("그들에게서 돈을 강탈합니다.\n");
					script.append("(소지금 +100)\n");
					Main.character.setMoney(Main.character.getMoney() + 50); // 30% 소지금 중가
				}
			} else {
				script.append("당신은 가진 무기가 없어 맨손으로 그들과 맞서기 시작합니다.\n");
				script.append(".     \n");
				script.append(".     \n");
				script.append(".     \n");
				int rand = random.nextInt(10);
				if (rand > 7) {
					script.append("노숙자들과 싸워 이겼으나 남은 것은 허탈함 뿐입니다.\n");
				} else if (rand > 3) {
					script.append("노숙자들과 싸우는 중 상처를 입고 도망칩니다.\n");
					script.append("(체력 -1)\n");
					Main.character.setHealth(Main.character.getHealth() - 1); // 30% 체력 감소
				} else {
					script.append("노숙자들에게서 싸움에서 압도적으로 이겼습니다!\n");
					script.append("그들에게서 돈을 강탈합니다.\n");
					script.append("(소지금 +100)\n");
					Main.character.setMoney(Main.character.getMoney() + 100); // 30% 소지금 중가
				}
			}
		} else if (pChoice.equals("2")) {
			script.append("노숙자들에게서 최선을 다해 도망쳤고 이내 아무도 쫒아오지 않는 것이 느껴집니다.\n");
			script.append("당신은 이곳에 안전한 곳이 없다는 생각에 정신이 아득해집니다.\n");
			script.append("(정신력 -1)\n");
			Main.character.setMental(Main.character.getMental() - 1);
		}

		ConsolePrint.printResult(script, getIsLoaded()); // 결과 출력부
	}
}
