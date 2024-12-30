package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event190_Meal extends Event {
	public Event190_Meal() {
		setEventId(190);
		setName("식사");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printChoice(Character c) {
		Selection selection = new Selection();
		selection.addSelection(" 1. 고기를 구워먹자. "); // (아이템: 고기) 존재 시 (체력+2, 정신력+2)	
		selection.addSelection(" 2. 간단한 보존식량이라도 꺼내 먹고 잠시라도 허기를 달래자."); // (정신력+1)
		selection.addSelection(" 3. 가진게 아무것도 없다.. 굶는다.."); // (체력-1, 정신력 -1)
		this.setsCount(selection.count);
		selection.print();
	}
	
	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append(" 무작정 걷다보니 배가 너무 고프다.. 뭐라도 꺼내 먹자. \n");
		ConsolePrint.printScript(script);
	}

	@Override
	public void getResult(Character c, String pChoice) {
		StringBuilder script = new StringBuilder();
		if (pChoice.equals("1"))  {
			script.append("오랜만에 먹는 고기라 환상적인 맛이다.");
			script.append("중독될 것 같다.");
			// 아이템 목록중에 고기가 있을때만 선택 가능
			c.removeItem(10);
			c.setHealth(getHealth()+2);  // 체력  +2
			c.setMental(getMental()+2);  // 정신력 +2
		}else{pChoice.equals("2");
			script.append("딱딱하고 맛이 없지만");	
			script.append("그래도 먹고 살아남아야 한다.");	
			c.removeItem(11); // 보존식량 존재 시
			c.setMental(getMental()+1);  // 정신력 +1
		}
		
		if (pChoice.equals("3"))
		script.append("꼬르르르륵... ");
		script.append("너무 배가 고프다.. ");
		script.append("서럽다. ");
		c.setHealth(getHealth()-1);
		c.setMental(getMental()-1);
		ConsolePrint.printResult(script);
		}
		
		
		
	private int getMental() {
		return 0;
	}

	private int getHealth() {
		return 0;
	}
}
