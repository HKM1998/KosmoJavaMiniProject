package consolegame.item;

import consolegame.character.Character;
import consolegame.event.Event;

public class Item010_Meat extends Item{

	public Item010_Meat() {
		setItemId(10);
		setName("고기");
		setPrice(150); //가격
		setType("음식"); // 타입 관련된 정보 저장용 만들 예정
	}
	
	@Override
	public void effect(Character c, Event e) {
		
		c.setHealth(c.getHealth() + 2); // 현재 체력 +2
		c.setMental(c.getMental() + 2); // 현재 정신력 + 2
		
		if(e.getEventId() == 000) {
			
			c.setMoney(c.getMoney() - 150); // 현재 자금 + 0
		}
	}

}
