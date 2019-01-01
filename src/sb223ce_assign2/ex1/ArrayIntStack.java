package sb223ce_assign2.ex1;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {

    @Override
    public void push(int n) {
        super.values[super.size++] = n;
        if (super.size >= super.values.length) { // resize if needed
            super.resize();
        }
    }

    @Override
    public int pop() throws IndexOutOfBoundsException {
        if (super.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return super.values[--super.size]; // remove element from last
    }

    @Override
    public int peek() throws IndexOutOfBoundsException {
        if (super.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return super.values[super.size - 1]; // get element from last
    }
}
