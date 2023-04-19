public class Main {
    public static void main(String[] args) {
        ListByDamir<String> list = new ListByDamir<>();
        list.add("0");
        list.add("1.123");
        list.add("-2");
        list.add("3");
        list.add("4");
        list.add("TEST", 2);
        list.add("1");
        list.add("TEST");
        System.out.println(list.get(0));
        System.out.println(list.contains("2"));
        list.print();
        System.out.println(list.indexOf("TEST"));
        System.out.println(list.lastIndexOf("TEST"));
        list.sort();
        list.print();

        ListByDamir<Integer> intList = new ListByDamir<>();
        intList.add(129);
        intList.add(-3);
        intList.add(0);
        intList.add(-18);
        intList.add(14);
        intList.sort();
        intList.print();
        System.out.println(intList.remove(3));
        intList.print();
    }
}