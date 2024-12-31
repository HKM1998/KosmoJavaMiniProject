package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item012_Thash;

public class Event190_Meal extends Event {
	public Event190_Meal() {
		setEventId(190);
		setName("밥주기");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printChoice() {
		Selection selection = new Selection();
		selection.addSelection(" 먹을걸 주지 않고 무시한다. ");
		selection.addSelection(" 당신도 먹을게 없다 나눠주지 않고 쫒아낸다.");
		selection.addSelection(" 거절하고 모든걸 빼았는다.");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("당신은 우연히 거리를 걷다 주변 건물의 잔해에서 한 여자아이와 마주쳤다.\n");
		script.append("여자아이는 당신을 발견하곤 먹을걸 달라는듯 쫒아온다.\n");
		script.append("어떻할까?\n");
		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		if (pChoice.equals("1")) {
			script.append("당신은 그냥 지나쳤다.\n");	
			

		} else if (pChoice.equals("2")) {
			script.append("뭐야 이건? 꺼져\n");
			script.append("당신은 접근하는 소녀를 발로 걷어찼다.\n");
			script.append("(+쓰레기짓)\n");
			Main.character.addItem(new Item012_Thash()); // 쓰레기
		} else if (pChoice.equals("3")) {
			script.append("여자아이는 별다른 저항도 하지못한채로\n");
			script.append("당신은 여자아이의 모든걸 빼았았다.\n ");
			script.append("당신은 상쾌함과 뿌듯함을 느꼈다. 정말 쓰레기인것 같다. \n");
			script.append("(체력 -2, 정신력 +1, +쓰레기짓) \n");
			Main.character.setHealth(Main.character.getHealth() - 2);
			Main.character.setMental(Main.character.getMental() + 1);
			Main.character.addItem(new Item012_Thash()); // 쓰레기
		}
		ConsolePrint.printResult(script, getIsLoaded());

	}
}
