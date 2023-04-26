# Assignment 2 Documentaion
## 
# MyList interface
**Description**: This interface defines a set of methods that a class should implement if it wants to behave like a List. It specifies the common methods that are available in most List implementations, such as adding and removing elements, getting the size of the List, retrieving an element at a specific index, and checking if an element exists in the List*
```java
public interface MyList<T>{
    int getSize();
    boolean contains(Object o);
    void add(T item);
    void add(T item, int index);
    boolean remove(T item);
    T remove(int index);
    void clear();
    T get(int index);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    void sort();
}
```

# MyArrayList
## Fields
`array` - storing place

`size` - contain actual length of list
```java
private Object[] array;
private int size;
```

## Private Methods
`increaseBuffer` - Increases the capacity of this ArrayList instance, if necessary, to ensure that it can hold at least the number of elements specified by the minimum capacity argument.

`checkIndex` - check for correct input index and return true or false
```java
    private void increaseBuffer(){
        T[] newArr = (T[]) new Object[array.length + 5];
        for(int i=0; i< array.length; i++){
            newArr[i]= (T) array[i];
        }
        array = newArr;
    }
    private void checkIndex(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }
```

## Public Methods from interface
`getSize` - just return size of list 

```java
public int getSize(){
        return size;
    }
```

`contains` - check if this list contains the specified element

`contains` - using a loop, iterate through all the values of the array and compares with the object `o`

`o` - element whose presence in this list is to be tested

`return`- true if this list contains the specified element

```java
public boolean contains(Object o) {
        for(int i = 0; i < size; i++){
            if(Objects.equals(o, array[i]))
                return true;
        }
        return false;
    }
```
`add(Object item)` - Appends the specified element to the end of this list.

`item` - element to be appended to this list
```java
public void add(Object item) {
        if(size == array.length - 1)
            increaseBuffer();
        this.array[size++] = item;
    }
```
`add(Object item, int index)` - Appends the specified element to the end of this list.

`add` - first checkIndex, second if need increase buffer, then by for loop move elements one index forward, set `item` in index and increase `size` 

`item` - element to be inserted

`index` - index at which the specified element is to be inserted
```java
public void add(Object item, int index) {
        checkIndex(index);
        if(size == array.length)
            increaseBuffer();
        for(int i = size; i > index; i--){
            Object temp = array[i];
            array[i] = array[i - 1];
            array[i - 1] = temp;
        }
        array[index] = item;
        size++;
    }
```
`remove(int index)` - Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices)

`remove` -  by for loop move elements one index back until size

`index` -  the index of the element to be removed

`return` - the element that was removed from the list
```java
public Object remove(int index) {
        Object retObj = array[index];
       for(int i = index;i < size; i++){
           Object temp = array[i + 1];
           array[i + 1] = array[i];
           array[i] = temp;
       }
       size--;
       return retObj;
    }
```
`remove(Object item))` -Removes the first occurrence of the specified element from this list, if it is present. If the list does not contain the element, it is unchanged

`remove` -  first check for contains of object, then by for loop search them and removes by index

`item` - element to be removed from this list, if present

`return` - true if this list contained the specified element
```java
if(!contains(item))
            return false;
        for(int i = 0; i < size; i++){
            if(Objects.equals(item, array[i])){
                remove(i--);
            }
        }
        return true;
```
`clear()` - Removes all of the elements from this list. The list will be empty after this call returns.
```java
 public void clear() {
        this.array = (T[]) new Object[5];
        this.size = 0;
    }
```
`get(int index)` - Removes the first occurrence of the specified element from this list, if it is present. If the list does not contain the element, it is unchanged.

`get` -  first check for index, then return element from `array`

`index` -  index of the element to return

`return` - the element at the specified position in this list
```java
public Object get(int index) {
        checkIndex(index);
        return (T) array[index];
    }
```
`indexOf(Object o)` - Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.

`indexOF` -  by loop search first same element in `array`

`o` - element to search for

`return` - the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
```java
public int indexOf(Object o) {
        for(int i = 0; i < size; i++){
            if(Objects.equals(o, array[i]))
                return i;
        }
        return -1;
    }
```
`lastIndexOf(Object o) - Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.

`lastIndexOF` -  by loop search last same element in `array`

`o` - element to search for

`return` - the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element
```java
public int lastIndexOf(Object o) {
        for(int i = size - 1; i >= 0; i--){
            if(Objects.equals(o, array[i]))
                return i;
        }
        return -1;
    }
