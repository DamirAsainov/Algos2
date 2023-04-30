import java.util.EmptyStackException;

public class MyLinkedListStack<T> {
    private MyLinkedList<T> list = null;

    public MyLinkedListStack() {
        list = new MyLinkedList<T>();
    }

    public void push(T item) {
        list.addFirst(item);
    }

    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.removeFirst();
    }

    public Object peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return list.getSize();
    }
}