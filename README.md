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


