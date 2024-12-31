package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item015_Drug;

public class Event000_Start extends Event {
	public Event000_Start() {
		setEventId(0);
		setName("시작");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("\"3차세계 대전 이후 폐허가 된 이후의 세계인 2055년,\n");
		script.append("당신은 특별한 재주나 능력은 없어도 그저 성실히 버려진 물건들을 줍고 팔아가며 생활하고 있습니다.\n");
		script.append("늘 그렇듯 자주가던 뒷산에서 무언가 쓸만한게 없나 찾아보던 찰나에 그날따라 유난히 안가던 길로 가고 싶어합니다.\n");
		script.append("그래서 길이 나지 않은 곳으로 깊이 들어갑니다.\n");
		script.append("그런데 당신은 뒷산에서 동네 갱단이 몰래 재배하고 있는 아편밭을 발견합니다.\n");
		script.append("아편 밭의 옆엔 돈가방과 포장된 약 한무더기가 보입니다.\n");
		script.append("세상에 마약이라니!\n");
		script.append("당신은 이 마약과 돈들을 어떻게 할지 고민에 빠지게 됩니다.\n\n");
		script.append("불태우고 돈만들고 튈 것인가? 마약과 돈 전부 들고 튈 것인가?\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void printChoice() {
		Selection selection = new Selection();

		selection.addSelection("마약을 전부 불태우고 돈가방만 챙겨서 튄다");
		selection.addSelection("마약과 돈가방을 들고 튄다");

		this.setsCount(selection.count);
		selection.print();
	}
	
	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		if (pChoice.equals("1")) {
			script.append("당신은 마약에 불을 질렀습니다! 그리고 돈가방을 챙기고 여행을 떠납니다.\n");
			script.append("(소지금 +500)\n");
			Main.character.setMoney(Main.character.getMoney()+500);
<<<<<<< HEAD
		}

		if (pChoice.equals("2")) {
			script.append("당신은 어차피 없앨 마약이라면 본인이 가져가는게 낫다라 생각하고 돈가방도 챙겨 떠납니다.\n");
=======
		}else if (pChoice.equals("2")) {
			script.append("당신은 어차피 없앨 마약이라면 본인이 가져가는게 낫다라 생각하고 돈가방도 챙겨 도망칩니다.\n");
>>>>>>> 591cec4b0b5e7b05fb851139a56f0d52f9e487cf
			script.append("(소지금 +500)\n");
			script.append("(+ 약)\n");
			Main.character.setMoney(Main.character.getMoney() + 500);
			Main.character.addItem(new Item015_Drug());
		}
		ConsolePrint.printResult(script, getIsLoaded()); // 결과 출력부
	}
}
