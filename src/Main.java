public class Main {
    public static void main(String[] args) {
        ListByDamir<String> list = new ListByDamir<>();
        list.add("test");
        list.add("rest");
        System.out.println(list.get(1));
    }
}