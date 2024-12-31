package consolegame.event;

import java.util.Random;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item006_Ammunition;

public class Event030_PoliceStation extends Event {
	public Event030_PoliceStation() {
		setEventId(30);
		setName("경찰서");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override

	public void printChoice() { // 구현하려고 하던 바는 경찰서에서 2번을 선택하고 칼 혹은 총으로 공격하려 했을 경우
		// 선택지 작성 //칼은 90% 확률로 지고 체력 -2, 10% 확률로 승리하고 탄약3개 획득
		Selection selection = new Selection(); // 총은 50% 확률로 지고 체력 -2, 50% 확률로 승리하고 탄약3개 획득 이었습니다.
												// 그런데 구현을 하고 보니 아무리 해도 이걸 getResult로 내려 보내는게 잘 안되고
		selection.addSelection("어쩌다가 혼자 이렇게 남게 됐나요?."); // 탄약을 3개 추가 하는 방법도 몰라서 보류 했습니다
		selection.addSelection("그냥 무시하고 칼로 위협하여 무기만 탈취 하려 합니다");
		selection.addSelection("그냥 무시하고 총으로 위협하여 무기만 탈취 하려 합니다");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("경찰서를 들어 갔는데 뭔가 썰렁하니 스산합니다.\n");
		script.append("아무도 없는 줄 알고 물건을 뒤지려 하자 갑자기 누구냐!! 라며 소리칩니다.\n");
		script.append("깜짝놀라 돌아보니 반짝반짝 빛나는 대머리에 올챙이 배가불룩 튀어나온 아재입니다.\n");
		script.append("그 사람은 자신을 이 구역의 자치경찰이라고 하네요 허허;;\n");
		script.append("당신은 그 사람의 장단을 맞춰주며 우선 정보를 캐낼까요 무기를 탈취할까요?\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		if (pChoice.equals("1")) { //
			script.append(getEventId() + ". " + getName() + "\n");
			script.append("경찰서로 안으로 들어가게 된다");
		}

		if (pChoice.equals("2")) { // 2번을 골랐을 경우 공격하는 것 추가
			if (Item.hasItem(Main.character, 000)) { // 칼을 가지고 있을 경우 공격
				Random random = new Random(); // java.util.Random 임포트 후
				if (random.nextInt(10) < 9) { // 칼은 90% 확률로 체력 -2
					Main.character.setHealth(Main.character.getHealth() - 2);
					script.append("체력이 -2 잃었습니다.\n");
				} else if (!Item.hasItemType(Main.character, "Ammunition")) {
					Main.character.addItem(new Item006_Ammunition()); // 10% 확률로 승리시 탄약이 없을 때 탄약 추가
					script.append("탄약을 새로 얻었습니다!.\n");
				} else {
					try {
						Item006_Ammunition ammunition = (Item006_Ammunition) (Item.findItem(Main.character, 6)); 
						ammunition.setAmAmount(ammunition.getAmAmount() + 1);
					} catch (ClassCastException e) {
						Main.character.removeItem(6);
						Main.character.addItem(new Item006_Ammunition()); // 10% 확률로 승리시 탄약이 없을 때 탄약 추가
						script.append("탄약을 새로 얻었습니다!.\n");

					}
				}
			}
		}
		if (pChoice.equals("3")) {
			if (Item.hasItem(Main.character, 8)) { // 총을 가지고 있을 경우 공격 (008은 8진수 인식 오류로 8로 수정)
				Random random1 = new Random();
				if (random1.nextInt(10) < 5) { // 칼은 50% 확률로 패배 후 체력 -2, 50% 확률로 승리 후 탄약 획득
					Main.character.setHealth(Main.character.getHealth() - 2);
					script.append("체력이 -2 잃었습니다.\n");
				} else if (!Item.hasItemType(Main.character, "Ammunition")) { // 기존에 탄약이 없을 경우 추가
					Main.character.addItem(new Item006_Ammunition());
					script.append("탄약을 새로 얻었습니다!.\n");
				} else { // 기존에 탄약이 있을 때도 추가
					try {
						Item006_Ammunition ammunition = (Item006_Ammunition) (Item.findItem(Main.character, 6)); 
						ammunition.setAmAmount(ammunition.getAmAmount() + 1);
					} catch (ClassCastException e) {
						Main.character.removeItem(6);
						Main.character.addItem(new Item006_Ammunition()); // 10% 확률로 승리시 탄약이 없을 때 탄약 추가
						script.append("탄약을 새로 얻었습니다!.\n");

					}
				}

			}
		}

		ConsolePrint.printResult(script, getIsLoaded());

	}
}
