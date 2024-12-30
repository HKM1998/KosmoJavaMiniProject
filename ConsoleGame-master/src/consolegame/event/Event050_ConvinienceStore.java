package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event050_ConvinienceStore extends Event {
	public Event050_ConvinienceStore() {
		setEventId(050);
		setName("편의점");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice(Character c) {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("들어간다.");
		
		selection.addSelection("지나친다");
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
		script.append("저 멀리서 익숙한 초록색 간판이 보인다. 불빛에 이끌려 가까이 가 본다.\n");


		ConsolePrint.printScript(script);
	}

	@Override
	public void getResult(Character c, String pChoice) {
		// 0번 아이템ID 가 있는 경우 실행
//		if (pChoice.equals("1")) {                          //1번 들어가면 051로 가는거 보류
//			
//		}

//		if (pChoice.equals("2")) {                          //2번 지나치면 다른 이벤트로 가는거 보류
//		
//	}
	}
}
