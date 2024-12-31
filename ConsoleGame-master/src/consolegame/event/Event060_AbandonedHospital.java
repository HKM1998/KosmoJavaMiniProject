package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item007_Chart;

public class Event060_AbandonedHospital extends Event {
	public Event060_AbandonedHospital() {
		setEventId(60);
		setName("폐병원");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printChoice() {
		Selection selection = new Selection();

		selection.addSelection("몰래 우회합니다.");
		selection.addSelection("들어가봅니다");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("병원을 발견했습니다. 병원은 스산하고 어둡습니다. 다리가 후들후들 거립니다.\n");
		script.append("그런데 이런 생각에 오히려 다다르죠.\n");
		script.append("아니 오히려 이런 곳이 인적이 드무니까 노다지 기회 아닌가?\n");
		script.append("그래 얼른 필요한것만 챙기고 나가자. 이윽고 녹슨 문을 끼익 엽니다.\n");
		script.append("그리곤 이 무서운 곳을 벗어나 필요한 물품을 찾기 위해 여기 저기 찾아다닙니다.\n");
		script.append("그러다 이윽고 불이 켜진 방을 발견합니다.\n");
		script.append("당신은 이 방을 발견하고 생각에 잠깁니다. 들어갈까? 몰래 우회할까?\n");
		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		if (pChoice.equals("1")) { // 1번 우회한다 선택했을 경우 차트를 획득
			if (!Item.hasItem(Main.character, 007)) {
				Main.character.getItem().add(new Item007_Chart()); // 아이템 차트 클래스 임포트
				script.append("굳이 소름끼치게 들어갈께 뭐 있어? 그냥 아무거나 손에 집히는거 가지고 오지뭐~\n");
				script.append("이런 가벼운 생각으로 도움이 될지도 모르는 차트를 가지고 나오려는 순간,\n");
				script.append("끄아아아아아아악!!\n");
				script.append("별안간 어마 무시한 괴성이 들렸습니다.\n");
				script.append("당신은 호기심과 공포감의 두 줄다리기 사이에서\n");
				script.append("이미 차트를 가지고 있으니 더 이상의 개입은 불필요하다 합리화 시킵니다.\n");
				script.append("당신은 그렇게 자리를 황급히 뜹니다.\n");
			}
		}
		if (pChoice.equals("2")) { // 2번 들어갈 경우 061로 이동하는 것 보류
			script.append("2번 들어강 경우 061 이벤트로 이동하는것 보류상태\n");
		}
		ConsolePrint.printResult(script, getIsLoaded());
	}

}
