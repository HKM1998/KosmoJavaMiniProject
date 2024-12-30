package consolegame.event;

import java.util.Random;

import consolegame.Main;
import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item003_DogMeat;
import consolegame.item.Item004_FirstAidKit;
import consolegame.item.Item006_Ammunition;

public class Event051_ConvinienceStore_1 extends Event {
	public Event051_ConvinienceStore_1() {
		setEventId(51);
		setName("편의점_1");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice() {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("거부하고 상대와 칼로 싸운다");
		selection.addSelection("거부하고 상대와 총으로 싸운다");
		selection.addSelection("그냥 나간다");
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
		script.append("이미 선반은 헤집어지고 쓸만한 물건은 많이 없어보인다.\n");
		script.append("그런데 뒤에서 소리가 들린다.너는 어디서 온 누구냐?\n");
		script.append("여기는 우리가 오랫동안 집으로 여기고 있던 곳이야. 어서 썩 나가.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {

		StringBuilder script = new StringBuilder();
		if (pChoice.equals("1")) { // 2번을 골랐을 경우 공격하기
			if (Item.hasItem(Main.character, 000)) { // 칼을 가지고 있을 경우 공격

				Random random = new Random();

				if (random.nextInt(10) < 7) { // 칼은 70% 확률로 패배 후 체력-2
					Main.character.setHealth(Main.character.getHealth() - 2);
				} else if (!Item.hasItemType(Main.character, "FirstAidKit")) { // 아이템 FirstAidKit 클래스 임포트
					Main.character.getItem().add(new Item004_FirstAidKit()); // 10% 확률로 승리시 구급상자가 없을때 추가
					script.append(getEventId() + ". " + getName() + "\n");
					script.append("구급상자를 새로 얻었다!\n");
				} else {
					try {
						Item004_FirstAidKit firstaidkit = (Item004_FirstAidKit) (Item.findItem(Main.character, 4)); 																												
						firstaidkit.setFirstaidkit(firstaidkit.getFirstaidkit() + 1);
					} catch (ClassCastException e) {
						Main.character.removeItem(4);
						Main.character.getItem().add(new Item004_FirstAidKit()); // 10% 확률로 승리시 탄약이 없을 때 탄약 추가
						script.append(getEventId() + ". " + getName() + "\n");
						script.append("구급상자를 추가했다!\n"); // 10% 확률로 승리시 구급상자가 있을 때도 추가
					}

				}

			}
		}
		if (pChoice.equals("2")) {
			if (Item.hasItem(Main.character, 8)) { // 총을 가지고 있을 경우 공격

				Random random1 = new Random();
				if (random1.nextInt(10) < 1) { // 총은 10% 확률로 패배 후 체력 -2, 90% 확률로 승리 후 구급상자 획득
					Main.character.setHealth(Main.character.getHealth() - 2);
				} else if (!Item.hasItemType(Main.character, "FirstAidKit")) {
					Main.character.getItem().add(new Item004_FirstAidKit());
					script.append(getEventId() + ". " + getName() + "\n");
					script.append("구급상자를 새로 얻었다!\n"); // 90% 확률로 승리시 구급상자가 없을 때 구급상자 추가
				} else {
					try {
						Item004_FirstAidKit firstaidkit = (Item004_FirstAidKit) (Item.findItem(Main.character, 4));																												
						firstaidkit.setFirstaidkit(firstaidkit.getFirstaidkit() + 1);
					} catch (ClassCastException e) {
						Main.character.removeItem(4);
						Main.character.getItem().add(new Item004_FirstAidKit());
						script.append(getEventId() + ". " + getName() + "\n");
						script.append("구급상자를 추가했다!\n");

					}
				}
			}

		}
//		if (pChoice.equals("3")) {                                       //2번 선택시 나가는거 보류
//		
//	}
		ConsolePrint.printResult(script, getIsLoaded());
	}
}
