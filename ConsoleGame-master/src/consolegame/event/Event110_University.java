package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;

public class Event110_University extends Event {
	public Event110_University() {
		setEventId(110);
		setName("인근대학교");
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
		script.append("길을 걷던 중 당신은 대학을 발견했다.\n");
		script.append("당신은 고민을 하던 중 학교 안을 둘러보기로 하였다..\n");
		script.append("갑자기 교내 스피커에서 방송이 시작되더니\n");
		script.append("교내 운영에 대한 방송을 시작하더니 친숙한 노래들이 들려오기 시작한다.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}
	
	@Override
	public void printChoice() {
		if(getIsLoaded()) {
			selection.print();
			return;
		}
		selection.addSelection("오랫만에 듣는 노래에 흠뻑 빠져 감상한다.");
		selection.addSelection("교내에 사람이 있다는 사실에 긴장하며 자리를 벗어난다.");
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
		if(pChoice.equals("1")) {
			script.append("당신은 오랫만에 듣는 노래에 지쳣던 마음이 회복되는 것을 느꼈습니다.\n");
			script.append("(정신력 +1)\n");
			Main.character.setMental(Main.character.getMental() + 1);
		}else if(pChoice.equals("2")) {
			script.append("당신은 다행히 사람과 마주치기 전에 학교에서 벗어날 수 있었습니다.\n");
		}
		
		ConsolePrint.printResult(script, getIsLoaded()); // 결과 출력부
	}
}
