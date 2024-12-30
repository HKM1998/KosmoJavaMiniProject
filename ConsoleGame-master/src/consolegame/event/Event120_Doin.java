package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event120_Doin extends Event {
	public Event120_Doin() {
		setEventId(120);
		setName("도인");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice() {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("도사님은 왜 세상이 이렇게 돌아간다고 생각 하시나요?");
		
		selection.addSelection("그냥 그 찬물에서 우선 나오시고 나서 생각 하시는게 나을듯 한데요. ");
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
		script.append("광화문 청계천 강물 한가운데 앉아 있는 도인이 있다.");
		script.append("그는 지나가는 주인공한테 왜 세상이 \n");
		script.append("이렇게 돌아가는지 궁금하지 않냐고 한다.\n");
		script.append("정말 뜬금없지만 그렇기에 더욱 궁금했다.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		if (pChoice.equals("1")) {                       //1번 선택은 Good 엔딩의 Bad엔딩 선결조건 중 하나
			script.append("도인이 내뱉는 음양오행과 양명햑을 동원한 그럴듯한 그의 설명에\n");
			script.append("뭔가 세상 사람들이 근본적으로 잘못 되었다는 생각이 싹트게 된다.\n");
		}

		// 무기가 있는경우 실행
		if (pChoice.equals("2")) {                       //2번 선택 또한 대사만 있고 추가적인 이벤트는 없다.
			script.append("도인은 '그저 눈 앞에 있는 것에만 급급하여 자명한 것을 못보는구나. 안타깝구나'\n");
			script.append("라고 말한뒤 떠난다\n");
		}
		
		ConsolePrint.printResult(script, getIsLoaded()); // 결과 출력부
	}
}
