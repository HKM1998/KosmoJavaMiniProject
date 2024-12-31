package consolegame.event;

import consolegame.console.ConsolePrint;

public class Event000_Start extends Event {
	public Event000_Start() {
		setEventId(0);
		setName("시작");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printChoice() {
		Selection selection = new Selection();

		selection.addSelection(" 전부 불태우고 도망친다.");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("\"3차세계 대전 이후 폐허가 된 세상에서 당신은 어느 마을에 태어났습니다.\n");
		script.append("평범한 여느 남자 아이들처럼 사고를 치기도 하며 사랑을 받기도 하며 자라났습니다. \n");
		script.append("그렇게 자라나 막 성인이 된 당신은 마을 여기 저기서 일을 하게 됩니다.\n");
		script.append("그러나 어느 순간 열지 말아야 할 판도라의 상자를 열게 되는데 \n");
		script.append("촌장의 뒷뜰에 몰래 재배 되고 있는 아편 밭을 발견합니다.\n");
		script.append("그리곤 이내 이 아편들을 어떻게 할지 고민에 빠지게 됩니다.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder sb = new StringBuilder();
		sb.append("당신은 촌장의 눈을 피해 무사히 도망쳤습니다.\n");

		ConsolePrint.printResult(sb, getIsLoaded()); // 결과 출력부
	}
}
