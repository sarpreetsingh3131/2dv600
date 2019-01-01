package sb223ce_assign2.ex5;

public interface WordSet extends Iterable<Word> {

    void add(Word word);

    boolean contains(Word word);

    int size();

    String toString();
}
