import java.util.Objects;

public class MyArrayList<T> implements MyList {
    private Object[] array;
    private int size;
    public MyArrayList(){array = new Object[5];}
    private void increaseBuffer(){
        T[] newArr = (T[]) new Object[array.length + 5];
        for(int i=0; i< array.length; i++){
            newArr[i]= (T) array[i];
        }
        array = newArr;
    }
    /*Increases the capacity of this ArrayList instance, if necessary, to ensure that it can hold at least the number of elements specified by the minimum capacity argument.*/
    private void checkIndex(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }
    public int getSize(){
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < size; i++){
            if(Objects.equals(o, array[i]))
                return true;
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
        if(size == array.length - 1)
            increaseBuffer();
        this.array[size++] = item;
    }
    /*
        @ add(Object item) - Appends the specified element to the end of this list.
        @ item - element to be appended to this list
     */

    @Override
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
    /*
        @ add(Object item, int index) - Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any) and any subsequent elements to the right
        @ item - element to be inserted
        @ index -  index at which the specified element is to be inserted
     */

    @Override
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
    /*
        @ remove(int index) - Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices).
        @ index -  the index of the element to be removed
        @ return - the element that was removed from the list
     */

    @Override
    public boolean remove(Object item) {
        if(!contains(item))
            return false;
        for(int i = 0; i < size; i++){
            if(Objects.equals(item, array[i])){
                remove(i--);
            }
        }
        return true;
    }
    /*
        @ remove(Object item) - Removes the first occurrence of the specified element from this list, if it is present. If the list does not contain the element, it is unchanged.
        @ item -  element to be removed from this list, if present
        @ return - true if this list contained the specified element
     */

    @Override
    public void clear() {
        this.array = (T[]) new Object[5];
        this.size = 0;
    }
    /*
         @ Removes all of the elements from this list. The list will be empty after this call returns.
     */

    @Override
    public Object get(int index) {
        checkIndex(index);
        return (T) array[index];
    }
    /*
        @ get(int index) - Removes the first occurrence of the specified element from this list, if it is present. If the list does not contain the element, it is unchanged.
        @ index -  index of the element to return
        @ return - the element at the specified position in this list
     */

    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < size; i++){
            if(Objects.equals(o, array[i]))
                return i;
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
        for(int i = size - 1; i >= 0; i--){
            if(Objects.equals(o, array[i]))
                return i;
        }
        return -1;
    }
    @Override
    public void sort() {
        for(int i = 0; i < size - 1; i++){
            for(int j = 0; j < size - i - 1;j++){
                if(Objects.compare(Objects.toString(array[j + 1]), Objects.toString(array[j]), String::compareTo) < 0){
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    /*
        @ LastIndexOf(Object o) - Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
        @ o - element to search for
        @ return - the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element
     */

    public void print(){
        for(int i = 0; i < size; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
