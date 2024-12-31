package consolegame.event;

import java.util.Random;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item006_Ammunition;
import consolegame.item.Item012_Thash;
import consolegame.item.Item013_Bleeding;

public class Event160_GangAssassin extends Event {
	public Event160_GangAssassin() {
		setEventId(160);
		setName("갱단암살");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printChoice() {
		Selection selection = new Selection();
		selection.addSelection("아이를 이용하는 그 갱단을 찾아 되갚아주자.");
		selection.addSelection("그 아이의 모든걸 빼앗은뒤 죽이고 떠난다");
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
		script.append("그 구역을 장악하고 있던 갱단이 뒤에서 조종하고 있던 아이였다.\n");
		script.append("당신은 반사적으로 몸을 틀어 총을 피했다.\n");
		script.append("갱단의 구역 침범에 대한 보복이다.\n");
		script.append("어떻할까?");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		if (pChoice.equals("1")) { // 1번을 골랐을 경우 공격하기
			if (Item.hasItem(Main.character, 000)) { // 칼을 가지고 있을 경우 공격

				Random random = new Random();

				if (random.nextInt(10) < 8) { // 칼은 80% 확률로 패배 후 체력-4
					Main.character.setHealth(-1);
				} else if (!Item.hasItemType(Main.character, "Ammunition")) { // 아이템 Ammunition 클래스 임포트
					Main.character.getItem().add(new Item006_Ammunition()); // 20% 확률로 승리시 탄약이 없을때 추가
				} else {
					Main.character.getItem().add(new Item006_Ammunition()); // 20% 확률로 승리시 탄약이 있을 때도 추가
				}
				script.append("당신은 갱단의 건물을 찾아가서 깽판부리려 했으나 갱단을 상대하기엔\n");
				script.append("날붙이만으론 힘들었다.. \n");
				script.append("싸늘한 주검이 되었다. (게임오버)");

			}
			if (Item.hasItem(Main.character, 8)) { // 총을 가지고 있을 경우 공격

				Random random1 = new Random();
				if (random1.nextInt(10) < 2) { // 총은 20% 확률로 패배 후 체력 -1, 80% 확률로 승리 후 탄약 획득
					Main.character.setHealth(Main.character.getHealth() - 1);
				} else if (!Item.hasItemType(Main.character, "Ammunition")) { // 기존에 탄약 없을 때 추가
					Main.character.getItem().add(new Item006_Ammunition());
				} else {
					Main.character.getItem().add(new Item006_Ammunition()); // 기존에 탄약 있을 때도 추가
				}
				script.append("당신은 가진 총으로 갱단원을 몇몇 살해한 뒤 \n");
				script.append("쪽수에 밀려 결국 도망치게 된다.\n");
				script.append("도망치는 과정에서 부상을 당했다.\n");
				script.append("출혈이 너무 심하다.(체력-3, + 상태이상: 출혈)");
				Main.character.addItem(new Item013_Bleeding()); // 출혈 아이템 
				Main.character.setHealth(Main.character.getHealth()-3);
			}

		} else if (pChoice.equals("2")) { // Weird to Bad엔딩 루트로 가는 선결조건)
			script.append("당신은 여자아이의 모든것을 빼앗곤 여자아이의 머리를 깨트려죽인다.\n");
			script.append("살짝 피곤하지만 쌓였던 것들이 약간 해소되는 기분이다.(체력-1, 정신력+2, +쓰레기짓)");
			Main.character.setHealth(Main.character.getHealth()-1);
			Main.character.setMental(Main.character.getMental()+2);
			Main.character.addItem(new Item012_Thash()); // 쓰레기
		}
		
		ConsolePrint.printResult(script, getIsLoaded()); 
	}
}
