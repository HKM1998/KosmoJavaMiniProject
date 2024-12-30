package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event110_University extends Event {
	public Event110_University() {
		setEventId(110);
		setName("성균관대학교");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice(Character c) {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("자유민주주의에 대한 본인의 신념을 설파하고 떠난다.\n");
		
		selection.addSelection("반드시 무력이 갖춰져야만 어떤 신념이든 관철이 가능함을 얘기하고 떠난다\n");
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
		script.append("큰 대학을 마주쳤다. 이 대학의 중심 연단에는 수많은 학생들이 모여");
		script.append("난립하는 세상을 어떻게 운영 해야 하는지에 대한 토론이 이루어지고있다.\n");
		script.append("대한 토론이 이루어지고있다.\n");
		script.append("주인공은 무엇인가에 홀린 듯 연단에 갑자기 올라 가더니 마이크를 잡는다.\n");
		script.append("갑자기 올라 가더니 마이크를 잡는다.\n");
		

		ConsolePrint.printScript(script);
	}

	@Override
	public void getResult(Character c, String pChoice) {
		// 0번 아이템ID 가 있는 경우 실행
//		if (pChoice.equals("1")) {                           //1번선택시 Bad 엔딩이 Good 엔딩이 될 수 있는 선결 조건			
//		}                                                    //추가적인 이벤트는 없다

		// 무기가 있는경우 실행
//		if (pChoice.equals("2")) {							//2번선택시 역시 추가적인 이벤트는 없다.
//		}
	}
}
