import java.util.ArrayList;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("7");
        linkedList.add("5");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("7");
        linkedList.add("6");
        linkedList.add("1");
        linkedList.add("0");
        linkedList.add("81", 1);
        System.out.println(linkedList.getSize());
        for(int i = 0; i < linkedList.getSize(); i++){
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
        linkedList.remove("4");
        System.out.println(linkedList.remove(0));
        for(int i = 0; i < linkedList.getSize(); i++){
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
        System.out.println(linkedList.indexOf("5"));
        System.out.println(linkedList.lastIndexOf("5"));
        System.out.println(linkedList.contains("7"));
        linkedList.sort();
        for(int i = 0; i < linkedList.getSize(); i++){
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
        for(int i = 0; i < linkedList.getSize(); i++){
            System.out.print(linkedList.get(i) + " ");
        }
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.print();
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(124);
        nums.add(125);
        nums.add(126);
        arrayList.addAll(nums, 3);
        arrayList.print();
        System.out.println("/////////");

        for(int i = 0; i < linkedList.getSize(); i++){
            System.out.print(linkedList.get(i) + " ");
        }
        ArrayList<String> str = new ArrayList<>();
        str.add("123");
        str.add("124");
        str.add("125");
        linkedList.addAll(str, 3);
        System.out.println();
        for(int i = 0; i < linkedList.getSize(); i++){
            System.out.print(linkedList.get(i) + " ");
        }
    }
}