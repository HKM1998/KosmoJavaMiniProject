package consolegame.event;

import java.util.Random;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item004_FirstAidKit;
import consolegame.item.Item005_PainKiller;

public class Event061_AbandonedHospital_1 extends Event {
	public Event061_AbandonedHospital_1() {
		setEventId(61);
		setName("폐병원_1");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("문을 열고 들어가 보니 믿기지 않는 쇼킹한 일이 눈 앞에 벌어집니다.\n");
		script.append("어떤 눈이 퀭한 미친 의사가 마취도 없이 멀쩡해 보이는 인간의 장기를 꺼내고 있습니다.\n");
		script.append("장기를 적출 당하는 피해자는 더 이상의 비명도 불가능한지\n");
		script.append("신음소리만 흘리고 있습니다.\n");
		script.append("당신은 눈 앞에 벌어지는 명백한 불의한 상황과 공포스러운 감정 앞에\n");
		script.append("선택의 기로에 놓입니다.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void printChoice() {
		Selection selection = new Selection();

		selection.addSelection("뒷통수를 칼로 습격!");
		selection.addSelection("뒷통수를 총으로 습격!");
		selection.addSelection("몰래 뒷 선반에 있는 진통제를 빼돌려 나옵니다.");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		Random random = new Random();
		if (pChoice.equals("1")) { // 1번을 골랐을 경우 공격하기
			if (Item.hasItem(Main.character, 000)) { // 칼을 가지고 있을 경우 공격

				if (random.nextInt(10) < 4) { // 칼은 40% 확률로 패배 후 체력-1
					Main.character.setHealth(Main.character.getHealth() - 1);
					script.append("칼로 공격했지만 패배하고 (체력 -1) 잃었습니다.\n");
				} else {
					Main.character.addItem(new Item004_FirstAidKit()); // 10% 확률로 승리시 구급상자가 있을 때도 추가
					script.append("(구급상자)를 획득했다!.\n");
				}
			} else {
				script.append("아뿔싸 당신은 칼이 없습니다!\n");
				script.append("다급하게 도망치려 하지만 몸에 상처가 남고 맙니다.\n");
				script.append("(체력 -1)\n");
				Main.character.setHealth(Main.character.getHealth() - 1);
			}
		} else if (pChoice.equals("2")) {
			if (Item.hasItem(Main.character, 8)) { // 총을 가지고 있을 경우 공격
				if (random.nextInt(10) < 0) { // 총은 % 확률로 패배 후 체력 -1, 100% 확률로 승리 후 구급상자 획득
					Main.character.setHealth(Main.character.getHealth() - 1);
					script.append("총으로 공격했지만 패배하고 (체력 -1) 잃었습니다.\n");
				} else { // 기존에 구급상자 있을 때도 추가
					Main.character.addItem(new Item004_FirstAidKit());
					script.append("(구급상자)를 획득했다!.\n");
				}
			} else {
				script.append("아뿔싸 당신은 총이 없습니다!\n");
				script.append("다급하게 도망치려 하지만 몸에 상처가 남고 맙니다.\n");
				script.append("(체력 -1)\n");
				Main.character.setHealth(Main.character.getHealth() - 1);
			}
		} else if (pChoice.equals("3")) {
			Main.character.addItem(new Item005_PainKiller()); // 2번 선택시 진통제만 가져간다
			script.append("(진통제)를 획득했다!.\n");
		}
		ConsolePrint.printResult(script, getIsLoaded());
	}
}
