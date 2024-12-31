package consolegame.event;

import java.util.Random;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item006_Ammunition;
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
	public void printChoice() {
		Selection selection = new Selection();
		selection.addSelection("날 죽이려 아이를 이용하는 못된 마약상에게 되갚아주자.");
		selection.addSelection("감히 날 죽이려 하다니 괘씸하다, 그 아이의 모든걸 빼앗은뒤 죽이고 떠난다");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("이 건물 저 건물 들어가며 물건을 뒤지던 당신은\n");
		script.append("어느날 행색이 초라하고 꼬질꼬질한 여자아이를 조우한다.\n");
		script.append("엮이면 곤란할것 같아서 관심을 주지않고 지나쳤으나 \n");
		script.append("이 아이가 나를 뒤따라오는 듯한 느낌이 든다. 갑자기 총성이 뒤에서 들린다.\n");
		script.append("마약상이 나에게 보낸 암살자였다.\n");
		script.append("당신은 반사적으로 몸을 틀어 총을 피했다.\n");
		script.append("당신이 마약상의 재배농장을 불태운것에 대한 행동의 보복인듯 하다.\n");
		script.append("어떻할까?\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		if (pChoice.equals("1")) { // 1번을 골랐을 경우 공격하기
			script.append("당신은 마약상의 부하들을 몇몇 살해한 뒤 \n");
			script.append("쪽수에 밀려 결국 도망치게 된다.\n");
			script.append("도망치는 과정에서 부상을 당했다.\n");
			script.append("출혈이 너무 심하다.(체력-3, + 상태이상: 출혈)");
			Main.character.addItem(new Item013_Bleeding()); // 출혈 아이템 
			Main.character.setHealth(Main.character.getHealth()-3);
			}
		    else if (pChoice.equals("2")) { // Weird to Bad엔딩 루트로 가는 선결조건)
			script.append("당신은 여자아이의 모든것을 빼앗곤 여자아이의 머리를 터트려죽인다.\n");
			script.append("여자아이가 살짝 반항을 하는 바람에 피곤했지만 쌓였던 것들이 약간 해소되는 기분이다.)");
			script.append("(체력-1, 정신력+2, +쓰레기짓)\n");
			Main.character.setHealth(Main.character.getHealth()-1);
			Main.character.setMental(Main.character.getMental()+2);
			Main.character.addItem(new Item012_Thash()); // 쓰레기
		}
		
		ConsolePrint.printResult(script, getIsLoaded()); 
	}
}
