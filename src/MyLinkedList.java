public class MyLinkedList<T> implements MyList {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList(){}

    public int getSize(){
        return size;
    }
    @Override
    public boolean contains(Object o) {
        MyNode<T> currentNode = head;
        for (int i = 0; i < size; i++){
            if(currentNode.data == o){
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }
    @Override
    public void add(Object item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null)
            head = tail = newNode;
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(Object item, int index) {
//        MyNode<T> curNode = head;
//        MyNode<T> newNode = new MyNode<>(item);
//        for(int i = 0; i < index; i++){
//            curNode = curNode.next;
//        }
//        MyNode<T> nextNode = curNode.next.next;
//        curNode.next = newNode;
//        nextNode.next = nextNode;
//        size++;
    }
    @Override
    public Object remove(int index) {
        Object removeObj;
        if(index == 0){
            removeObj = head.data;
            head.next.prev = null;
            head = head.next;
            size--;
            return removeObj;
        }
        if(index == size - 1){
            removeObj = tail.data;
            tail.prev.next = null;
            tail = tail.prev;
            size--;
            return removeObj;
        }
        MyNode<T> currentNode = head;
        for(int i = 0; i < index - 1; i++){
            currentNode = currentNode.next;
        }
        removeObj = currentNode.next.data;
        currentNode.next.next.prev = currentNode;
        currentNode.next = currentNode.next.next;
        size--;
        return removeObj;
    }
    @Override
    public boolean remove(Object item) {
        if(item == head.data){
            head.next.prev = null;
            head = head.next;
            size--;
            return true;
        }
        MyNode<T> currentNode = head;
        for(int i = 0; i < size - 2;i++){
            if (currentNode.next.data == item){
                currentNode.next.next.prev = currentNode;
                currentNode.next = currentNode.next.next;
                size--;
                return true;
            }
            currentNode = currentNode.next;
        }
        if(tail.data == item){
            tail.prev.next = null;
            //MyNode<T> newTail = tail.prev;
            tail = tail.prev;
            size--;
        }
        return false;
    }
    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
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
        MyNode<T> currentNode = head;
        for(int i = 0; currentNode != null; i++){
            if(o == currentNode.data)
                return i;
            currentNode = currentNode.next;
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Object o) {
        MyNode<T> currentNode = tail;
        for(int i = size - 1; i >= 0; i--){
            if(o == currentNode.data)
                return i;
            currentNode = currentNode.prev;
        }
        return -1;
    }
    @Override
    public void sort() {

    }
}
