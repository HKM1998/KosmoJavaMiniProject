package consolegame.event;

import consolegame.character.Character;

public abstract class Event {
	private int eventId; // 이벤트ID
	private String name; // 이벤트 명
	private int weight; // 이벤트 가중치(턴에 따라 나오게 하기위함)
	private int score; // 이벤트 결과에 따른 점수
	
	// Getter/Setter
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public abstract void getScript();
	public abstract void getChoice(Character c);
	
	// 다음 이벤트 구하는 메서드 구현 필요
	static Event getNextEvent(Character c) {
		Event nextEvent = null;
		
		
		return nextEvent;
	}

	class Selection{
		int count = 1;
		StringBuilder selection = new StringBuilder();

		public String getSelection() {
			return selection.toString();
		}

		public void addSelection(String selection) {
			this.selection.append("=============================\n");
			this.selection.append(count++ + ". " + selection + "\\n");
			this.selection.append("=============================\n");
		}
		
		public void print() {
			System.out.println(selection);
		}
	}
}
