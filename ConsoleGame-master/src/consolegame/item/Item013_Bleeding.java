package consolegame.item;

import consolegame.character.Character;
import consolegame.event.Event;

public class Item013_Bleeding extends Item{

	public Item013_Bleeding() {
		setItemId(13);
		setName("출혈");
		setPrice(0); //가격
		setType("상태이상"); // 타입 관련된 정보 저장용 만들 예정
	}
	
	@Override
	public void effect(Character c, Event e) {
		
		c.setMental(c.getMental() + 1); // 현재 정신력 + 1
		c.setMoney(c.getMoney() -50); // 현재 자금 - 50
		if(e.getEventId() == 000) {
			
		}
	}

}
