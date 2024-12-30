package consolegame.event;

import consolegame.Main;
import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item006_Ammunition;

public class Event031_PoliceStation_1 extends Event {
	public Event031_PoliceStation_1() {
		setEventId(031);
		setName("경찰서_1");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice() {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("자신을 희생하면서 까지 남겠다니 아직도 이런 사람이 있군요.");
		
		selection.addSelection("저도 같이 지키고 싶습니다. 무기를 얻을 수 있을까요?");
		this.setsCount(selection.count);
		selection.print();
	}

	// 이벤트 스크립트 바로 화면에 출력
	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("모든 사람들이 자신의 살길을 찾기 위해 나갔지만.\n");
		script.append("나는 남아 있는 몇사람이라도 지키고 싶었어.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		if (pChoice.equals("1")) {
			script.append(getEventId() + ". " + getName() + "\n");
			script.append("자네도 이런 험난한 곳에서 자기 한몸 정도는 잘 지킬수 있도록 하게\n");
			if (!Item.hasItemType(Main.character, "Ammunition")) {
				Main.character.getItem().add(new Item006_Ammunition()); // 10% 확률로 승리시 탄약이 없을 때 탄약 추가
			} else {
				try {
					Item006_Ammunition ammunition = (Item006_Ammunition)(Item.findItem(Main.character, 6)); // 10% 확률로 승리시 탄약이 있을 때도 추가
					ammunition.setAmAmount(ammunition.getAmAmount() + 1);
				}catch(ClassCastException e) {
					Main.character.removeItem(6);
					Main.character.getItem().add(new Item006_Ammunition()); // 10% 확률로 승리시 탄약이 없을 때 탄약 추가
					
				}
			}
		    script.append("아저씨로부터 탄약을 얻었다.\n");
		}
		if (pChoice.equals("2")) {
			script.append(getEventId() + ". " + getName() + "\n");
			script.append("아주 노골적으로 잿밥에만 관심이 있구만. 그냥 갈길 가쇼. 그리곤 쫓아냈다.\n");
		}
		ConsolePrint.printResult(sb, getIsLoaded());
	}
}
