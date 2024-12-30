package consolegame.item;

import consolegame.character.Character;
import consolegame.event.Event;

public class Item004_FirstAidKit extends Item{

	int firstAidkit;
	public Item004_FirstAidKit() {
		setItemId(4);
		setName("구급상자");
		setPrice(0); //가격
		setType("구급약"); // 타입 관련된 정보 저장용 만들 예정
	}
	
	public int getFirstaidkit() {
		return firstAidkit;
	}

	public void setFirstaidkit(int firstAidkit) {
		this.firstAidkit = firstAidkit;
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
