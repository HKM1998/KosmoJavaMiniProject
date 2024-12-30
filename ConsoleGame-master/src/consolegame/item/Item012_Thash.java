package consolegame.item;

import consolegame.character.Character;
import consolegame.event.Event;

public class Item012_Thash extends Item{

	public Item012_Thash() {
		setItemId(12);
		setName("쓰레기");
		setPrice(0); //가격
		setType("악행"); // 타입 관련된 정보 저장용 만들 예정
	}
	
	@Override
	public void effect(Character c, Event e) {
		
		c.setMental(c.getMental() + 1); // 현재 정신력 + 1
		c.setMoney(c.getMoney() -50); // 현재 자금 - 50
		if(e.getEventId() == 000) {
			
		}
	}

}
