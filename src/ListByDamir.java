import java.util.Objects;

public class ListByDamir<T> implements MyList {
    private Object[] array;
    private int size;
    public ListByDamir(){array = new Object[5];}

    private void swap(int index1, int index2){
        Object temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
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
    @Override
    public void add(Object item) {
        if(size == array.length - 1)
            increaseBuffer();
        this.array[size++] = item;
    }

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
    @Override
    public void clear() {
        this.array = (T[]) new Object[5];
        this.size = 0;
    }
    @Override
    public Object get(int index) {
        checkIndex(index);
        return (T) array[index];
    }
    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < size; i++){
            if(Objects.equals(o, array[i]))
                return i;
        }
        return -1;
    }
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
    public void print(){
        for(int i = 0; i < size; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
