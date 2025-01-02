package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item000_Knife;
import consolegame.item.Item001_UncheckedMap;

public class Event010_EmptyCar extends Event {
	public Event010_EmptyCar() {
		setEventId(10);
		setName("빈차");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("으슥한 곳에 숨겨져 있는 자동차를 발견했습니다.\n");
		script.append("\"아니 뭐 이런 곳에 자동차를 둬? 이건 훔쳐 달라는거 아냐?\"\n");
		script.append("당신은 운이 좋았다는 생각을 하며 창문을 깨고 차 안으로 들어갑니다.\n");
		script.append("쨍그랑! 파편에 약간 긁히긴 했지만 어쨋든 성공적으로 열긴 했습니다.\n\n");
		script.append("빠앙! 빠앙! 빠앙! \n\n");
		script.append("하지만 그 순간 차에서 경적이 울리기 시작합니다!\n");
		script.append("누군가 오기전에 얼른 자리를 벗어나야겠군요!\n");
		script.append("당신은 다급하게 차량 내부를 확인하기 시작합니다.\n");
		script.append("그 순간 멀리서 누군가 다가오는 것이 보입니다.\n");
		script.append("마지막으로 한군데만 확인하고 차를 벗어나려고 합니다.\n");
		script.append("어느 곳을 확인할까요!?\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void printChoice() {
		Selection selection = new Selection();

		selection.addSelection("조수석 서랍");
		selection.addSelection("운전석 햇빛가리개");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		if (pChoice.equals("1")) {
			script.append("조수석 서랍을 열어보니 신문지에 감싸진 무언가가 있습니다.\n");
			script.append("당신은 그것을 집어들고 빠르게 자리를 벗어납니다.\n");
			script.append("(+ 칼)\n");
			Main.character.addItem(new Item000_Knife());
		} else if (pChoice.equals("2")) {
			script.append("운전석 햇빛가리개를 열어보니 종이가 툭하고 떨어집니다.\n");
			script.append("당신은 그것을 집어들고 빠르게 자리를 벗어납니다.\n");
			script.append("(+ 알 수 없는 지도)\n");
			Main.character.addItem(new Item001_UncheckedMap());
			Main.eMap.setEvent(getEventId());
		}

		ConsolePrint.printResult(script, getIsLoaded());
	}
}
