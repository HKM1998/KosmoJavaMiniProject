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
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("당신은 길을 걷던 중 병원을 발견했습니다.\n");
		script.append("병원 내부는 스산하고 어두워 보입니다.\n");
		script.append("그런데 이런 생각에 오히려 다다르죠.\n");
		script.append("'아니 오히려 이런 곳이 인적이 드무니까 노다지 기회 아닌가?\n");
		script.append("그래 얼른 필요한것만 챙기고 나가자.' \n");
		script.append("이윽고 당신은 녹슨 문을 끼익 열었습니다.\n");
		script.append("그리곤 이 무서운 곳을 얼른 벗어나기 위해\n");
		script.append("필요한 물품을 찾아 여기 저기 헤메고 다닙니다.\n");
		script.append("이윽고 불이 켜진 방을 발견합니다!\n");
		script.append("당신은 이 방을 발견하고 생각에 잠깁니다.\n");
		script.append("들어갈까? 몰래 지나갈까?\n");
		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void printChoice() {
		Selection selection = new Selection();
		selection.addSelection("몰래 지나간다.");
		selection.addSelection("들어가봅니다");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		if (pChoice.equals("1")) { // 1번 우회한다 선택했을 경우 차트를 획득
			if (!Item.hasItem(Main.character, 007)) {
				script.append("당신은 호기심과 공포감의 두 줄다리기 사이에서\n");
				script.append("불이 켜진방을 그냥 지나치기로 결정 했습니다.\n");
				script.append("굳이 소름끼치게 들어갈게 뭐 있어? 그냥 아무거나 손에 잡히는거 가지고 나오지 뭐~\n");
				script.append("이런 가벼운 생각으로 다른 방을 둘러보던 중 알 수 없는 의료 차트를 발견합니다.\n");
				script.append("자신도 모르게 차트를 가지고 나오려는 순간 어마 무시한 괴성이 들렸오기 시작했습니다.\n");
				script.append("\"끄아아아아아아악!!\"\n");
				script.append(".     \n");
				script.append(".     \n");
				script.append(".     \n");
				script.append("당신은 애써 여러 생각을 무시하고 위협을 무릅쓰지 않고 벗어나기로 정합니다.\n");
				script.append("그리고는 개입은 불필요하다 합리화 시킵니다.\n");
				script.append("당신은 그렇게 자리를 황급히 뜹니다.\n");
				script.append("(+ 정체 불명의 의료 차트)\n");
				Main.character.getItem().add(new Item007_Chart()); // 아이템 차트 클래스 add
			}
		}else if (pChoice.equals("2")) {
			script.append("약간 후들거리긴 하지만 오히려 이런 곳이 노다지 일수도 있지!\n");
			script.append("당신은 끼이익 문을 열며 안으로 들어선다\n");
			Main.eMap.setEvent(this.getEventId());
		}
		ConsolePrint.printResult(script, getIsLoaded());
	}

}
