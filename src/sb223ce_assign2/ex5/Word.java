package sb223ce_assign2.ex5;

public class Word implements Comparable<Word> {

	private String word;

	public Word(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		return this.word;
	}

	@Override
	public int hashCode() {
		// convert to lower case to ignore case 
		int hash = this.word.toLowerCase().hashCode();
		return hash < 0 ? -hash : hash; // return positive hash code
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Word) {
			return this.hashCode() == ((Word) obj).hashCode(); // compare hash code
		}
		return false;
	}

	@Override
	public int compareTo(Word o) {
		return this.word.compareToIgnoreCase(o.word);
	}

	public String getWord() {
		return word;
	}
}
