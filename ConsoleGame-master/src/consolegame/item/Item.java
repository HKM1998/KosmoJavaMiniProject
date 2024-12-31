package consolegame.item;

import java.util.List;
import java.util.stream.Collectors;

import consolegame.character.Character;

public class Item {
	private int itemId; // 아이템ID
	private String name; // 아이템 명
	private int price; // 가격
	private String type; // 아이템 타입

	/*
	 * hasItem : 아이템 id 기반 아이템이 있는지 확인
	 * c = 캐릭터
	 * pItemId = 조회 아이템 id
	 * return boolean
	 */
	public static boolean hasItem(Character c, int pItemId) {
		return c.getItem().stream().anyMatch(s -> s.getItemId() == pItemId);
	}
	
	/*
	 * hasItemType : 아이템 타입이 하나라도 있는지 확인
	 * c = 캐릭터
	 * pType = 조회 아이템 타입
	 * return boolean 
	 */
	public static boolean hasItemType(Character c, String pType) {
		return c.getItem().stream().anyMatch(s -> s.getType() == pType);
	}
	
	/*
	 * findItem : 아이템 id 로 조회
	 * c = 캐릭터
	 * pItemId = 조회 아이템 id
	 * return Item 
	 */
	public static Item findItem(Character c, int pItemId) {
		return (Item)c.getItem().stream().filter(id -> id.getItemId() == pItemId).findFirst().get();
	}
	
	/*
	 * findItemType : 아이템 타입으로 조회
	 * c = 캐릭터
	 * pType = 조회 아이템 타입
	 * return List<Item>
	 */
	public static List<Item> findItemType(Character c, String pType) {
		
		return c.getItem().stream().filter(id -> id.getType() == pType)
				.collect(Collectors.toUnmodifiableList());
	}
	
	// Getter/Setter
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
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
