package sb223ce_assign2.ex1;

public class ArrayIntList extends AbstractIntCollection implements IntList {

	@Override
	public void add(int n) {
		this.addAt(n, super.size);
	}

	@Override
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		// upper limit should be size + 1 so that element can be also added at the end
		if (super.checkIndex(index, super.size + 1)) {
			for (int i = super.size - 1; i >= index; i--) { // shift elements to right
				super.values[i + 1] = this.get(i);
			}
			super.values[index] = n; // add
			if (++super.size >= super.values.length) { // resize if needed
				super.resize();
			}
			return;
		}
		throw new IndexOutOfBoundsException();
	}

	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		if (super.checkIndex(index, super.size)) {
			for (int i = index; i < super.size - 1; i++) { // shift elements to left
				super.values[i] = this.get(i + 1);
			}
			super.size--;
			return;
		}
		throw new IndexOutOfBoundsException();
	}

	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		if (super.checkIndex(index, super.size)) {
			return super.values[index];
		}
		throw new IndexOutOfBoundsException();

	}

	@Override
	public int indexOf(int n) {
		for (int i = 0; i < super.size; i++) { // iterate over the elements
			if (this.get(i) == n) {
				return i; // found
			}
		}
		return -1; // not found
	}
}
