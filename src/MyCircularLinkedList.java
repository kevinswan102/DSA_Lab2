/**
 * @author chakkac5
 *implementing the interface to a generic circular linked list 
 */
import java.lang.reflect.Array;

public class MyCircularLinkedList<T> implements MyList<T> {

	private Node head;

	private Node tail;

	private int size;

	public MyCircularLinkedList() {
		head = null;
		tail = null;
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

		if (index == 1) {
			Node temp = head;
			newNode.next = temp;
			head = newNode;
			tail.next = head;
		} else {
			tail.next = newNode;
			tail = newNode;
			tail.next = head;
		}

		size++;

		return true;
	}

	@Override
	public boolean add(T o) {
		if (o == null)
			throw new IllegalArgumentException("Data is not provided");

		Node newNode = new Node();
		newNode.data = o;

		if (!isEmpty()) {
			newNode.next = head;
			tail.next = newNode;
			tail = newNode;
		} else {
			head = newNode;
			tail = newNode;
			tail.next = head;
			head.next = tail;
		}

		size++;

		return true;
	}

	@Override
	public boolean clear() {
		// TODO Auto-generated method stub
		if (!isEmpty()) {
			head = null;
			tail = null;
		}

		return true;
	}

	@Override
	public boolean contains(T o) {
		// TODO Auto-generated method stub

		if (o == null)
			throw new IllegalArgumentException("Data is not provided");

		Node curr = head;

		if (!isEmpty()) {
			do {
				if (curr.data == o)
					return true;

				curr = curr.next;
			} while (curr != head);
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

			do {
				if (curr.data == o)
					return position;

				curr = curr.next;
				position += 1;
			} while (curr != head);
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

			do {
				if (position == index) {
					if (prev == null) {
						head = curr.next;
						tail.next = head;
					} else
						prev.next = curr.next;

					curr.next = null;
					size--;
					return (T) curr.data;
				}

				prev = curr;
				curr = curr.next;
				position += 1;
			} while (curr != head);
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
			do {
				if (curr.data == o) {
					if (prev == null) {
						head = curr.next;
						tail.next = head;
					} else
						prev.next = curr.next;

					curr.next = null;
					size--;
					return (T) curr.data;
				}

				prev = curr;
				curr = curr.next;
			} while (curr != head);
		}

		return null;
	}

	@Override
	public boolean set(int index, T element) {
		// TODO Auto-generated method stub
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

			do {
				if (position == index) {
					if (prev == null) {
						head = newNode;
						tail = newNode;
						tail.next = head;
					} else
						prev.next = newNode;

					newNode.next = curr.next;
					return true;
				}

				prev = curr;
				curr = curr.next;
				position += 1;
			} while (curr != head);
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

			do {
				if (position >= fromIndex) {
					subList.add((T) curr.data);
				}

				if (position == toIndex) {
					return subList;
				}

				curr = curr.next;
				position += 1;
			} while (curr != head);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray(Class<T> componentType) {
		// TODO Auto-generated method stub
		T[] arrayOfLL = (T[]) Array.newInstance(componentType, size);
		Node curr = head;

		if (!isEmpty()) {
			int position = 0;

			do {
				arrayOfLL[position] = (T) curr.data;

				curr = curr.next;
				position += 1;
			} while (curr != head);
		}

		return arrayOfLL;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean swap(int position1, int position2) {
		// TODO Auto-generated method stub
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

			do {
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
			} while (curr != head);
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

		do {
			if (position > destinationPosition)
				break;
				
			if (position == destinationPosition) {
				prev = curr;
				newHead = curr.next;
			}

			curr = curr.next;
			position++;
		}while (curr != head);

		// once the previous item and new head are obtained, lets loop to end from the
		// new head
		// and attach the current head there and make new head as head
		if (prev != null) {
			// set to tail
			tail = prev;
			head = newHead;

			return true;
		}

		return false;
	}

}
