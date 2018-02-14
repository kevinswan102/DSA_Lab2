/**
 * @author chakkac5
 * test the generic circular linked list   
 */
public class TestCircularLinkedList {
	
	public static void runTest() {

		System.out.println("Creating an integer based circular linked list");
		System.out.println("-------------------------------------");
		MyCircularLinkedList<Integer> list = new MyCircularLinkedList<Integer>();

		System.out.println("Adding 2,3,5,6,8,9 to the list");
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(6);
		list.add(8);
		list.add(9);
		System.out.println("Adding completed");

		System.out.println("\nChecking isEmtpy() : " + list.isEmpty());

		System.out.println("\nPrint total items : " + list.size());

		System.out.println("\nAdd 7 at position 1 : " + list.add(1, 7));
		System.out.println("Printing new sequence of items after add 7 at position 1");
		Integer[] newlist = list.toArray(Integer.class);
		for (int i = 0; i < newlist.length; i++) {
			System.out.print(newlist[i] + ",");
		}
		System.out.print("\n");

		System.out.println("\nIndex of 7 : " + list.indexOf(7));
		System.out.println("\nIndex of 12 : " + list.indexOf(12));

		System.out.println("\nContains 5 : " + list.indexOf(5));
		System.out.println("\nContains 65 : " + list.indexOf(65));

		System.out.println("\nRemove 4 : " + list.remove((Integer) 4));

		System.out.println("\nRemove 6 : " + list.remove((Integer) 6));
		System.out.println("Printing new sequence of items after removing 6");
		newlist = list.toArray(Integer.class);
		for (int i = 0; i < newlist.length; i++) {
			System.out.print(newlist[i] + ",");
		}
		System.out.print("\n");

		System.out.println("\nRemove at position 2 : " + list.remove(2));
		System.out.println("Printing new sequence of items after remove at position 2");
		newlist = list.toArray(Integer.class);
		for (int i = 0; i < newlist.length; i++) {
			System.out.print(newlist[i] + ",");
		}
		System.out.print("\n");

		System.out.println("\nSwap items 1 and 3 : " + list.swap(1, 3));
		System.out.println("Printing new sequence of items after swap");
		newlist = list.toArray(Integer.class);
		for (int i = 0; i < newlist.length; i++) {
			System.out.print(newlist[i] + ",");
		}
		System.out.print("\n");

		System.out.println("\nShifting items +1 : " + list.shift(1));
		System.out.println("Printing new sequence of items after +shift ");
		newlist = list.toArray(Integer.class);
		for (int i = 0; i < newlist.length; i++) {
			System.out.print(newlist[i] + ",");
		}
		System.out.print("\n");

		System.out.println("\nShifting items -2 : " + list.shift(-2));
		System.out.println("Printing new sequence of items after -shift ");
		newlist = list.toArray(Integer.class);
		for (int i = 0; i < newlist.length; i++) {
			System.out.print(newlist[i] + ",");
		}
		System.out.print("\n");

		System.out.println("\nSublist of items 2-5");
		MyLinkedList<Integer> subList = (MyLinkedList<Integer>) list.subList(2, 5);
		System.out.println("Printing new items from sub list ");
		newlist = subList.toArray(Integer.class);
		for (int i = 0; i < newlist.length; i++) {
			System.out.print(newlist[i] + ",");
		}
		System.out.print("\n");
	}
}
