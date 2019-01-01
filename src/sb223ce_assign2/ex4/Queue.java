package sb223ce_assign2.ex4;

import java.util.NoSuchElementException;

public interface Queue<E> extends Iterable<E> {

    int size();

    boolean isEmpty();

    void enqueue(E element);

    E dequeue() throws NoSuchElementException;

    E first() throws NoSuchElementException;

    E last() throws NoSuchElementException;
}