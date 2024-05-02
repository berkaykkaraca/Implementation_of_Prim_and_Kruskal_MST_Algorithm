import java.util.LinkedList;
public class Queue<T> {
	private LinkedList<T> items = new LinkedList<>();

    // Add an item to the end of the queue
    public void enqueue(T item) {
        items.addLast(item);
    }

    // Remove and return the item at the front of the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return items.removeFirst();
    }

    // Peek at the item at the front of the queue without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return items.getFirst();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Get the size of the queue
    public int size() {
        return items.size();
    }

    // Print the elements of the queue
    public void printQueue() {
        System.out.println(items);
    }
}
