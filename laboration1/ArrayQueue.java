package laboration1;

public class ArrayQueue<T> implements Queue<T> {
	private T[] elements;
	private int size = 0;

	public ArrayQueue() {
		this(10);
	}

	public ArrayQueue(int capacity) {
		elements = (T[]) (new Object[capacity]);
	}

	public void add(T element) {
		if (size == elements.length) {
			throw new QueueException("Fullt i kön");
		}
		elements[size] = element;
		size++;
	}

	public T remove() {
		if (isEmpty()) {
			throw new QueueException("Tomt i kön");
		}
		T ret = elements[0];
		size--;
		for (int i = 0; i < size; i++) {
			elements[i] = elements[i + 1];
		}
		elements[size] = null;
		return ret;
	}

	public T element() {
		return elements[0];
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
		Integer elem;
		for (int i = 0; i < 10; i++) {
			queue.add(new Integer(i));
		}
		while (!queue.isEmpty()) {
			elem = queue.remove();
			System.out.print(elem + " ");
		}
	}
}
