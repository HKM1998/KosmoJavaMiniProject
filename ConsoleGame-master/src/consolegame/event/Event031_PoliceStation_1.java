package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event031_PoliceStation_1 extends Event {
	public Event031_PoliceStation_1() {
		setEventId(031);
		setName("경찰서_1");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice(Character c) {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("1.자신을 희생하면서 까지 남겠다니 아직도 이런 사람이 있군요.");
		
		selection.addSelection("2.저도 같이 지키고 싶습니다. 무기를 얻을 수 있을까요?");
		this.setsCount(selection.count);
		selection.print();
	}

	// 이벤트 스크립트 바로 화면에 출력
	@Override
	public void printScript() {
		// 화면 출력 스크립트 작성 형식은 추후 지정할 예정
		// 아래는 예시
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("모든 사람들이 자신의 살길을 찾기 위해 나갔지만.\n");
		script.append("나는 남아 있는 몇사람이라도 지키고 싶었어.\n");

		ConsolePrint.printScript(script);
	}

	@Override
	public void getResult(Character c, String pChoice) {
		// 0번 아이템ID 가 있는 경우 실행
		if (Item.hasItem(c, 000)) {
			c.removeItem(000);
		}

		// 무기가 있는경우 실행
		if (Item.hasItemType(c, "무기")) {
		}
	}
}
