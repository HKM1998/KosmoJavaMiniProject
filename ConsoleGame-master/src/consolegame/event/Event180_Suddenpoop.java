package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item014_Stink;

public class Event180_Suddenpoop extends Event {
	public Event180_Suddenpoop() {
		setEventId(180);
		setName("급똥");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("크흡.. 걷던 도중 대장의 움직임이 심상치 않다.\n");
		script.append(".     \n");
		script.append(".     \n");
		script.append(".     \n");
		script.append("아무래도 당장이라도 지릴것 같다.\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void printChoice() {
		Selection selection = new Selection();

		selection.addSelection("꾸르르르르르... 윽..힘들더라도 조금만 참고 얼른 버려진 건물을 찾아보자.");
		selection.addSelection("아흑... 참기 너무 힘든거 같다..근처 풀밭이라도 가서 해결하자. ");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		if (pChoice.equals("1")) {
			script.append("주변에 건물이라곤 전혀 찾을 수 없습니다.\n");
			script.append("아무래도 큰일난것 같습니다.\n");
			script.append("당신은 눈앞이 아득해지는 것을 느낍니다.\n");
			script.append("이런.. 당신은 결국 가다가 참지 못하고 바지에 똥을 싸버렸습니다.\n");
			script.append("다 큰 어른이 이런 실수를 하다니 그래도 수치를 견디고 나아갑니다.\n");
			script.append("(정신력 -3, + 악취)\n");
			Main.character.addItem(new Item014_Stink());; // 악취 아이템
			Main.character.setMental(Main.character.getMental() - 3);

		} else if (pChoice.equals("2")) {
			script.append("안되겠다 지금 당장 바지를 내리고 싸야할것 같다.\n");
			script.append("수치스럽다.\n");
			script.append("푸드드드득...크흑\n");
			script.append("당신은 엄청난 수치심에 사로잡힙니다.\n");
			script.append("(정신력 -2)\n");
			Main.character.setMental(Main.character.getMental() - 2);
		}

		ConsolePrint.printResult(script, getIsLoaded());

	}
}
