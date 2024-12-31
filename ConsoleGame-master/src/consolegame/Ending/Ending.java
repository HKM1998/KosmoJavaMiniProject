package consolegame.Ending;

public abstract class Ending {
	int endingId;
	String endingName;
	
	public abstract void printScript();
	
	public int getEndingId() {
		return endingId;
	}
	public void setEndingId(int endingId) {
		this.endingId = endingId;
	}
	public String getEndingName() {
		return endingName;
	}
	public void setEndingName(String endingName) {
		this.endingName = endingName;
	}
}
