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
	
	@Override
	public void printScript() {
		
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("당신은 길을 걷던중 불빛에 이끌려 한 건물에 가까이 다가가 봅니다.\n");
		script.append(".     \n");
		script.append(".     \n");
		script.append(".     \n");
		script.append("자세히 보니 익숙한 초록색 간판입니다!\n");
		script.append("역시 이때쯤이면 나타날 때가 됐죠~ 다름 아닌 편의점이군요.\n");
		script.append("당신은 편의점에 들어갈지 말지 고민이 들기 시작합니다.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}
	
	@Override
	public void printChoice() {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("들어갑니다.");
		selection.addSelection("지나칩니다.");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void getResult(String pChoice) {
		if(getIsLoaded()) {
			ConsolePrint.printResult(script, getIsLoaded());
			return;
		}		
		script.append(getEventId() + ". " + getName() + "\n");		
		script = new StringBuilder();
		if (pChoice.equals("1")) {
			script.append("당신은 고민 끝에 편의점 안으로 들어가기로 결정합니다.\n");
			Main.eMap.setEvent(this.getEventId());
		}

		if (pChoice.equals("2")) {
			script.append("\"근데 너무 대로변에 있어서 이미 쓸만한 물건은 다 가져 갔겠네\n");
			script.append("오히려 이상한 놈이 매복할 수 있으니 안 가는게 센스지~\"\n");
			script.append("당신은 혼잣말을 하며 미련 없이 편의점을 지나칩니다.\n");
		}
		ConsolePrint.printResult(script, getIsLoaded());
	}
}
