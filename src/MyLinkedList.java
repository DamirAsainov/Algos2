public class MyLinkedList<T> implements MyList {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList(){};

    public int getSize(){
        return -1;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }
    @Override
    public void add(Object item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null)
            head = tail = newNode;
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    @Override
    public void add(Object item, int index) {

    }
    @Override
    public Object remove(int index) {

        return null;
    }
    @Override
    public boolean remove(Object item) {

        return true;
    }
    @Override
    public void clear() {

    }
    @Override
    public Object get(int index) {
        MyNode<T> curNode = head;
        for (int i = 0; i < index;i++){
            curNode = curNode.next;
        }
        return curNode.data;
    }
    @Override
    public int indexOf(Object o) {

        return -1;
    }
    @Override
    public int lastIndexOf(Object o) {
        return -1;
    }
    @Override
    public void sort() {

    }
}
