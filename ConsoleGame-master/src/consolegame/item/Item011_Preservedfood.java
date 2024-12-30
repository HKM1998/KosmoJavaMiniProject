package consolegame.item;

import consolegame.character.Character;
import consolegame.event.Event;

public class Item011_Preservedfood extends Item{

	public Item011_Preservedfood() {
		setItemId(11);
		setName("보존식량");
		setPrice(50); //가격
		setType("음식"); // 타입 관련된 정보 저장용 만들 예정
	}
	
	@Override
	public void effect(Character c, Event e) {
		
		c.setMental(c.getMental() + 1); // 현재 정신력 + 1
		c.setMoney(c.getMoney() -50); // 현재 자금 - 50
		if(e.getEventId() == 000) {
			
		}
	}

}
