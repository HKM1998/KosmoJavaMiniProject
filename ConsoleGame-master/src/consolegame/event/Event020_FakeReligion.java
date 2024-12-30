package consolegame.event;

import consolegame.Main;
import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item002_Bible;

public class Event020_FakeReligion extends Event {
	public Event020_FakeReligion() {
		setEventId(020);
		setName("사이비종교");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice() {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("그냥 들어봅니다.");

		selection.addSelection("그냥 갑니다.");
		this.setsCount(selection.count);
		selection.print();
	}

	// 이벤트 스크립트 바로 화면에 출력
	@Override
	public void printScript() {

		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("어느 아줌마가 웃으며 접근한다.\n");
		script.append("총각 어딜 그렇게 가~ 여기 한번 좋은 말씀 있는데 좀 듣고가~\n");
		script.append("피하려고 했지만 아줌마가 막무가내로 앞을 막아서며 열정적으로 전도합니다.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder sb = new StringBuilder();
		StringBuilder script = new StringBuilder(); // 1번 선택시 Good 엔딩 루트의 Bad엔딩 선결조건 중 하나
		script.append(getEventId() + ". " + getName() + "\n");
		if (pChoice.equals("1")) { // 1번 선택 시 나오는 대사 추가
			script.append("일장연설을 듣고 나니 기가 다 빠진다.\n");
			script.append("그러나 아줌마는 이것도 인연이라며 성경을 선물합니다\n");
			Main.character.addItem(new Item002_Bible());
			script.append("\n아줌마에게서 성경을 얻었습니다.(+ 성경)\n");
		} else if (pChoice.equals("2")) {
			script.append("당신은 너무 지친 나머지 이야기를 듣지않고 지나쳤습니다.\n");
		}
		ConsolePrint.printResult(sb, getIsLoaded());
	}
}
