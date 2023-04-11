public class Main {
    public static void main(String[] args) {
        ListByDamir<String> list = new ListByDamir<>();
        list.add("test");
        list.add("2");
        System.out.println(list.get(0));
        System.out.println(list.contains("2"));
    }
}