package sb223ce_assign2.ex1;

public interface IntList extends Iterable<Integer> {

    void add(int n);

    void addAt(int n, int index) throws IndexOutOfBoundsException;

    void remove(int index) throws IndexOutOfBoundsException;

    int get(int index) throws IndexOutOfBoundsException;

    int size();

    boolean isEmpty();

    int indexOf(int n);

    String toString();
}


