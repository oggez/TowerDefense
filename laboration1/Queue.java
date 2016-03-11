package laboration1;

public interface Queue<T> {
	
	public void add(T add);

	public T remove();

	public T element();

	public boolean isEmpty();

	public int size();
}
