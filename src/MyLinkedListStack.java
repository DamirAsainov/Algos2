import java.util.EmptyStackException;

public class MyLinkedListStack<T> {
    private MyLinkedList<T> list = null;

    public MyLinkedListStack() {
        list = new MyLinkedList<T>();
    }

    public void push(T item) {
        list.addFirst(item);
    }
    /*
     Adds an element to the top of the stack.
     @param item the element to add
     */
    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.removeFirst();
    }
    /*
     Removes and returns the top element of the stack.
     @return the top element of the stack
     @throws EmptyStackException if the stack is empty
     */

    public Object peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(0);
    }
    /*
     Returns the top element of the stack without removing it.
     @return the top element of the stack
     @throws EmptyStackException if the stack is empty
     */

    public boolean isEmpty() {
        return size() == 0;
    }
    /*
     Returns true if the stack is empty or false if it is not.
     @return true if the stack is empty or false if it is not
     */

    public int size() {
        return list.getSize();
    }
    /*
     Returns the number of elements in the stack.
     @return the number of elements in the stack
     */
}