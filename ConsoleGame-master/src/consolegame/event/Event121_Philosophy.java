package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item017_Philosophy_2;

public class Event121_Philosophy extends Event {
	public Event121_Philosophy() {
		setEventId(121);
		setName("철학의 길");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printScript() {
		if(getIsLoaded()) {
			ConsolePrint.printResult(script, getIsLoaded());
			return;
		}
		script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("당신은 길을 걷던 중 어딘가에서 본 형체가 있는 것을 목격했습니다.\n");
		script.append("가까이 다가가보니 이전 한강에서 마주친 이상한 도인입니다.\n\n");
		script.append("번쩍.....!\n\n");
		script.append("가부좌를 틀고 앉아 있던 도인이 눈을 뜨면서 말합니다.\n\n");
		script.append("\"자네 이제는 세상이 어떻게 돌아가는지 알 것 같나?\"\n\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}


	@Override
	public void printChoice() {
		if(getIsLoaded()) {
			selection.print();
			return;
		}
		selection.addSelection("\"이 할아버지 또 이러시네 세상이 개판인데 그럴 때냐구요!\"");
		selection.addSelection("당신은 정신이 이상해 보이는 상대에게 동정심을 느껴 돈을 주고 떠납니다.\n"
				+ "할아버지 날도 추운데 이거 드릴테니 얼른 들어가서 쉬세요.\n");
		if(Item.hasItem(Main.character, 16)) {
			selection.addSelection("\"살인으로 흘린 피가 이 땅을 죽음의 병으로 물들이고 있습니다.\n"
					+"세상이 어떻게 돌아가는지 이전에 왜 이렇게 되었는지 주변을 돌아보아야 합니다\"\n");
		}
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void getResult(String pChoice) {
		if(getIsLoaded()) {
			ConsolePrint.printResult(script, getIsLoaded());
			return;
		}		
		script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");		
		if (pChoice.equals("1")) {
			script.append("정체 불명의 도인은 혀를 차면서 당신에게 말합니다.\n\n");
			script.append("\"쯔쯧. 원인에 대해서 생각조차 하지 않다니 한심하구나.\"\n\n");
			script.append("노인은 당신의 말에 실망한듯 고개를 흔들며 떠나갑니다.\n");
		}else if (pChoice.equals("2")) { 
			script.append("\"젊은이 고마우이~ 이걸로 알사탕이나 사먹을게\"\n\n");
			script.append("역시나 정신이 이상한 사람이 맞았습니다.\n");
			script.append("그래도 다른 사람을 도왔다는 만족감에 당신은 기분이 좋아집니다.\n");
			script.append("(소지금 -100)");
			script.append("(정신력 +1)\n");
			Main.character.setMoney(Main.character.getMoney() - 100);
			Main.character.setMental(Main.character.getMental() + 1);
		}else if (pChoice.equals("3")) { 
			script.append("당신은 도인을 만난 후 그동안 생각해온 답에 대해 일장 연설을 시작합니다.\n");
			script.append("\"이렇게 무상한 삶의 끝에서 난 뭘 하고 있을까? 에 대해 생각해보신 적 있으십니까?"
					+ "그 생각의 끝에 저는.............................................\"\n");
			script.append(".                              \n");
			script.append(".                              \n");
			script.append(".                              \n");
			script.append("(2시간 후)\n");
			script.append("\"그만....그만해주게....\"\n");
			script.append("도인은 당신의 길어지는 이야기에 치가 떨린다는 듯이 도망갑니다.\n");
			script.append("그 모습을 지켜보던 당신은 오히려 사람들에게 자신의 생각을 널리 알려야 겠다고 다짐합니다.\n");
			script.append("(+ 철학2)\n");
			Main.character.addItem(new Item017_Philosophy_2());
		}
		
		ConsolePrint.printResult(script, getIsLoaded());
	}

}
