package consolegame.item;

import consolegame.character.Character;
import consolegame.event.Event;

public abstract class Item {
	private String name; // 아이템 명
	private int price; // 가격
	private String type;
	private String itemScript;
	
	public abstract void effect(Character c,Event e); // 효과 지정(이벤트에 따라 다름, 캐릭터에 영향)

	public String getItemScript() {
		return itemScript;
	}
	public void setItemScript(String itemScript) {
		this.itemScript = itemScript;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
