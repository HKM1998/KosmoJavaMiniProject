package consolegame.item;

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

}
