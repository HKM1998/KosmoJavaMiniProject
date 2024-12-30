package consolegame.event;

import java.util.Random;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item004_FirstAidKit;

public class Event130_HomelessMen extends Event {
	public Event130_HomelessMen() {
		setEventId(130);
		setName("노숙자");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice(Character c) {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("싸운다");

		selection.addSelection("도망친다 ");
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
		script.append("지나가는데 이상한 냄새가 난다. ");
		script.append("배고픔에 굶주린 노숙자들이 뒤에서 몰래 미행을 한다. \n");
		script.append("걸음을 빠르게 옮기지만 막다른 골목에 몰리고 만다. 그들이 습격을 해 온다.\n");

		ConsolePrint.printScript(script);
	}

	@Override
	public void getResult(Character c, String pChoice) {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		if (pChoice.equals("1")) { // 1번을 골랐을 경우 공격하기
			if (Item.hasItem(c, 8)) { // 총을 가지고 있을 경우 공격
				script.append("가지고 있던 총으로 위협하자 그들은 도망가기에 급급했습니다.\n");
			} else if (Item.hasItem(c, 0)) { // 칼을 가지고 있을 경우 공격
				Random random = new Random();
				if (random.nextInt(10) < 7) { // 칼은 70% 확률로 패배 후 체력-1
					c.setHealth(c.getHealth() - 1); // 전리품 없음
					script.append("노숙자들과 싸웟으나 그들에게서 이길수 없었습니다.(체력 -1)\n");
				}else {
					script.append("노숙자들과 싸워 이겼으나 남은 것은 허탈함 뿐입니다.\n");
				}
			}
		} else if (pChoice.equals("2")) { // 2번 선택 또한 대사만 있고 추가적인 이벤트는 없다.
			script.append("노숙자들에게서 최선을 다해 도망쳤습니다.(정신력 -1)\n");
		}

		ConsolePrint.printResult(script); // 결과 출력부
	}
}
