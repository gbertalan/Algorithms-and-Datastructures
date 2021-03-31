package DeepCopy;

public class Main {

	public static void main(String[] args) {

		GameEntry[] scoresA = new GameEntry[1];
		scoresA[0] = new GameEntry(43);

		GameEntry[] scoresB = new GameEntry[scoresA.length];

		try {

			for (int i = 0; i < scoresA.length; i++) {
				scoresB[i] = (GameEntry) scoresA[i].clone();
			}

		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		scoresA[0].setScore(30);  // Akar meg is valtoztathatnank az eredetit, a scoresB nem fog valtozni, mert ez egy deep copy!

		System.out.println(scoresB[0].getScore());
	}

}
