package consolegame.character;

import java.util.ArrayList;
import java.util.List;

import consolegame.item.Item;

public class Character {
	private int health;
	private int mental;
	private int money;
	private List<Item> item = new ArrayList<Item>();
	private int maxHealth;
	private int maxMental;

	public Character() {
		this.health = 4;
		this.mental = 4;
		this.money = 50;
		this.maxHealth = 7;
		this.maxMental = 7;
	}
	
	// 세이브 데이터 있는 경우 생성자 다르게
	
	public boolean removeItem(int pItemId) {
		if(Item.hasItem(this, pItemId)) {
			return this.item.remove(Item.findItem(this, pItemId));
		}
		return false;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public int getMaxMental() {
		return maxMental;
	}

	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		if(health > maxHealth) health = maxHealth;
		this.health = health;
	}
	public int getMental() {
		return mental;
	}
	public void setMental(int mental) {
		if(mental > maxMental) mental = maxMental;
		this.mental = mental;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public List<Item> getItem() {
		return item;
	}
	public void addItem(Item item) {
		this.item.add(item);
	}
	
}
