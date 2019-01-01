package sb223ce_assign2.ex3;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.*;
import sb223ce_assign2.ex1.ArrayIntStack;
import sb223ce_assign2.ex1.IntStack;

public class ArrayIntStackTest {

	private IntStack sut;

	@BeforeEach
	void setUp() {
		this.sut = new ArrayIntStack();
	}

	@Test
	void shouldPopTenElements() {
		this.push(10);
		try {
			this.pop(10);
		} catch (IndexOutOfBoundsException e) {
			fail();
		}
	}

	@Test
	void shouldPopTenThousandElements() {
		this.push(10000);
		try {
			this.pop(10000);
		} catch (IndexOutOfBoundsException e) {
			fail();
		}
	}

	@Test
	void shouldOnlyPopOneElement() {
		this.push(1);
		this.sut.pop();
		assertThrows(IndexOutOfBoundsException.class, () -> this.sut.pop());
	}

	@Test
	void shouldNotPopElement() {
		assertThrows(IndexOutOfBoundsException.class, () -> this.sut.pop());
	}

	@Test
	void shouldPeekAndReturnElement() {
		this.push(10);
		try {
			assertEquals(9, this.sut.peek());
		} catch (IndexOutOfBoundsException e) {
			fail();
		}
	}

	@Test
	void shouldPeekTwiceAndReturnSameElement() {
		this.push(10);
		try {
			assertEquals(9, this.sut.peek());
			assertEquals(9, this.sut.peek());
		} catch (IndexOutOfBoundsException e) {
			fail();
		}
	}

	@Test
	void shouldPeekElementAndSizeRemainSame() {
		this.push(10);
		try {
			this.sut.peek();
			assertEquals(10, this.sut.size());
		} catch (IndexOutOfBoundsException e) {
			fail();
		}
	}

	@Test
	void shouldNotPeekElement() {
		assertThrows(IndexOutOfBoundsException.class, () -> this.sut.peek());
	}

	@Test
	void shouldBeEmpty() {
		assertTrue(this.sut.isEmpty());
	}

	@Test
	void shouldNotBeEmpty() {
		this.push(1);
		assertFalse(this.sut.isEmpty());
	}

	@Test
	void sizeShouldBeZero() {
		assertEquals(0, this.sut.size());
	}

	@Test
	void sizeShouldBeTen() {
		this.push(10);
		assertEquals(10, this.sut.size());
	}

	@Test
	void sizeShouldBeTenThousand() {
		this.push(10000);
		assertEquals(10000, this.sut.size());
	}

	@Test
	void shouldReturnStringWithNoElement() {
		assertEquals(this.toString(0), this.sut.toString());
	}

	@Test
	void shouldReturnStringWithTenElements() {
		this.push(10);
		assertEquals(this.toString(10), this.sut.toString());
	}

	@Test
	void shouldReturnStringWithTenThousandElements() {
		this.push(10000);
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
		this.push(10);
		assertEquals(10, this.countIteratorSize(this.sut.iterator()));
	}

	@Test()
	void shouldReturnIteratorWithTenThousandElements() {
		this.push(10000);
		assertEquals(10000, this.countIteratorSize(this.sut.iterator()));
	}

	// helper methods

	private void push(int amount) {
		for (int i = 0; i < amount; i++) {
			this.sut.push(i);
		}
	}

	private void pop(int times) {
		for (int i = 0; i < times; i++) {
			this.sut.pop();
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