public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("0");
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        linkedList.add("6");
        linkedList.add("7");
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
    }
}