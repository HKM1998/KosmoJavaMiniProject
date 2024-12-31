package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;

public class Event210_Peddler extends Event {
	public Event210_Peddler() {
		setEventId(210);
		setName("행상인");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printChoice() {
		Selection selection = new Selection();
		selection.addSelection(" 칼을 판다. ");
		selection.addSelection(" 모르는 사람의 여권을 판다. ");
		selection.addSelection(" 성경을 판다.");
		selection.addSelection(" 개고기를 판다.");
		selection.addSelection(" 구급상자를 판다.");
		selection.addSelection(" 진통제를 판다.");
		selection.addSelection(" 탄약을 판다.");
		selection.addSelection(" 총을 판다.");
		selection.addSelection(" 통조림을 판다.");
		selection.addSelection(" 고기를 판다.");
		selection.addSelection(" 보존식량을 판다.");
		selection.addSelection(" 아무것도 팔지않고 간다");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append(" 길을 가다보니 보따리 상인을 발견했다. \n");
		script.append(" (가지고있는 물건을 판매할수 있을것 같다.) \n");
		script.append(" 안녕하세요? \n");
		script.append(" 물건 좀 팔려고 합니다. ");
		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		if (pChoice.equals("1")) {
			script.append("당신 가격 너무 후려치는거 아냐..?\n");
			script.append("그래도 돈이 필요하니까.. 후..(자금 +50)");
			Main.character.removeItem(0);
			Main.character.setMoney(Main.character.getMoney() + 50);
		} else if (pChoice.equals("2")) {
			script.append("이건 좀 비싸게 팔수 있지 않을까\n");
			script.append("장난해..?(자금+0)");
			Main.character.removeItem(1);
		} else if (pChoice.equals("3")) {
			script.append("나에겐 쓸모없는 물건이니\n");
			script.append("제값만 쳐주쇼.\n");
			script.append("제길..(자금+0)");
			Main.character.removeItem(2);
		} else if (pChoice.equals("4")) {
			script.append("꺼림칙하니까\n");
			script.append("이 고기는 팔아야겠다.(자금+50)");
			Main.character.removeItem(3);
			Main.character.setMoney(Main.character.getMoney() + 50);
		} else if (pChoice.equals("5")) {
			script.append("당분간 쓸 일이 없을지도 모르지\n");
			script.append("제값만 쳐주쇼.\n");
			script.append("제길..이거 구하기 힘든거라고(자금+100)");
			Main.character.removeItem(4);
			Main.character.setMoney(Main.character.getMoney() + 100);
		} else if (pChoice.equals("6")) {
			script.append("당분간 쓸 일이 없을지도 모르지\n");
			script.append("제값만 쳐주쇼.\n");
			script.append("제길..이거 구하기 힘든거라고(자금+50)");
			Main.character.removeItem(5);
			Main.character.setMoney(Main.character.getMoney() + 50);
		} else if (pChoice.equals("6")) {
			script.append("당분간 쓸 일이 없을지도 모르지\n");
			script.append("제값만 쳐주쇼.\n");
			script.append("제기랄..이거 구하기 힘든거라고(자금+10)");
			Main.character.removeItem(6);
			Main.character.setMoney(Main.character.getMoney() + 10);
		} else if (pChoice.equals("7")) {
			script.append("당분간 쓸 일이 없을지도 모르지\n");
			script.append("제값만 좀 쳐주쇼.\n");
			script.append("제기랄..괜히 팔았나(자금+100)");
			Main.character.removeItem(8);
			Main.character.setMoney(Main.character.getMoney() + 100);
		} else if (pChoice.equals("9")) {
			script.append("아깝지만.\n");
			script.append("돈이 필요하니 어쩔수없지.(자금+10)");
			Main.character.removeItem(9);
			Main.character.setMoney(Main.character.getMoney() + 10);
		} else if (pChoice.equals("10")) {
			script.append("정말 아깝지만.\n");
			script.append("돈이 필요하니 어쩔수없지.(자금+100)");
			Main.character.removeItem(9);
			Main.character.setMoney(Main.character.getMoney() + 100);
		} else if (pChoice.equals("10")) {
			script.append("이건 별로 먹고싶지않다.(자금+10)");
			Main.character.removeItem(9);
			Main.character.setMoney(Main.character.getMoney() + 10);
		}
		ConsolePrint.printResult(script, getIsLoaded());
	}
}
