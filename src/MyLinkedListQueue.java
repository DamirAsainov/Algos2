import java.util.NoSuchElementException;
public class MyLinkedListQueue<T> {
    private MyLinkedList<T> list = null;
    public MyLinkedListQueue(){
        list = new MyLinkedList<>();
    }
    public MyLinkedListQueue(MyLinkedList<T> linkedList){
        list = linkedList;
    }
    public void enqueue(Object item){
        list.add(item);
    }
    /*
     Inserts the specified element at the end of this queue.
     @param item the element to add
     */
    public Object dequeue(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.removeFirst();
    }
    /*
     Retrieves and removes the head of this queue.
     @return the head of this queue
     @throws NoSuchElementException if this queue is empty
     */
    public Object peek(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.get(0);
    }
    /*
     Retrieves, but does not remove, the head of this queue,
     or returns null if this queue is empty.
     @return the head of this queue, or null if this queue is empty
     */
    public boolean isEmpty(){
        return size() == 0;
    }
    /*
     Returns true if this queue contains no elements.
     @return true if this queue contains no elements, false otherwise
     */
    public int size(){
        return list.getSize();
    }
    /*
     Returns the number of elements in this queue.
     @return the number of elements in this queue
     */

}