```

# MyLinkedList 
## MyNode
```java
public class MyNode<T> {
    Object data;
    MyNode<T> next;
    MyNode<T> prev;
    MyNode(Object data){
        this.data = data;
        next = null;
    }
}
```
## Fields
`head` - first node

`tail` - last node

`size` - size of linked list
```java
private MyNode<T> head;
private MyNode<T> tail;
private int size;
```

## Public Methods from interface
`getSize` - just return size of list 

```java
public int getSize(){
        return size;
    }
```

`contains` - check if this list contains the specified element

`contains` - using a loop and checking each element's data field to see if it matches the object. If a match is found, the method returns true. If the loop completes without finding a match, the method returns false.

`o` - element whose presence in this list is to be tested

`return`- true if this list contains the specified element

```java
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
```
`add(Object item)` - Appends the specified element to the end of this list.

`add` - This method adds a new node with the given item to the end of the linked list. If the list is currently empty, the new node becomes both the head and the tail of the list. Otherwise, the new node is appended to the end of the list by setting its prev reference to the current tail, setting the current tail's next reference to the new node, and finally updating the tail reference to point to the new node. The size of the list is also incremented.

`item` - element to be appended to this list
```java
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
```
`add(Object item, int index)` - Appends the specified element to the end of this list.

`add` - If the index is 0, the new node becomes the `head` of the list. If the index is equal to the size of the list minus 1, the new node becomes the `tail` of the list. Otherwise, the method iterates through the list to find the node at the index before the insertion point and inserts the new node after it.

`item` - element to be inserted

`index` - index at which the specified element is to be inserted
```java
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
```
`remove(int index)` - Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices)

`remove` -  the method first checks if the index is the first or last node in the list, and if so, it removes the node accordingly. Otherwise, it uses a loop to traverse the list to the node at the index just before the one being removed.

`index` -  the index of the element to be removed

`return` - the element that was removed from the list
```java
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
```
`remove(Object item))` -Removes the first occurrence of the specified element from this list, if it is present. If the list does not contain the element, it is unchanged

`remove` -  If the index is 0, the new element becomes the head of the list. If the index is the last element, the new element becomes the tail of the list. Otherwise, the code iterates through the list until it reaches the node before the desired index and inserts the new element after that node. The size of the list is incremented after the new element is added.

`item` - element to be removed from this list, if present

`return` - true if this list contained the specified element
```java
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
```
`clear()` - Removes all of the elements from this list. The list will be empty after this call returns.
```java
 public void clear() {
        size = 0;
        head = null;
        tail = null;
    }
```
`get(int index)` - Removes the first occurrence of the specified element from this list, if it is present. If the list does not contain the element, it is unchanged.

`get` -  It starts at the head of the linked list. It iterates through the linked list by following the next pointers of each node until it reaches the node at the specified index

`index` -  index of the element to return

`return` - the element at the specified position in this list
```java
public Object get(int index) {
        MyNode<T> curNode = head;
        for (int i = 0; i < index;i++){
            curNode = curNode.next;
        }
        return curNode.data;
    }
```
`indexOf(Object o)` - Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.

`indexOF` -  It starts from the head of the list and iterates through each node until it finds the node with the data that matches the specified element. If a match is found, it returns the index (position) of that node in the list. If it reaches the end of the list without finding a match, it returns -1.

`o` - element to search for

`return` - the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
```java
public int indexOf(Object o) {
        MyNode<T> currentNode = head;
        for(int i = 0; currentNode != null; i++){
            if(o == currentNode.data)
                return i;
            currentNode = currentNode.next;
        }
        return -1;
    }
```
`lastIndexOf(Object o) - Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.

`lastIndexOF` -  The method starts from the tail of the list and iterates backwards using the prev pointer of each node. It compares the data of each node to the specified object and returns the index of the last occurrence if found, or -1 if not found.

`o` - element to search for

`return` - the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element
```java
public int lastIndexOf(Object o) {
        MyNode<T> currentNode = tail;
        for(int i = size - 1; i >= 0; i--){
            if(o == currentNode.data)
                return i;
            currentNode = currentNode.prev;
        }
        return -1;
    }
```



