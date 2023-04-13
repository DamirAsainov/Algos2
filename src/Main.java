public class Main {
    public static void main(String[] args) {
        ListByDamir<String> list = new ListByDamir<>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("TEST", 2);
        list.add("TEST");
        System.out.println(list.get(0));
        System.out.println(list.contains("2"));
        for(int i = 0; i < list.getSize(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println("\n" + list.indexOf("TEST"));
        System.out.println(list.lastIndexOf("TEST"));
    }
}