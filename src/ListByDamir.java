import java.util.Objects;

public class ListByDamir<T> implements MyList {
    private Object[] array;
    private int size;
    public ListByDamir(){array = new Object[5];}

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
        if(size == array.length)
            increaseBuffer();
        this.array[size++] = item;
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
        return false;
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
        return 0;
    }
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }
    @Override
    public void sort() {

    }
}
