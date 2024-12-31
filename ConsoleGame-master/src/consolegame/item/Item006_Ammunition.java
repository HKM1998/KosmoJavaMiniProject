package consolegame.item;

public class Item006_Ammunition extends Item{

    int amAmount = 0;
	public int getAmAmount() {
		return amAmount;
	}

	public void setAmAmount(int amAmount) {
		this.amAmount = amAmount;
	}

	public Item006_Ammunition() {
		setItemId(6);
		setName("탄약");
		setPrice(50); //가격
		setType("무기"); // 타입 관련된 정보 저장용 만들 예정
		setAmAmount(0);
	}

	public Item006_Ammunition(int amAmount) {
		setItemId(6);
		setName("탄약");
		setPrice(0); //가격
		setType("무기"); // 타입 관련된 정보 저장용 만들 예정
		setAmAmount(amAmount);
	}

}
