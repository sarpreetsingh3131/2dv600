package sb223ce_assign2.ex3;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sb223ce_assign2.ex1.ArrayIntList;
import sb223ce_assign2.ex1.IntList;

public class ArrayIntListTest {

	private IntList sut;

	@BeforeEach
	void setUp() {
		this.sut = new ArrayIntList();
	}

	@Test
	void shouldAddTenElementsAtParticularIndex() {
		for (int i = 0; i < 10; i++) {
			try {
				this.sut.addAt(i, i);
			} catch (IndexOutOfBoundsException e) {
				fail();
			}
		}
	}

	@Test
	void shouldAddTenThousandElementsAtParticularIndex() {
		for (int i = 0; i < 10000; i++) {
			try {
				this.sut.addAt(i, i);
			} catch (IndexOutOfBoundsException e) {
				fail();
			}
		}
	}

	@Test
	void shouldNotAddElementAtParticularIndex() {
		assertThrows(IndexOutOfBoundsException.class, () -> this.sut.addAt(1, 1));
	}

	@Test
	void shouldRemoveTenElements() {
		this.add(10);
		this.remove(10);
		assertEquals(0, this.sut.size());
	}

	@Test
	void shouldRemoveTenThousandElements() {
		this.add(10000);
		this.remove(10000);
		assertEquals(0, this.sut.size());
	}

	@Test
	void shouldOnlyRemoveOneElement() {
		this.add(1);
		this.remove(1);
		assertThrows(IndexOutOfBoundsException.class, () -> this.sut.remove(0));
	}

	@Test
	void shouldNotRemoveElement() {
		assertThrows(IndexOutOfBoundsException.class, () -> this.sut.remove(0));
	}

	@Test
	void shouldGetTenElements() {
		this.add(10);
		for (int i = 0; i < 10; i++) {
			assertEquals(i, this.sut.get(i));
		}
	}

	@Test
	void shouldGetTenThousandElements() {
		this.add(10000);
		for (int i = 0; i < 10000; i++) {
			assertEquals(i, this.sut.get(i));
		}
	}

	@Test
	void shouldNotGetElement() {
		assertThrows(IndexOutOfBoundsException.class, () -> this.sut.get(0));
	}

	@Test
	void shouldReturnElementsIndexex() {
		this.add(10000);
		for (int i = 0; i < 10000; i++) {
			assertEquals(i, this.sut.indexOf(i));
		}
	}

	@Test
	void shouldNotReturnElementsIndex() {
		this.add(10000);
		for (int i = 10000; i < 20000; i++) {
			assertEquals(-1, this.sut.indexOf(i));
		}
	}

	@Test
	void shouldNotReturnElementIndex() {
		assertEquals(-1, this.sut.indexOf(100));
	}

	@Test
	void shouldBeEmpty() {
		assertTrue(this.sut.isEmpty());
	}

	@Test
	void shouldNotBeEmpty() {
		this.add(1);
		assertFalse(this.sut.isEmpty());
	}

	@Test
	void sizeShouldBeZero() {
		assertEquals(0, this.sut.size());
	}

	@Test
	void sizeShouldBeTen() {
		this.add(10);
		assertEquals(10, this.sut.size());
	}

	@Test
	void sizeShouldBeTenThousand() {
		this.add(10000);
		assertEquals(10000, this.sut.size());
	}

	@Test
	void shouldReturnStringWithNoElement() {
		assertEquals(this.toString(0), this.sut.toString());
	}

	@Test
	void shouldReturnStringWithTenElements() {
		this.add(10);
		assertEquals(this.toString(10), this.sut.toString());
	}

	@Test
	void shouldReturnStringWithTenThousandElements() {
		this.add(10000);
		assertEquals(this.toString(10000), this.sut.toString());
	}

	@Test()
	void shouldReturnIterator() {
		assertNotNull(this.sut.iterator());
	}

	@Test()
	void shouldReturnEmptyIterator() {
		assertEquals(0, this.countIteratorSize(this.sut.iterator()));
	}

	@Test()
	void shouldReturnIteratorWithTenElements() {
		this.add(10);
		assertEquals(10, this.countIteratorSize(this.sut.iterator()));
	}

	@Test()
	void shouldReturnIteratorWithTenThousandElements() {
		this.add(10000);
		assertEquals(10000, this.countIteratorSize(this.sut.iterator()));
	}

	// helper methods

	private void add(int amount) {
		for (int i = 0; i < amount; i++) {
			this.sut.add(i);
		}
	}

	private void remove(int times) {
		for (int i = times - 1; i >= 0; i--) {
			this.sut.remove(i);
		}
	}

	private int countIteratorSize(Iterator<Integer> iterator) {
		int counter = 0;
		while (iterator.hasNext()) {
			iterator.next();
			counter++;
		}
		return counter;
	}

	private String toString(int amount) {
		String str = "";
		for (int i = 0; i < amount; i++) {
			str += i + " ";
		}
		return str.isEmpty() ? "[ ]" : "[ " + str.substring(0, str.length() - 1) + " ]";
	}
}