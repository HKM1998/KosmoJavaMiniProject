package consolegame.event;

import consolegame.Main;
import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event180_Suddenpoop extends Event {
	public Event180_Suddenpoop() {
		setEventId(180);
		setName("급똥");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printChoice() {
		Selection selection = new Selection();

		selection.addSelection("  꾸르르르르르... 윽..힘들더라도 조금만 참고 얼른 버려진 건물을 찾아보자.. ");

		selection.addSelection("  아흑... 참기 너무 힘든거 같다..근처 풀밭이라도 가서 해결하자. ");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append(" 크흡.. 걷던 도중 대장의 움직임이 심상치 않다. 아무래도 당장이라도 지릴것 같다.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		if (pChoice.equals("1")) {
			script.append("주변에 건물이라곤 전혀 찾을수없다.\n");
			script.append("아무래도 큰일난것 같다.\n");
			script.append("눈앞이 아득해진다.\n");
			script.append("이런.. 가는 길에 참지 못하고 지려버렸다.\n");

			Main.character.setMental(Main.character.getMental() - 3);

		} else if (pChoice.equals("2")) {
			script.append("안되겠다 지금 당장 바지를 내리고 싸야할것 같다.\n");
			script.append("수치스럽다.\n");
			script.append("푸드드드득...크흑\n");
			Main.character.setMental(Main.character.getMental() - 2);
		}

		ConsolePrint.printResult(script, getIsLoaded());

	}
}
