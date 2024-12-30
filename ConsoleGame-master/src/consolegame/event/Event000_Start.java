package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event000_Start extends Event {
	public Event000_Start() {
		setEventId(0);
		setName("시작");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice() {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection(" 도망친다.");
		this.setsCount(selection.count); // 추가된 선택지 수만큼 선택지 수 설정
		selection.print();
	}

	// 이벤트 스크립트 바로 화면에 출력
	@Override
	public void printScript() {
		// 화면 출력 스크립트 작성 형식은 추후 지정할 예정
		// 아래는 예시
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("\"3차세계 대전 이후 폐허가 된 세상에서 당신은 어느 마을에 태어났습니다.\n");
		script.append("평범한 여느 남자 아이들처럼 사고를 치기도 하며 사랑을 받기도 하며 자라났습니다. \n");
		script.append("그렇게 자라나 막 성인이 된 당신은 마을 여기 저기서 일을 하게 됩니다.\n");
		script.append("그러나 어느 순간 열지 말아야 할 판도라의 상자를 열게 되는데 \n");
		script.append("촌장의 뒷뜰에 몰래 재배 되고 있는 아편을 발견합니다.\n");
		script.append("그리곤 이내 이 아편을 어떻게 할지 고민에 빠지게 됩니다.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		// 텍스트 추가하기
		StringBuilder sb = new StringBuilder();
		sb.append("당신은 촌장의 눈을 피해 무사히 도망쳤습니다.\n");
		
		ConsolePrint.printResult(sb, getIsLoaded()); // 결과 출력부
	}
}
