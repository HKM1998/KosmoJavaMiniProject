package consolegame.event;

import java.util.Random;

import consolegame.Main;
import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item003_DogMeat;
import consolegame.item.Item006_Ammunition;

public class Event040_WildDog extends Event {
	public Event040_WildDog() {
		setEventId(40);
		setName("들개");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice() {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection(" 도망간다.");
		selection.addSelection("칼로 싸운다");
		selection.addSelection("총으로 싸운다");
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
		script.append("폐허가 된 도시에 어둠이 낮게 깔린다. 갑자기 으르렁 거리는 소리가 들린다.\n");
		script.append("배고픔에 굶주린 들개 무리가 주인공을 포위한다.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();

		if (pChoice.equals("1")) { // 1 선택할 경우 체력 1깎임
			Main.character.setHealth(Main.character.getHealth() - 1); // 정신력-1은 구현된 메서드가 없어서 보류
			script.append(getEventId() + ". " + getName() + "\n");
			script.append("마주치자마자 부리나케 도망쳤다. 체력은 -1이 되었다.\n");
		}

		if (pChoice.equals("2")) { // 2번을 골랐을 경우 공격하기
			if (Item.hasItem(Main.character, 000)) { // 칼을 가지고 있을 경우 공격

				Random random = new Random();

				if (random.nextInt(10) < 7) { // 칼은 70% 확률로 패배 후 체력-2
					Main.character.setHealth(Main.character.getHealth() - 2);
				} else if (!Item.hasItemType(Main.character, "DogMeat")) {
					Main.character.getItem().add(new Item003_DogMeat()); // 아이템 DogMeat 클래스 임포트
					script.append(getEventId() + ". " + getName() + "\n");
					script.append("개고기를 새로 얻었다!\n");
				} // else { //개고기는 이 이벤트에서만 얻어서 else 지움
//					Main.character.getItem().add(new Item003_DogMeat());          // 10% 확률로 승리시 탄약이 있을 때도 추가
//				}
			}
		}
		ConsolePrint.printResult(script, getIsLoaded());
	}
}
