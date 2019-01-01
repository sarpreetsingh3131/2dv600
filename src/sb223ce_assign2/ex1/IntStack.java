package sb223ce_assign2.ex1;

public interface IntStack extends Iterable<Integer> {

    void push(int n);

    int pop() throws IndexOutOfBoundsException;

    int peek() throws IndexOutOfBoundsException;

    int size();

    boolean isEmpty();

    String toString();
}
