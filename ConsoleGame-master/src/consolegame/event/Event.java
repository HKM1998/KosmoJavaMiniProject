package consolegame.event;

import consolegame.console.ConsolePrint;

public abstract class Event {
	private int eventId; // 이벤트ID
	private String name; // 이벤트 명
	private int weight; // 이벤트 가중치(턴에 따라 나오게 하기위함)
	private int score; // 이벤트 결과에 따른 점수
	private int sCount;
	private boolean isLoaded;
	
	// Getter/Setter
	public boolean getIsLoaded() {
		return isLoaded;
	}
	public void setLoaded(boolean isLoaded) {
		this.isLoaded = isLoaded;
	}
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
	public int getsCount() {
		return sCount;
	}
	public void setsCount(int sCount) {
		this.sCount = sCount;
	}
	
	public abstract void printScript();
	public abstract void printChoice();
	public abstract void getResult(String pChoice);

	public void print() {
		ConsolePrint.clear();
		printScript();
		printChoice();
	}

	class Selection{
		int count = 0;
		StringBuilder selection = new StringBuilder();
		
		public void addSelection(String selection) {
			this.selection.append(++count + ". " + selection + "\n\t");
		}
		
		public void print() {
			ConsolePrint.printSelection(selection, getIsLoaded());
		}
	}
}
