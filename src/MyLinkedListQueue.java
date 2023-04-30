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
    public Object dequeue(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.removeFirst();
    }
    public Object peek(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.get(0);
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public int size(){
        return list.getSize();
    }

}
