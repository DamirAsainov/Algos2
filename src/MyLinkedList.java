import java.util.ArrayList;
import java.util.Objects;

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
    /*
           @ contains - check if this list contains the specified element.
           @ o - element whose presence in this list is to be tested
           @ return - true if this list contains the specified element
        */

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
    /*
        @ add(Object item) - Appends the specified element to the end of this list.
        @ item - element to be appended to this list
     */


    @Override
    public void add(Object item, int index) {
        MyNode<T> newNode = new MyNode<>(item);
        if(index == 0){
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        if(index == size - 1){
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
        MyNode<T> currentNode = head;
        for(int i = 0; i < index - 1; i++){
            currentNode = currentNode.next;
        }
        newNode.prev = currentNode;
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        size++;
    }
    /*
        @ add(Object item, int index) - Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any) and any subsequent elements to the right
        @ item - element to be inserted
        @ index -  index at which the specified element is to be inserted
     */
    public void addAll(ArrayList<T> items, int index){
        MyNode<T> newNode = new MyNode<>(items.get(0));
        MyNode<T> currentNode = new MyNode<>(items.get(0));
        for(int i = items.size() - 1;i > 0; i--){
            currentNode.data = items.get(i);
            currentNode.prev = newNode;
            currentNode.prev.next = currentNode;
            currentNode = currentNode.prev;
        }
        currentNode.prev = newNode;
        newNode.next = currentNode;
        currentNode = head;

        for(int i = 0; i < index - 1; i++){
            currentNode = currentNode.next;
        }
        newNode.prev = currentNode;
        currentNode.next = newNode;

        size = size + items.size();
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
    /*
        @ remove(int index) - Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices).
        @ index -  the index of the element to be removed
        @ return - the element that was removed from the list
     */

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
    /*
        @ remove(Object item) - Removes the first occurrence of the specified element from this list, if it is present. If the list does not contain the element, it is unchanged.
        @ item -  element to be removed from this list, if present
        @ return - true if this list contained the specified element
     */

    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }
    /*
         @ clear() - Removes all of the elements from this list. The list will be empty after this call returns.
     */

    @Override
    public Object get(int index) {
        MyNode<T> curNode = head;
        for (int i = 0; i < index;i++){
            curNode = curNode.next;
        }
        return curNode.data;
    }
    /*
        @ get(int index) - Removes the first occurrence of the specified element from this list, if it is present. If the list does not contain the element, it is unchanged.
        @ index -  index of the element to return
        @ return - the element at the specified position in this list
     */

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
    /*
        @ indexOf(Object o) - Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
        @ o - element to search for
        @ return - the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     */

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
    /*
        @ LastIndexOf(Object o) - Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
        @ o - element to search for
        @ return - the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element
     */

    @Override
    public void sort() {
        MyNode<T> currentNode = head;
        MyNode<T> index;
        Object temp;
        if(head == null)
            return;
        while (currentNode != null){
            index = currentNode.next;
            while (index != null){
                if(Objects.compare(Objects.toString(currentNode.data), Objects.toString(index.data), String::compareTo) > 0){
                    temp = currentNode.data;
                    currentNode.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            currentNode = currentNode.next;

        }
    }
    public void addFirst(Object item){
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;

    }
    public Object removeFirst(){
        if (head == null) {
            return null;
        }
        Object res = head.data;
        MyNode<T> removedNode = head;
        head = removedNode.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return res;
    }
}
