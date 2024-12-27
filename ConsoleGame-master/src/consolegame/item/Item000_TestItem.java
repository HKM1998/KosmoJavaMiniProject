package consolegame.item;

import consolegame.character.Character;
import consolegame.event.Event;

public class Item000_TestItem extends Item{

	public Item000_TestItem() {
		setItemId(000);
		setName("아이템명");
		setPrice(100); //가격
		setType("음식"); // 타입 관련된 정보 저장용 만들 예정
	}
	
	@Override
	public void effect(Character c, Event e) {
		// 아이템의 효과 동작
		// 캐릭터에 주는 영향, 이벤트에 주는 영향 
		// 이벤트에 따라 달라지는 경우 분기 처리
		c.setHealth(c.getHealth() - 1); // 현재 체력 -1
		c.setMental(c.getMental() + 1); // 현재 정신력 + 1
		c.setMoney(c.getMoney() + 50); // 현재 자금 + 50
		if(e.getEventId() == 000) {
			c.setHealth(c.getHealth() - 2); // 현재 체력 -2
			c.setMental(c.getMental() + 2); // 현재 정신력 + 
			c.setMoney(c.getMoney() + 0); // 현재 자금 + 0
		}
	}

}
