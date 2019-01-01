package sb223ce_assign2.ex4;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueTest {

	private QueueImpl<Integer> sut;

	@BeforeEach
	void setUp() {
		this.sut = new QueueImpl<>();
	}

	@Test
	void sizeShouldBeZero() {
		assertEquals(0, this.sut.size());
	}

	@Test
	void sizeShouldBeTen() {
		this.enqueue(10);
		assertEquals(10, this.sut.size());
	}

	@Test
	void sizeShouldBeTenThousand() {
		this.enqueue(10000);
		assertEquals(10000, this.sut.size());
	}

	@Test
	void shoudlBeEmpty() {
		assertTrue(this.sut.isEmpty());
	}

	@Test
	void shoudlNotBeEmpty() {
		this.enqueue(1);
		assertFalse(this.sut.isEmpty());
	}

	@Test
	void shoudlDequeueTenElements() {
		this.enqueue(10);
		try {
			this.dequeue(10);
		} catch (NoSuchElementException e) {
			fail();
		}
	}

	@Test
	void shoudlDequeueTenThousandElements() {
		this.enqueue(10000);
		try {
			this.dequeue(10000);
		} catch (NoSuchElementException e) {
			fail();
		}
	}
	
	@Test()
	void shoudlNotDequeueElement() {
		assertThrows(NoSuchElementException.class, () -> this.sut.dequeue());
	}

	@Test()
	void shoudlNotDequeueTenElements() {
		this.enqueue(9);
		this.dequeue(9);
		assertThrows(NoSuchElementException.class, () -> this.sut.dequeue());
	}

	@Test()
	void shoudlNotDequeueTenThousandElements() {
		this.enqueue(9999);
		this.dequeue(9999);
		assertThrows(NoSuchElementException.class, () -> this.sut.dequeue());
	}

	@Test()
	void shoudlReturnFirstElement() {
		this.enqueue(10000);
		assertEquals(0, (int) this.sut.first());
	}

	@Test()
	void shoudlNotReturnFirstElement() {
		assertThrows(NoSuchElementException.class, () -> this.sut.first());
	}

	@Test()
	void shoudlReturnLastElement() {
		this.enqueue(10000);
		assertEquals(9999, (int) this.sut.last());
	}

	@Test()
	void shoudlNotReturnLastElement() {
		assertThrows(NoSuchElementException.class, () -> this.sut.last());
	}

	@Test()
	void sizeShouldRemainSameAfterReturingFirstAndLastElements() {
		this.enqueue(10000);
		this.sut.first();
		this.sut.last();
		assertEquals(10000, this.sut.size());
	}

	@Test()
	void shouldReturnStringWithNoElement() {
		assertEquals(this.toString(0), this.sut.toString());
	}

	@Test()
	void shouldReturnStringWithTenElements() {
		this.enqueue(10);
		assertEquals(this.toString(10), this.sut.toString());
	}

	@Test()
	void shouldReturnStringWithTenThousandElements() {
		this.enqueue(10000);
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
		this.enqueue(10);
		assertEquals(10, this.countIteratorSize(this.sut.iterator()));
	}

	@Test()
	void shouldReturnIteratorWithTenThousandElements() {
		this.enqueue(10000);
		assertEquals(10000, this.countIteratorSize(this.sut.iterator()));
	}

	// helper methods

	private void enqueue(int amount) {
		for (int i = 0; i < amount; i++) {
			this.sut.enqueue(i);
		}
	}

	private void dequeue(int times) {
		for (int i = 0; i < times; i++) {
			this.sut.dequeue();
		}
	}

	private String toString(int amount) {
		String str = "";
		for (int i = 0; i < amount; i++) {
			str += i + ", ";
		}
		return str.isEmpty() ? "{}" : "{" + str.substring(0, str.length() - 2) + "}";
	}

	private int countIteratorSize(Iterator<Integer> iterator) {
		int size = 0;
		while (iterator.hasNext()) {
			iterator.next();
			size++;

		}
		return size;
	}
}
