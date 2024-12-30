package consolegame.event;

import java.util.Random;

import consolegame.Main;
import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item003_DogMeat;
import consolegame.item.Item006_Ammunition;

public class Event040_WildDog extends Event {
	public Event040_WildDog() {
		setEventId(040);
		setName("들개");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice() {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("도망갑니다.");	
		selection.addSelection("칼로 싸웁니다");		
		selection.addSelection("총으로 싸웁니다");		
		this.setsCount(selection.count);
		selection.print();
	}

	// 이벤트 스크립트 바로 화면에 출력
	@Override
	public void printScript() {
		// 화면 출력 스크립트 작성 형식은 추후 지정할 예정
		// 아래는 예시
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("폐허가 된 도시에 어둠이 낮게 깔린다. 갑자기 으르렁 거리는 소리가 들립니다.\n");
		script.append("배고픔에 굶주린 들개 무리가 침을 질질 흘리며 주인공을 포위합니다.\n");
		script.append("내가 아무리 떠돌이 신세여도 그렇지 들개한테 잡아 먹히는 엔딩이 맞냐?\n");
		script.append("라고 중얼거린 당신은 이내 선택을 합니다.\n");


		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();

		if (pChoice.equals("1")) {                             
			Main.character.setHealth(Main.character.getHealth() - 1);                     
			script.append(getEventId() + ". " + getName() + "\n");
			script.append("마주치자마자 부리나케 도망쳤다. 체력은 -1이 되었습니다.\n");
		}

		if (pChoice.equals("2")) {                                      
			if (Item.hasItem(Main.character, 000)) {                                 

				Random random = new Random();                         

				if (random.nextInt(10) < 7) {                          
					Main.character.setHealth(Main.character.getHealth() - 2);
				} else if (!Item.hasItemType(Main.character, "DogMeat")) {
					Main.character.getItem().add(new Item003_DogMeat());             
				} else {
					Main.character.getItem().add(new Item003_DogMeat());          
				}

			}
		}
		if (pChoice.equals("3")) {
		if (Item.hasItem(Main.character, 8)) {                                    

			Random random1 = new Random();
			if (random1.nextInt(10) < 1) {                           
				Main.character.setHealth(Main.character.getHealth() - 2);
			} else if (!Item.hasItemType(Main.character, "DogMeat")) {         
				Main.character.getItem().add(new Item003_DogMeat());
			} else {                                                 
				Main.character.getItem().add(new Item003_DogMeat());
			}

		}
	  }
		ConsolePrint.printResult(script, getIsLoaded());
	}
}
