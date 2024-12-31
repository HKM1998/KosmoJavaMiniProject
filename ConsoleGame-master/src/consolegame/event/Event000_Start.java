package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;

public class Event000_Start extends Event {
	public Event000_Start() {
		setEventId(0);
		setName("시작");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printChoice() {
		Selection selection = new Selection();

		selection.addSelection("마약을 전부 불태우고 도망간다");
		selection.addSelection("마약을 가지고 도망간다");

		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("\"3차세계 대전 이후 폐허가 된 이후의 세계인 2055년,\n");
		script.append("당신은 특별한 재주나 능력은 없어도 그저 성실히 살아가고 있습니다.\n");
		script.append("늘 그렇듯 뒷산에서 산책을 하다가 그날따라 유난히 옆길로 새고 싶어합니다.\n");
		script.append("그래서 산길이 나지 않은 곳으로 깊이 들어갑니다.\n");
		script.append("그런데 당신은 뒷산에서 동네 갱단이 몰래 재배하고 있는 아편밭을 발견합니다.\n");
		script.append("이제 막 폐허에서 꽃을 피우려 하는 이 시기에 마약이라니!\n");
		script.append("그리고 다시생각해보니 최근에 이전에는 없었던 마약에취한 부랑자들이\n");
		script.append("조금씩 보이기 시작하는게 떠오릅니다.\n");
		script.append("그리곤 이내 이 마약을 어떻게 할지 고민에 빠지게 됩니다.\n\n");
		script.append("전부 불지르고 도망갈 것인가? 마약을 가지고 도망갈것인가?\n");


		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		
		
		if (pChoice.equals("1")) {
			script.append("당신은 마약에 불을 질렀습니다! 그리고 곧바로 도망을 칩니다.\n");
		}
		
		if (pChoice.equals("2")) {
			script.append("당신은 어차피 없앨 마약이라면 본인이 가져가는게 낫다라 생각하고 도망칩니다.\n");
			Main.character.setMoney(Main.character.getMoney() + 500);
		}
		ConsolePrint.printResult(script, getIsLoaded()); // 결과 출력부
	}
}
