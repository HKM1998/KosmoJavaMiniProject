package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item001_Passport;
import consolegame.item.Item008_Gun;

public class Event081_Marine_1 extends Event {
	public Event081_Marine_1() {
		setEventId(81);
		setName("해병대");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice(Character c) {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("우리의 피를 끓게 하는구만! 그렇다면 훗날 필요하다면 우리가 도움을 주도록 하지.\n"
				+ "훗날 필요하다면 월곡동 주변에서 '월곡 해병 전우회'를 찾아오라고.");
		
		
		
		selection.addSelection(" 우리 후배 기수가 힘들어 하는 모습을 보니 힘들군.\n"
				+ "당장 줄껀 총 한자루 이것밖에 없네.");
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
		script.append("사실 저는 동네 촌장의 폭정을 피해 달아 나고 있습니다.");
		script.append("언젠가는 마을로 돌아가 자유민주주의를 회복시키고 싶습니다. ");

		ConsolePrint.printScript(script);
	}

	@Override
	public void getResult(Character c, String pChoice) {
		// 0번 아이템ID 가 있는 경우 실행
		if (pChoice.equals("1")) {                                             //1번 선택시 Weird 엔딩의 Good 엔딩 선결조건 만족
			StringBuilder script = new StringBuilder();
			script.append(getEventId() + ". " + getName() + "\n");
			script.append("우리의 피를 끓게 하는구만! 그렇다면 훗날 필요하다면 우리가 도움을 주도록 하지\n");   
			script.append("훗날 필요하다면 월곡동 주변에서 '월곡 해병 전우회'를 찾아오라고.\n");
		}

		// 무기가 있는경우 실행
		if (pChoice.equals("2")) {
			if (!Item.hasItem(c, 8)) {
				c.getItem().add(new Item008_Gun());                                          //2번 선택시 총을 얻는다
			}
			StringBuilder script = new StringBuilder();
			script.append(getEventId() + ". " + getName() + "\n");
			script.append("우리 후배 기수가 힘들어 하는 모습을 보니 힘들군.\n");
			script.append("당장 줄껀 총 한자루 이것밖에 없네.\n");
			script.append("주인공은 '필승'을 외치고 떠난다\n");
		}
	}
}
