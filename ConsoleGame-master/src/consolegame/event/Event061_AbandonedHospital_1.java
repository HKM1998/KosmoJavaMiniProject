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
		selection.addSelection("몰래 뒷 선반에 있는 진통제를 빼돌려 도망친다.");
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
				script.append("당신은 조심스럽게 칼을 꺼내들고 살금살금 의사의 뒤로 다가갑니다.\n");
				script.append(".     \n");
				script.append(".     \n");
				script.append(".     \n");
				if (random.nextInt(10) < 4) { // 칼은 40% 확률로 패배 후 체력-1
					script.append("의사는 당신이 접근하는 것을 눈치채고 오히려 당신을 공격합니다.\n");
					script.append("생각보다 의사의 저항이 거세 당신은 상처를 입고 제압에 성공합니다.\n");
					script.append("하지만 이미 의사가 장기를 꺼내던 사람은 죽은 뒤였고\n");
					script.append("당신은 상처를 입은 채 병원에서 벗어납니다.\n");
					script.append("(체력 -1)\n");
					Main.character.setHealth(Main.character.getHealth() - 1);
				} else {
					script.append("의사는 당신이 접근하는 것을 눈치채고 오히려 당신을 공격합니다.\n");
					script.append("생각보다 의사의 저항이 거세 당신은 상처를 입고 제압에 성공합니다.\n");
					script.append("하지만 이미 의사가 장기를 꺼내던 사람은 죽은 뒤였고\n");
					script.append("쓰러진 의사의 옆에 놓여진 상자를 발견하곤 상자를 가지고 병원을 벗어납니다.\n");
					script.append("(+ 구급상자)\n");
					Main.character.addItem(new Item004_FirstAidKit()); 
				}
			} else {
				script.append("아뿔싸 당신은 칼이 없습니다!\n");
				script.append("다급하게 도망치려 하지만 몸에 상처가 남고 맙니다.\n");
				script.append("(체력 -1)\n");
				Main.character.setHealth(Main.character.getHealth() - 1);
			}
		} else if (pChoice.equals("2")) {
			if (Item.hasItem(Main.character, 8)) { // 총을 가지고 있을 경우 공격
				script.append("당신은 조심스럽게 총을 꺼내들고 의사의 뒷통수를 겨눕니다.\n");
				script.append(".     \n");
				script.append(".     \n");
				script.append(".     \n");
				script.append("의사는 당신이 접근하는 것을 눈치채고 오히려 당신을 공격하려 했으나\n");
				script.append("총을 보고는 얌전히 투항합니다.\n");
				script.append("하지만 이미 의사가 장기를 꺼내던 사람은 죽은 뒤였고\n");
				script.append("쓰러진 의사의 옆에 놓여진 상자를 발견하곤 상자를 가지고 병원을 벗어납니다.\n");
				script.append("(+ 구급상자)\n");
				Main.character.addItem(new Item004_FirstAidKit());
			} else {
				script.append("아뿔싸 당신은 총이 없습니다!\n");
				script.append("다급하게 도망치려 하지만 몸에 상처가 남고 맙니다.\n");
				script.append("(체력 -1)\n");
				Main.character.setHealth(Main.character.getHealth() - 1);
			}
		} else if (pChoice.equals("3")) {
			Main.character.addItem(new Item005_PainKiller()); // 2번 선택시 진통제만 가져간다
			script.append("당신은 모르는 사람을 위해 위험을 감수하지 않았습니다.\n");
			script.append("뒤에 놓여진 진통제를 집어들고는 조심스래 병원을 빠져나갑니다.\n");
			script.append("(+ 진통제)\n");
		}
		ConsolePrint.printResult(script, getIsLoaded());
	}
}
