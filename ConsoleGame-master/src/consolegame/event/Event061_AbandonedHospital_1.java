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
	public void printChoice() {
		Selection selection = new Selection();

		selection.addSelection("뒷통수를 칼로 습격!");
		selection.addSelection("뒷통수를 총으로 습격!");
		selection.addSelection("몰래 뒷 선반에 있는 진통제를 빼돌려 나옵니다.");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("문을 열고 보니 믿기지 않는 쇼킹한 일이 눈 앞에 벌어집니다.\n");
		script.append("어떤 눈이 퀭한 미친 의사가 마취도 없이 멀쩡해 보이는 인간의 장기를 꺼내고 있습니다.\n");
		script.append("장기를 적출 당하는 피해자는 더이상의 비명도 불가능한지\n");
		script.append("으으윽.. 하는 신음소리만 내고 있습니다.\n");
		script.append("당신은 눈 앞에 벌어지는 명백한 불의한 상황과 공포스러운 감정 앞에\n");
		script.append(" 선택의 기로에 놓이게 됩니다.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		if (pChoice.equals("1")) { // 1번을 골랐을 경우 공격하기
			if (Item.hasItem(Main.character, 000)) { // 칼을 가지고 있을 경우 공격

				Random random = new Random();

				if (random.nextInt(10) < 4) { // 칼은 40% 확률로 패배 후 체력-1
					Main.character.setHealth(Main.character.getHealth() - 1);
					script.append("칼로 공격했지만 패배하고 체력을 -1 잃었습니다.\n");
				} else if (!Item.hasItemType(Main.character, "FirstAidKit")) { // 아이템 FirstAidKit 클래스 임포트
					Main.character.getItem().add(new Item004_FirstAidKit()); // 10% 확률로 승리시 구급상자가 없을때 추가
					script.append("구급상자를 획득했다!.\n");
				} else {
					Main.character.getItem().add(new Item004_FirstAidKit()); // 10% 확률로 승리시 구급상자가 있을 때도 추가
					script.append("구급상자를 획득했다!.\n");
				}
			}

		}
		if (pChoice.equals("2")) {
		if (Item.hasItem(Main.character, 8)) { // 총을 가지고 있을 경우 공격

			Random random1 = new Random();
			if (random1.nextInt(10) < 0) { // 총은 % 확률로 패배 후 체력 -1, 100% 확률로 승리 후 구급상자 획득
				Main.character.setHealth(Main.character.getHealth() - 1);
				script.append("총으로 공격했지만 패배하고 체력을 -1 잃었습니다.\n");
			} else if (!Item.hasItemType(Main.character, "FirstAidKit")) { // 기존에 구급상자 없을 경우 추가
				Main.character.getItem().add(new Item004_FirstAidKit());
				script.append("구급상자를 획득했다!.\n");
			} else { // 기존에 구급상자 있을 때도 추가
				Main.character.getItem().add(new Item004_FirstAidKit());
				script.append("구급상자를 획득했다!.\n");
			}
		  }
		}
		if (pChoice.equals("3")) {
			if (!Item.hasItem(Main.character, 005)) {
				Main.character.getItem().add(new Item005_PainKiller()); // 2번 선택시 진통제만 가져간다
				script.append("진통제를 획득했다!.\n");
			}
		}
		ConsolePrint.printResult(script, getIsLoaded());
	}
}
