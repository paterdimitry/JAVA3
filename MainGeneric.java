package lesson1.task1and2;

public class MainGeneric {
    public static void main(String[] args) {
        Generic<String> array = new Generic<>(5);
        array.add("A",0);
        array.add("B",1);
        array.add("C",2);
        array.add("D",3);
        array.add("E",4);

        array.exchange(2,4);
        System.out.println(array.convertArrayToArraylist().toString());
    }


}
