package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event090_MerchantFamily extends Event {
	public Event090_MerchantFamily() {
		setEventId(90);
		setName("상인가족");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice(Character c) {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection(" 정말 감사합니다. 그러나 큰 민폐를 끼칠 순 없는 노릇입니다.\n"
				                 + "밥 한끼 정도만 얻어 먹을 수 있을까요?");
		
		selection.addSelection(" 오랫동안 방랑을 하여 몸이 너무 지쳤습니다.\n"
				                 + "염치 없지만 하룻밤만 묵을 수 있을까요?\n");
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
		script.append("황폐한 건물만 끝없이 이어지던 그 거리에서 대덕상회라는 간판을 단 집을 발견한다.");
		script.append("피로한 몸과 배고픔에 지치던 주인공은 그 집을 두드린다.\n");
		script.append("문을 여니 부부와 아들딸이 하나씩 있는 집안이다\n");
		script.append("그 집에서는 주인공을 보며 놀랐지만, 이내 행색을 안쓰러워 하며 그를 들여보낸다.\n");

		ConsolePrint.printScript(script);
	}

	@Override
	public void getResult(Character c, String pChoice) {                     //Even091의 b를 제외하고는 Weird to Bad 엔딩 조건
		StringBuilder sb = new StringBuilder();
//		if (pChoice.equals("1")) {                                           //1번 선택시 Event091로 가는거 보류		
//		}

		// 무기가 있는경우 실행
		if (pChoice.equals("2")) {                                            //2번 선택시 창문으로 뛰어 내리고 체력 -1
			StringBuilder script = new StringBuilder();
			script.append(getEventId() + ". " + getName() + "\n");
			script.append("그런거야 뭐가 어렵겠습니까? 윗층에 있는 빈방으로 드시지요.\n");
			script.append("그러나 이내 뒤에서 문이 덜커덩 잠기더니 묵직한 무기를 들고 오는 소리가 들린다.\n");
			script.append("주인공은 필사적으로 창문을 깨고 2층 높이에서 뛰어 내린다가 다리를 삔다.\n");
			c.setHealth(c.getHealth() - 1);                                          
		}
		ConsolePrint.printResult(sb);
	}
}
