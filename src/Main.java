public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("0");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        System.out.println(linkedList.getSize());
        for(int i = 0; i < linkedList.getSize(); i++){
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
        linkedList.remove("2");
        for(int i = 0; i < linkedList.getSize(); i++){
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
        System.out.println(linkedList.indexOf("3"));
        System.out.println(linkedList.lastIndexOf("0"));

    }
}