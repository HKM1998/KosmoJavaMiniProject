package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;

public class Event120_Doin extends Event {
	public Event120_Doin() {
		setEventId(120);
		setName("한강 도인");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("당신은 길을 걷던 중 한강에 도착했다!\n");
		script.append("날씨는 추웟으나 오랫만에 보는 한강에 주변을 걷기로 하였다.\n\n");
		script.append("흠칫.....!\n\n");
		script.append("뜬금없이 산책로에 가부좌를 틀고 앉아 있는 도인이 있다.\n");
		script.append("그는 지나가는 당신에게 왜 세상이 \n");
		script.append("이렇게 돌아가는지 궁금하지 않냐고 한다.\n");
		script.append("정말 뜬금없는 상황이기에 더욱 도인의 생각이 궁금해졌다.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}
	
	@Override
	public void printChoice() {
		Selection selection = new Selection();

		selection.addSelection("\"도사님은 왜 세상이 이렇게 돌아간다고 생각 하시나요?\"");
		
		selection.addSelection("당신은 추위에 떨며 말한다.\n\"그런 생각을 하실 때가 아닌것 같은데요.\"");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		if (pChoice.equals("1")) {
			script.append("도인이 내뱉는 음양오행과 양명햑을 동원한 그럴듯한 그의 설명에\n");
			script.append("홀린듯이 듣고 있다보니 추위에 몸이 어는 듯한 느낌이 든다.(체력 -1)\n");
			Main.character.setHealth(Main.character.getHealth() - 1);
		}else if (pChoice.equals("2")) { 
			script.append("도인은 \"그저 눈 앞에 있는 것에만 급급하여 자명한 것을 못보는구나. 안타깝구나\n\n");
			script.append("라고 말한뒤 떠났습니다.\n");
			script.append("당신은 어이없어 하면 산책을 마저하고 자리를 떠납니다.\n");
		}
		
		ConsolePrint.printResult(script, getIsLoaded());
	}
}
