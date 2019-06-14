public class LinkedIntList {

	private ListNode front; // first value in the list

	// construct an empty list
	public LinkedIntList() {
		front = null;
	}

	// append a value to the end of the list
	public void add(int value) {
		if (front == null) {
			front = new ListNode(value);
		} else {
			ListNode current = front;
			while (current.next != null) {
				current = current.next;
			}

			current.next = new ListNode(value);
		}
	}

	// insert a value at a specified index
	public void add(int index, int value) {
		if (index == 0) {
			front = new ListNode(value, front);
		} else {
			ListNode current = nodeAt(index - 1);
			current.next = new ListNode(value, current.next);
		}
	}

	// pre: 0 < index < size()
	// post: remove value at the given index
	public void remove(int index) {
		if (index == 0) {
			front = front.next;
		} else {
			ListNode current = nodeAt(index - 1);
			current.next = current.next.next;
		}
	}
	 

	// return the current # of elements in the list
	public int size() {
		int count = 0;
		ListNode current = front;
		while (current != null) {
			current = current.next;
			count++;
		}

		return count;
	}

	// return the value at a given index in the list
	public int get(int index) {
		return nodeAt(index).data;
	}

	// pre: 0 < index < size()
	// return a reference to the node at a given index
	private ListNode nodeAt(int index) {
		ListNode current = front;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		return current;
	}

	// isSorted
	// Returns true if the list is in sorted (nondecreasing) order and returns false
	// otherwise
	// An empty list is considered to be sorted.
	public Boolean isSorted() {
		ListNode current = front;

		// if list is empty
		if (current == null) {
			return true;
		} else {
			while (current.next != null) {
				int currVal = current.data; // current value in the list
				int nextVal = current.next.data; // next value in the list
				// System.out.println(currVal);
				// System.out.println(nextVal);
				// System.out.println(current.next);

				if (nextVal < currVal) {
					// next value is less than current value in list
					// list is not sorted return false;
					return false;
				}
				current = current.next;
			}

		}
		return true;
	}

	// return a comma separated, bracketed version of the list
	public String toString() {
		if (front == null) {
			return "[]";
		} else {
			String result = "[" + front.data;
			ListNode current = front.next;
			while (current != null) {
				result += ", " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}
}
