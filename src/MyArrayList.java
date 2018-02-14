/**
 * @author Kswann
 *implementing the interface to a generic array list 
 */

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {

	private Object[] list;

	private int size;
	
	public MyArrayList() {
		list = new Object[100]; // new Song, T's will be replaced with Song
		size = 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(int index, T o) {
		if (index < 1 || index > size) {
			throw new ArithmeticException("Index out of bounds");
		}
		
		if (list.length == size)
		{
			Object[] list2 = new Object[size * 2];
			System.arraycopy(list, 0, list2, 0, list.length);
			list = list2;
		}
		
		T tempValue = (T)list[index-1];
		
		list[index-1] = o;
		list[size] = tempValue;
		
		size++;
		
		if (list[index-1] == o)
			return true;
		else
			return false;
	}

	@Override
	public boolean add(T o) {
		
		if (list.length == size)
		{
			Object[] list2 = new Object[size * 2];
			System.arraycopy(list, 0, list2, 0, list.length);
			list = list2;
		}
		list[size] = o;
		size++;
		
		return true;
	}

	@Override
	public boolean clear() {
		Arrays.fill(list, null);
		size=0;
		if (list.length == 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean contains(T o) {
		for (int i = 0; i < size; i++) {
			if (list[i] == o) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {

		if (index < 1 || index > size) {
			throw new ArithmeticException("Index out of bounds");
		}
		
		return (T)list[index-1]; 
	}

	@Override
	public int indexOf(T o) {

		return Arrays.asList(list).indexOf(o);
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else
			return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) {
		if (index < 1 || index > size) {
			throw new ArithmeticException("Index out of bounds");
		}
		
		T tempValue = (T)list[index - 1];
		list[index - 1] = list[size - 1];
		list[size - 1] = null;
		size--;
		return tempValue;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(T o) {

		for (int i = 0; i < size; i++) {
			if (list[i].equals(o)) {
				T tempValue = (T)list[i];
				list[i] = list[size -1];
				list[size - 1] = null;
				size--;
				return tempValue;
			}
		}
		return null;
	}

	@Override
	public boolean set(int index, T element) {
		if (index < 1 || index > size) {
			throw new ArithmeticException("Index out of bounds");
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public MyList<T> subList(int fromIndex, int toIndex) {

		if (fromIndex < 1 || fromIndex > size || toIndex < 1 || toIndex > size) {
			throw new ArithmeticException("Index out of bounds");
		}

		T[] subArray = (T[])Arrays.copyOfRange(list, fromIndex -1, toIndex);

		MyArrayList<T> subList = new MyArrayList<T>();
		for (int i =0; i<subArray.length; i++)
		{
			subList.add(subArray[i]);
		}
		
		return subList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray(Class<T> componentType) {
		T[] arrayOfList = (T[])Array.newInstance(componentType, size);
		
		for (int i = 0; i < size; i++) {
			arrayOfList[i] = (T)list[i];
		}
		
		return arrayOfList;
	}

	@Override
	public boolean swap(int position1, int position2) {
		if (position1 < 1 || position1 >= size || position2 < 1 || position2 >= size) {
			throw new ArithmeticException("Index out of bounds");
		}

		Object temp = list[position1 - 1];
		list[position1 - 1] = list[position2 - 1];
		list[position2 - 1] = temp;

		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean shift(int positions) {
		if (Math.abs(positions) > size)
			throw new ArithmeticException("Index out of bounds");
		
		
		if (positions >= 0) {
			
			MyArrayList<T> newList = (MyArrayList<T>)subList(positions+1, size);
			
			for (int i =0; i < positions; i++) {
				newList.add((T)list[i]);
			}
			
			list = newList.list;
		}
		else if (positions < 0) {
			MyArrayList<T> firstList = (MyArrayList<T>)subList(size + positions + 1, size);
			MyArrayList<T> secondList = (MyArrayList<T>)subList(1 , size + positions);
			
			T[] result = (T[])Arrays.copyOf(firstList.list, size);
			System.arraycopy(secondList.list, 0, result, firstList.size, secondList.size);
			
			list = result;
		}

		return true;
	}

}
