package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item012_Thash;
import consolegame.item.Item013_Bleeding;

public class Event160_Assassin extends Event {
	public Event160_Assassin() {
		setEventId(160);
		setName("마약상의암살시도");
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
		script.append("이 건물 저 건물 들어가며 물건을 뒤지던 당신은\n");
		script.append("어느날 행색이 초라하고 꼬질꼬질한 여자아이를 조우하고 말았습니다.\n");
		script.append("엮이면 곤란할것 같아서 관심을 주지않고 지나쳤으나 \n");
		script.append("이 아이가 나를 뒤따라오는 듯한 느낌이 듭니다.\n");
		script.append(".     \n");
		script.append(".     \n");
		script.append(".     \n");
		script.append("탕!!!     \n");
		script.append("갑자기 뒤에서 총성이 들립니다.\n");
		script.append("당신은 운이 좋게 총알에 스칩니다.\n");
		script.append("여자아이는 마약상이 나에게 보낸 암살자였습니다.\n");
		script.append("당신이 마약상의 물건을 건드린 행동의 보복인 듯 보입니다.\n");
		script.append("너무 어린데 어떻하지...?\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void printChoice() {
		if(getIsLoaded()) {
			selection.print();
			return;
		}
		selection.addSelection("날 죽이려 아이를 이용하는 못된 마약상에게 되갚아줘야겠다.");
		selection.addSelection("감히 날 죽이려 하다니 괘씸하다. 아이의 모든걸 빼앗은 뒤 죽이고 떠난다.");
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
			script.append("당신은 마약상의 부하들 찾아가 \n");
			script.append("몇몇 살해하였으나\n");
			script.append("쪽수에 밀려 결국 도망치게 된었습니다.\n");
			script.append("도망치는 과정에서 총에 맞아 부상을 당했습니다.\n");
			script.append("출혈이 너무 심합니다!\n");
			script.append("(체력-3, + 상태이상: 출혈)\n");
			Main.character.addItem(new Item013_Bleeding()); 
			Main.character.setHealth(Main.character.getHealth() - 3);
		} else if (pChoice.equals("2")) { 
			script.append("당신은 여자아이의 모든것을 빼앗곤 여자아이의 머리를 터트려 죽였습니다.\n");
			script.append("여자아이가 살짝 반항을 하는 바람에 피곤했지만 쌓였던 것들이 약간 해소되는 기분입니다.(쓰레기;;)\n");
			script.append("(체력-1, 정신력+2, +쓰레기짓)\n");
			Main.character.setHealth(Main.character.getHealth() - 1);
			Main.character.setMental(Main.character.getMental() + 2);
			Main.character.addItem(new Item012_Thash()); // 쓰레기
		}

		ConsolePrint.printResult(script, getIsLoaded());
	}
}
