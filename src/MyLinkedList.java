/**
 * @author chakkac5
 *implementing the interface to a generic linked list 
 */
import java.lang.reflect.Array;

public class MyLinkedList<T> implements MyList<T> {

	private Node head;

	private int size;

	public MyLinkedList() {
		head = null;
		size = 0;
	}

	@Override
	public boolean add(int index, T o) {
		// TODO Auto-generated method stub
		if (index == 0 || index > size || size == 0)
			throw new ArithmeticException("Index is not between 1 and size of list");

		if (o == null)
			throw new IllegalArgumentException("Data is not provided");

		Node newNode = new Node();
		newNode.data = o;

		Node curr = head;

		if (index == 1) {
			newNode.next = head;
			head = newNode;
		} else {
			// since head is already position 1, so we need to iterate 2 less than index
			for (int i = 0; i < index - 2; i++) {
				curr = curr.next;
			}

			// swapping the current node's location to newNode
			newNode.next = curr.next;
			curr.next = newNode;

		}

		size++;

		return true;
	}

	@Override
	public boolean add(T o) {
		// TODO Auto-generated method stub

		if (o == null)
			throw new IllegalArgumentException("Data is not provided");

		Node newNode = new Node();
		newNode.data = o;

		if (!isEmpty()) {
			Node curr = head;

			while (curr.next != null) {
				curr = curr.next;
			}

			curr.next = newNode;
		} else
			head = newNode;

		size++;

		return true;
	}

	@Override
	public boolean clear() {
		// TODO Auto-generated method stub
		if (!isEmpty())
			head = null;

		return true;
	}

	@Override
	public boolean contains(T o) {
		// TODO Auto-generated method stub

		if (o == null)
			throw new IllegalArgumentException("Data is not provided");

		Node curr = head;

		if (!isEmpty()) {
			while (curr != null) {
				if (curr.data == o)
					return true;

				curr = curr.next;
			}
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		if (index == 0 || index > size || size == 0)
			throw new ArithmeticException("Index is not between 1 and size of list");

		Node curr = head;

		for (int i = 0; i < index - 1; i++) {
			curr = curr.next;
		}

		T data = (T) curr.data;
		return data;
	}

	@Override
	public int indexOf(T o) {
		// TODO Auto-generated method stub
		if (o == null)
			throw new IllegalArgumentException("Data is not provided");

		Node curr = head;

		if (!isEmpty()) {
			int position = 0;

			while (curr != null) {
				if (curr.data == o)
					return position;

				curr = curr.next;
				position += 1;
			}
		}

		return -1;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size == 0)
			return true;

		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		if (index < 1 || index > size)
			throw new ArithmeticException("Index is not between 1 and size of list");

		Node curr = head;
		Node prev = null;
		if (!isEmpty()) {
			int position = 1;

			while (curr.next != null) {
				if (position == index) {
					if (prev == null)
						head = curr.next;
					else
						prev.next = curr.next;

					curr.next = null;
					size--;
					return (T) curr.data;
				}

				prev = curr;
				curr = curr.next;
				position += 1;
			}
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(T o) {
		// TODO Auto-generated method stub

		if (o == null)
			throw new IllegalArgumentException("Data is not provided");

		Node curr = head;
		Node prev = null;

		if (!isEmpty()) {
			while (curr != null) {
				if (curr.data == o) {
					if (prev == null)
						head = curr.next;
					else
						prev.next = curr.next;

					curr.next = null;
					size--;
					return (T) curr.data;
				}

				prev = curr;
				curr = curr.next;
			}
		}

		return null;
	}

	@Override
	public boolean set(int index, T element) {

		if (index < 1 || index > size)
			throw new ArithmeticException("Index is not between 1 and size of list");

		if (element == null)
			throw new IllegalArgumentException("Data is not provided");

		Node curr = head;
		Node prev = null;

		Node newNode = new Node();
		newNode.data = element;

		if (!isEmpty()) {
			int position = 1;

			while (curr != null) {
				if (position == index) {
					if (prev == null)
						head = newNode;
					else
						prev.next = newNode;

					newNode.next = curr.next;
					return true;
				}

				prev = curr;
				curr = curr.next;
				position += 1;
			}
		}

		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public MyList<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		if (fromIndex < 1 || fromIndex > size)
			throw new ArithmeticException("From Index is not between 1 and size of list");

		if (toIndex < 1 || toIndex > size)
			throw new ArithmeticException("To Index is not between 1 and size of list");

		if (fromIndex >= toIndex)
			throw new ArithmeticException("From Index must be less than To Index");

		Node curr = head;
		MyLinkedList<T> subList = new MyLinkedList<T>();
		if (!isEmpty()) {
			int position = 1;

			while (curr != null) {
				if (position >= fromIndex) {
					subList.add((T) curr.data);
				}

				if (position == toIndex) {
					return subList;
				}

				curr = curr.next;
				position += 1;
			}
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray(Class<T> componentType) {

		T[] arrayOfLL = (T[]) Array.newInstance(componentType, size);
		Node curr = head;

		if (!isEmpty()) {
			int position = 0;

			while (curr != null) {
				arrayOfLL[position] = (T) curr.data;

				curr = curr.next;
				position += 1;
			}
		}

		return arrayOfLL;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean swap(int position1, int position2) {

		if (position1 < 1 || position1 > size)
			throw new ArithmeticException("Position1 is not between 1 and size of list");

		if (position2 < 1 || position2 > size)
			throw new ArithmeticException("Position2 is not between 1 and size of list");

		if (position1 == position2)
			throw new ArithmeticException("Position1 cannot be equal to Position2");

		Node curr = head;

		Node position1Node = null;
		Node position2Node = null;

		if (!isEmpty()) {
			int position = 1;

			while (curr.next != null) {
				if (position == position1) {
					position1Node = curr;
				}

				if (position == position2) {
					position2Node = curr;
				}

				if (position1Node != null && position2Node != null) {

					T tempData = (T) position1Node.data;

					position1Node.data = position2Node.data;
					position2Node.data = tempData;

					return true;
				}

				curr = curr.next;
				position += 1;
			}
		}

		return false;
	}

	@Override
	public boolean shift(int positions) {
		// TODO Auto-generated method stub
		if (Math.abs(positions) > size)
			throw new ArithmeticException("Positions cannot be greater than size of list");

		if (Math.abs(positions) == 0)
			throw new ArithmeticException("Positions cannot be 0");

		int position = 1;
		int destinationPosition = 0;

		if (positions > 0) {
			// first lets get to positions - 1, store the next as new Head
			destinationPosition = positions;
		} else if (positions < 0) {
			// first lets get to (size - positions) this will give us the next head
			// store the next as new Head
			destinationPosition = (size + positions);
		}

		Node curr = head;
		Node prev = null;
		Node newHead = null;

		while (curr.next != null) {
			if (position == destinationPosition) {
				prev = curr;
				newHead = curr.next;
			}

			curr = curr.next;
			position++;
		}

		// once the previous item and new head are obtained, lets loop to end from the
		// new head
		// and attach the current head there and make new head as head
		if (prev != null) {
			// clear the prev.next
			prev.next = null;

			// setting the current for looping
			curr = newHead;
			while (curr.next != null) {
				curr = curr.next;

			}

			// adding head to the end, setting head to new item
			curr.next = head;
			head = newHead;

			return true;
		}

		return false;
	}

}
