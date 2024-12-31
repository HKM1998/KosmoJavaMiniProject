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

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice() {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("칼로 싸웁니다.");
		selection.addSelection("총으로 싸웁니다.");
		selection.addSelection("도망칩니다.");
		this.setsCount(selection.count);
		selection.print();
	}

	// 이벤트 스크립트 바로 화면에 출력
	@Override
	public void printScript() {
		// 화면 출력 스크립트 작성 형식은 추후 지정할 예정
		// 아래는 예시
		StringBuilder script = new StringBuilder();
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
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		if (pChoice.equals("1")) {
			if (Item.hasItem(Main.character, 000)) {
				Random random = new Random();
				if (random.nextInt(10) < 1) {
					Main.character.setHealth(Main.character.getHealth() - 2);
					script.append("칼로 싸웠지만 패배하고 (체력 -2) 잃었습니다\n");
				} else if (!Item.hasItemType(Main.character, "Ammunition")) {
					Main.character.addItem(new Item006_Ammunition());
					script.append("(탄약+1)을 얻었습니다!.\n");
				} else {
					try {
						Item006_Ammunition ammunition = (Item006_Ammunition) (Item.findItem(Main.character, 6));
						ammunition.setAmAmount(ammunition.getAmAmount() + 1);
					} catch (ClassCastException e) {
						Main.character.removeItem(6);
						Main.character.addItem(new Item006_Ammunition());
						script.append("(탄약+1)을 얻었습니다!.\n");
					}
				}
			}

		}
		if (pChoice.equals("2")) {
			if (Item.hasItem(Main.character, 8)) {
				Random random1 = new Random();
				if (random1.nextInt(10) < 0) {
					Main.character.setHealth(Main.character.getHealth() - 2);
					script.append("총으로 싸웠지만 패배하고 (체력 -2) 잃었습니다\n");
				} else if (!Item.hasItemType(Main.character, "Ammunition")) {
					Main.character.addItem(new Item006_Ammunition());
					script.append("(탄약+1)을 얻었습니다!.\n");
				} else {
					try {
						Item006_Ammunition ammunition = (Item006_Ammunition) (Item.findItem(Main.character, 6));
						ammunition.setAmAmount(ammunition.getAmAmount() + 1);
					} catch (ClassCastException e) {
						Main.character.removeItem(6);
						Main.character.addItem(new Item006_Ammunition());
						script.append("(탄약+1)을 얻었습니다!.\n");

					}
				}
			}
		}
		if (pChoice.equals("3")) {
			Main.character.setHealth(Main.character.getHealth() - 1);
			script.append("발바닥에 불이나게 도망쳤지만 약간의 피해를 입고 체력을 -1 잃었습니다.\n");
		}
		ConsolePrint.printResult(script, getIsLoaded());
	}
}
