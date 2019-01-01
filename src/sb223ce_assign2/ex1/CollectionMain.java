package sb223ce_assign2.ex1;

public class CollectionMain {

	public static void main(String[] args) {
		IntList intList = new ArrayIntList();
		IntStack intStack = new ArrayIntStack();

		for (int i = 0; i < 20; i++) {
			intList.add(i);
			intStack.push(i);

			intList.get(i);
			intStack.peek();
		}

		print(intList, intStack);

		for (int i = 0; i < 10; i++) {
			intList.remove(intList.indexOf(i));
			intStack.pop();
		}

		print(intList, intStack);
	}

	static void print(IntList intList, IntStack intStack) {
		System.out.println("----------------------------IntList------------------------------" + "\nSize = "
				+ intList.size() + "\nToString = " + intList.toString()
				+ "\n--------------------------IntList------------------------------" + "\nSize = " + intStack.size()
				+ "\nToString = " + intStack.toString());
	}
}
