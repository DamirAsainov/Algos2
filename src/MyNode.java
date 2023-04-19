public class MyNode<T> {
    Object data;
    MyNode<T> next;
    MyNode<T> prev;
    MyNode(Object data){
        this.data = data;
        next = null;
    }
}
