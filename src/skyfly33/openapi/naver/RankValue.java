package skyfly33.openapi.naver;

public class RankValue {

	private int rank;
	private String keyword;
	private int value;
	private String step;

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	@Override
	public String toString() {
		return "RankValue [rank=" + rank + ", keyword=" + keyword + ", value="
				+ value + ", step=" + step + "]";
	}

}
