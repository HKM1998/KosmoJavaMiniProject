package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;

public class Event050_ConvinienceStore extends Event {
	public Event050_ConvinienceStore() {
		setEventId(50);
		setName("편의점");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice() {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("들어갑니다.");
		selection.addSelection("지나칩니다.");
		this.setsCount(selection.count);
		selection.print();
	}

	// 이벤트 스크립트 바로 화면에 출력
	@Override
	public void printScript() {

		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("저 멀리서 익숙한 초록색 간판이 보인다. 불빛에 이끌려 가까이 가 봅니다.\n");
		script.append("역시 이때쯤이면 나타날 때가 됐죠~ 다름아닌 편의점이군요.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		if (pChoice.equals("1")) {
			script.append(getEventId() + ". " + getName() + "\n");
			script.append("당신은 망설임 없이 편의점 안으로 들어갑니다.\n");
			Main.eMap.setEvent(this.getEventId());
		}

		if (pChoice.equals("2")) {
			script.append(getEventId() + ". " + getName() + "\n");
			script.append("근데 너무 대로변에 있어서 이미 쓸만한 물건은 다 가져 갔겠네\n");
			script.append("오히려 이상한 놈이 매복할 수 있으니 안 가는게 센스지~\n");
			script.append("당신은 미련 없이 편의점을 지나친다.\n");
		}
		ConsolePrint.printResult(script, getIsLoaded());
	}
}
