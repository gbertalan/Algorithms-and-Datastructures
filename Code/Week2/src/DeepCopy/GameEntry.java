package DeepCopy;

public class GameEntry implements Cloneable{
	
	private int score;
	
	public GameEntry(int score) {
		this.score = score;
	}
	
	public Object clone() throws CloneNotSupportedException {
			return (GameEntry) super.clone();
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
}
