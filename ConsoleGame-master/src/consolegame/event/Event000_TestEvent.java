package consolegame.event;

import consolegame.character.Character;

public class Event000_TestEvent extends Event{
	public Event000_TestEvent() {
		setEventId(000);
		setName("테스트용 이벤트");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void getChoice(Character c) {
		// 선택지 작성 
		Selection selection = new Selection();
		
		selection.addSelection(" 굶는다.");
		selection.addSelection(c.getItem().get(1).getItemScript() + "을 먹는다.");
		
		selection.print();
	}
	
	// 이벤트 스크립트 바로 화면에 출력
	@Override
	public void getScript() {
		// 화면 출력 스크립트 작성 형식은 추후 지정할 예정
		// 아래는 예시
		StringBuffer script = new StringBuffer();
		script.append("================================================\n");
		script.append(getEventId() +". " + getName() +"\n");
		script.append("테스트 스크립트 입니다.\\n");
		script.append("테스트 스크립트 입니다.\\n");
		script.append("테스트 스크립트 입니다.\\n");
		script.append("테스트 스크립트 입니다.\\n");
		script.append("================================================\\n");
		
		System.out.println(script.toString());
	}
}
