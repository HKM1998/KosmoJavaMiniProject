package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item012_Thash;

public class Event190_Meal extends Event {
	public Event190_Meal() {
		setEventId(190);
		setName("배고픈 여자아이");
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
		script.append("당신은 우연히 거리를 걷던 중\n");
		script.append("주변 건물의 잔해에서 한 여자아이와 마주쳤습니다.\n");
		script.append("여자아이는 당신을 발견하곤 먹을걸 달라는듯 쫒아옵니다.\n\n");
		script.append("어떻할까?\n");
		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void printChoice() {
		if(getIsLoaded()) {
			selection.print();
			return;
		}
		selection.addSelection("먹을걸 주지 않고 무시한다.");
		selection.addSelection("당신도 먹을게 없다 나눠주지 않고 쫒아낸다.");
		selection.addSelection("거절하고 모든걸 빼았는다.");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void printResult(String pChoice) {
		if(getIsLoaded()) {
			ConsolePrint.printResult(script, getIsLoaded());
			return;
		}			
		script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");	
		if (pChoice.equals("1")) {
			script.append("당신은 분명히 여자아이를 보았지만\n");
			script.append("당장 혼자 사용할 물자도 부족한데 나눠줄 수는 없다고 생각했습니다.\n");
			script.append("못본 척 여자아이를 그냥 지나쳤습니다.\n");
		} else if (pChoice.equals("2")) {
			script.append("\"뭐야 이건? 꺼져\"\n");
			script.append("당신은 접근하는 소녀를 발로 걷어차고는 지나쳤습니다.\n");
			script.append("(+ 쓰레기짓)\n");
			Main.character.addItem(new Item012_Thash()); // 쓰레기
		} else if (pChoice.equals("3")) {
			script.append("여자아이는 별다른 저항도 하지못한 채로\n");
			script.append("당신에게 모든 것을 빼았겼습니다....\n ");
			script.append("당신은 상쾌함과 뿌듯함을 느꼈습니다. 정말 쓰레기인것 같다.....\n");
			script.append("(체력 -2, 정신력 +1, +쓰레기짓) \n");
			Main.character.setHealth(Main.character.getHealth() - 2);
			Main.character.setMental(Main.character.getMental() + 1);
			Main.character.addItem(new Item012_Thash()); // 쓰레기
		}
		ConsolePrint.printResult(script, getIsLoaded());

	}
}
